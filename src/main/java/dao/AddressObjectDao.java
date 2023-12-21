package dao;

import domain.AddressObject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AddressObjectDao {
    Optional<AddressObject> findByDateAndObjectId(Date date, int objectId);

    List<AddressObject> findAllActualByObjectsId(List<Integer> objectsId);

    List<AddressObject> findAllActualByTypeName(String typeName);
}
