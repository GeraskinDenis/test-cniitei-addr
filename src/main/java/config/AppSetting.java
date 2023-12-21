package config;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AppSetting implements AddressObjectFileNameProvider, AddressHierarchyFileNameProvider {
    private final String addressObjectFileName;
    private final String addressHierarchyFileName;

    @Override
    public String getAddressObjectFileName() {
        return addressObjectFileName;
    }

    @Override
    public String getAddressHierarchyFileName() {
        return addressHierarchyFileName;
    }
}
