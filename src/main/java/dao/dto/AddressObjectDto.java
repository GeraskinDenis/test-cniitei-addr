package dao.dto;

import domain.AddressObject;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

import java.util.Date;

@Data
@XmlRootElement(name = "OBJECT")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressObjectDto {

    @XmlAttribute(name = "OBJECTID")
    private int objectId;

    @XmlAttribute(name = "NAME")
    private String name;

    @XmlAttribute(name = "TYPENAME")
    private String typeName;

    @XmlAttribute(name = "STARTDATE")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date startDate;

    @XmlAttribute(name = "ENDDATE")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date endDate;

    @XmlAttribute(name = "ISACTUAL")
    private boolean isActual;

    @XmlAttribute(name = "ISACTIVE")
    private boolean isActive;

    public AddressObject toDomainObject() {
        return new AddressObject(objectId, name, typeName, startDate, endDate, isActual, isActive);
    }
}
