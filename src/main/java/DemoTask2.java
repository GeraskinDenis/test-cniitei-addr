import config.AppSetting;
import dao.AddressHierarchyDao;
import dao.AddressHierarchyDaoAsList;
import dao.AddressObjectDao;
import dao.AddressObjectDaoAsList;
import dao.dto.AddressHierarchyXMLConverter;
import dao.dto.AddressObjectXMLConverter;
import domain.AddressObject;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTask2 {
    public static void main(String[] args) {

        AppSetting appSetting = new AppSetting("AS_ADDR_OBJ.XML", "AS_ADM_HIERARCHY.XML");
        AddressObjectXMLConverter addressObjectXMLConverter = new AddressObjectXMLConverter(appSetting);
        AddressObjectDao addressObjectDao = new AddressObjectDaoAsList(addressObjectXMLConverter.convert());
        AddressService addressService = new AddressServiceImpl(addressObjectDao);

        AddressHierarchyXMLConverter addressHierarchyXMLConverter = new AddressHierarchyXMLConverter(appSetting);
        AddressHierarchyDao hierarchyDao = new AddressHierarchyDaoAsList(addressHierarchyXMLConverter.convert());
        AddressHierarchyService addressHierarchyService = new AddressHierarchyServiceImpl(hierarchyDao);

        List<List<AddressObject>> addresses = new ArrayList<>();
        List<AddressObject> addressObjects = addressService.getAllActualByTypeName("проезд");
        for (AddressObject addressObject : addressObjects) {
            List<Integer> allHierarchy = addressHierarchyService.getAllHierarchy(addressObject);
            addresses.add(addressService.getAllActualByAddressObjectsId(allHierarchy));
        }

        AddressFormatter formatter = addressObject -> addressObject.stream()
                .map((e) -> String.join(" ", e.getTypeName(), e.getName())).collect(Collectors.joining(", "));
        addresses.stream().map(formatter::format).forEach(System.out::println);

    }
}
