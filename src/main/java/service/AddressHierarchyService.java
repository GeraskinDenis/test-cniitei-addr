package service;

import domain.AddressObject;

import java.util.List;

public interface AddressHierarchyService {

    int getParentId(int addressObjectId);

    List<Integer> getAllHierarchy(AddressObject addressObject);
}
