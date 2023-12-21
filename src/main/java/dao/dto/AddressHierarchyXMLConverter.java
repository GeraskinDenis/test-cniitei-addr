package dao.dto;

import config.AddressHierarchyFileNameProvider;
import domain.AddressHierarchy;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AddressHierarchyXMLConverter {

    private final AddressHierarchyFileNameProvider fileNameProvider;

    public List<AddressHierarchy> convert() {

        List<AddressHierarchy> addressHierarchies;

        String fileName = fileNameProvider.getAddressHierarchyFileName();

        try (InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName))) {
            JAXBContext context = JAXBContext.newInstance(AddressesHierarchyItemsDto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AddressesHierarchyItemsDto addressesHierarchyItems = (AddressesHierarchyItemsDto) unmarshaller.unmarshal(inputStream);
            addressHierarchies = addressesHierarchyItems.getItems().stream().map(AddressHierarchyDto::toDomainObject).toList();
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }

        return addressHierarchies;
    }
}
