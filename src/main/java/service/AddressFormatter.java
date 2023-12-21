package service;

import domain.AddressObject;

import java.util.List;

public interface AddressFormatter {
    String format(List<AddressObject> addressObjects);
}
