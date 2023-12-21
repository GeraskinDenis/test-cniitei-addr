package dao.dto;

import domain.AddressHierarchy;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "ITEM")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressHierarchyDto {
    @XmlAttribute(name = "OBJECTID")
    private int objectId;
    @XmlAttribute(name = "PARENTOBJID")
    private int parentObjId;
    @XmlAttribute(name = "ISACTIVE")
    private boolean isActive;

    public AddressHierarchy toDomainObject() {
        return new AddressHierarchy(objectId, parentObjId, isActive);
    }
}
