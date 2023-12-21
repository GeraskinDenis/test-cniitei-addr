package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AddressHierarchy {
    private int objectId;
    private int parentObjId;
    private boolean isActive;
}
