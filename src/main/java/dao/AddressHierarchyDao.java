package dao;

import domain.AddressHierarchy;

import java.util.Optional;

public interface AddressHierarchyDao {
    Optional<AddressHierarchy> findByObjIdAndActive(int objectId);
}
