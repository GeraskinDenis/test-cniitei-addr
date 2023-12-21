package service;

import domain.AddressObject;

import java.util.List;

public class AddressFormatterImpl implements AddressFormatter {
    @Override
    public String format(List<AddressObject> addressObjects) {
        StringBuilder builder = new StringBuilder();
        for (AddressObject addressObject : addressObjects) {
            builder.append(String.format("%s: %s %s\n",
                    addressObject.getObjectId(),
                    addressObject.getTypeName(),
                    addressObject.getName()));
        }
        return builder.toString();
    }
}
