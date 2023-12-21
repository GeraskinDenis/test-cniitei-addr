package dao;

import domain.AddressHierarchy;

import java.util.List;
import java.util.Optional;

public class AddressHierarchyDaoAsList implements AddressHierarchyDao {

    private final List<AddressHierarchy> repository;

    public AddressHierarchyDaoAsList(List<AddressHierarchy> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<AddressHierarchy> findByObjIdAndActive(int objectId) {
        return repository.stream()
                .filter((e) -> e.getObjectId() == objectId)
                .filter(AddressHierarchy::isActive)
                .findFirst();
    }
}
