import config.AppSetting;
import dao.AddressObjectDao;
import dao.AddressObjectDaoAsList;
import dao.dto.AddressObjectXMLConverter;
import domain.AddressObject;
import service.AddressFormatter;
import service.AddressFormatterImpl;
import service.AddressService;
import service.AddressServiceImpl;

import java.util.List;

public class DemoTask1 {
    public static void main(String[] args) {

        AppSetting appSetting = new AppSetting("AS_ADDR_OBJ.XML", "AS_ADM_HIERARCHY.XML");
        AddressObjectXMLConverter addressObjectXMLConverter = new AddressObjectXMLConverter(appSetting);
        AddressObjectDao addressObjectDao = new AddressObjectDaoAsList(addressObjectXMLConverter.convert());
        AddressFormatter addressFormatter = new AddressFormatterImpl();
        AddressService addressService = new AddressServiceImpl(addressObjectDao);
        
        List<AddressObject> addressObjects = addressService.getAddressObjects("2010-01-01", "1422396, 1450759, 1449192, 1451562");
        System.out.println(addressFormatter.format(addressObjects));

    }
}
