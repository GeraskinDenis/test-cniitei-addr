package dao.dto;

import config.AddressObjectFileNameProvider;
import domain.AddressObject;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AddressObjectXMLConverter {

    private final AddressObjectFileNameProvider fileNameProvider;

    public List<AddressObject> convert() {

        List<AddressObject> addressObjects;

        String fileName = fileNameProvider.getAddressObjectFileName();

        try (InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName))) {
            JAXBContext context = JAXBContext.newInstance(AddressObjectListDto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AddressObjectListDto addressObjectListDto = (AddressObjectListDto) unmarshaller.unmarshal(inputStream);
            addressObjects = addressObjectListDto.getList().stream().map(AddressObjectDto::toDomainObject).toList();
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }

        return addressObjects;
    }
}
