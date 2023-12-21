package dao;

import domain.AddressObject;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AddressObjectDaoAsList implements AddressObjectDao {

    private final List<AddressObject> repository;

    public AddressObjectDaoAsList(List<AddressObject> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<AddressObject> findByDateAndObjectId(Date date, int objectId) {
        return repository.stream()
                .filter((e) -> e.getObjectId() == objectId)
                .filter((e) -> date.after(e.getStartDate()) || date.equals(e.getStartDate()))
                .max(Comparator.comparing(AddressObject::getStartDate));
    }

    @Override
    public List<AddressObject> findAllActualByObjectsId(List<Integer> objectsId) {
        return repository.stream()
                .filter(AddressObject::isActual)
                .filter((e) -> objectsId.stream().anyMatch((i) -> i == e.getObjectId()))
                .toList();
    }

    @Override
    public List<AddressObject> findAllActualByTypeName(String typeName) {
        return repository.stream()
                .filter(AddressObject::isActual)
                .filter((e) -> typeName.equals(e.getTypeName()))
                .toList();
    }
}
