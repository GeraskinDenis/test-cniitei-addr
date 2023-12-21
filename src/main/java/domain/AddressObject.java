package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class AddressObject {
    private int objectId;
    private String name;
    private String typeName;
    private Date startDate;
    private Date endDate;
    private boolean isActual;
    private boolean isActive;
}
