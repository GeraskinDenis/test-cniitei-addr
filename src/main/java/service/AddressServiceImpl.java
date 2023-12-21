package service;

import dao.AddressObjectDao;
import domain.AddressObject;
import exception.AddressServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private final AddressObjectDao addressObjectDao;

    public AddressServiceImpl(AddressObjectDao addressObjectDao) {
        this.addressObjectDao = addressObjectDao;
    }

    @Override
    public AddressObject getAddressObject(Date date, int addressId) {
        return addressObjectDao.findByDateAndObjectId(date, addressId)
                .orElseThrow(() -> new AddressServiceException("Address object id[" + addressId + "] not found"));
    }

    @Override
    public List<AddressObject> getAddressObjects(Date date, List<Integer> addressObjectsId) {
        List<AddressObject> list = addressObjectsId.stream()
                .map((e) -> addressObjectDao.findByDateAndObjectId(date, e))
                .map((e) -> e.orElseThrow(() -> new AddressServiceException("Address object not found")))
                .toList();
        return sortByListAddressObjectsId(addressObjectsId, list);
    }

    @Override
    public List<AddressObject> getAllActualByTypeName(String typeName) {
        return addressObjectDao.findAllActualByTypeName(typeName);
    }

    @Override
    public List<AddressObject> getAddressObjects(String dateStr, String addressesIdStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new AddressServiceException(e);
        }
        List<Integer> addressesId = Arrays.stream(addressesIdStr.split(",")).map(String::strip).map(Integer::parseInt).toList();
        return getAddressObjects(date, addressesId);
    }

    @Override
    public List<AddressObject> getAllActualByAddressObjectsId(List<Integer> addressObjectsId) {
        List<AddressObject> list = addressObjectDao.findAllActualByObjectsId(addressObjectsId);
        return sortByListAddressObjectsId(addressObjectsId, list);
    }

    private List<AddressObject> sortByListAddressObjectsId(List<Integer> sortList, List<AddressObject> addressObjects) {
        Map<Integer, AddressObject> map = addressObjects.stream()
                .collect(Collectors.toMap(AddressObject::getObjectId, Function.identity()));

        List<AddressObject> sortedObjects = new ArrayList<>();
        for (int objectId : sortList) {
            sortedObjects.add(map.get(objectId));
        }
        return sortedObjects;
    }
}
