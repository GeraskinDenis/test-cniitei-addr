package service;

import dao.AddressHierarchyDao;
import domain.AddressObject;
import exception.AddressHierarchyServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressHierarchyServiceImpl implements AddressHierarchyService {

    private final AddressHierarchyDao hierarchyDao;

    public AddressHierarchyServiceImpl(AddressHierarchyDao hierarchyDao) {
        this.hierarchyDao = hierarchyDao;
    }

    @Override
    public int getParentId(int addressObjectId) {
        return hierarchyDao.findByObjIdAndActive(addressObjectId)
                .orElseThrow(() -> new AddressHierarchyServiceException("Address hierarchy not found by id[" + addressObjectId + "]"))
                .getParentObjId();
    }

    @Override
    public List<Integer> getAllHierarchy(AddressObject addressObject) {
        List<Integer> objectsId = new ArrayList<>();
        int objectId = addressObject.getObjectId();
        objectsId.add(objectId);
        while (true) {
            objectId = getParentId(objectId);
            if (objectId == 0) {
                break;
            }
            objectsId.add(objectId);
        }
        Collections.reverse(objectsId);
        return objectsId;
    }
}
