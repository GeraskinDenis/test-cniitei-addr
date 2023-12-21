package service;

import domain.AddressObject;

import java.util.Date;
import java.util.List;

public interface AddressService {
    AddressObject getAddressObject(Date date, int addressId);

    List<AddressObject> getAddressObjects(Date date, List<Integer> addressesId);

    List<AddressObject> getAllActualByTypeName(String typeName);

    List<AddressObject> getAddressObjects(String dateStr, String addressesIdStr);

    List<AddressObject> getAllActualByAddressObjectsId(List<Integer> addressObjectsId);
}
