package dao.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "ADDRESSOBJECTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressObjectListDto {

    @XmlElement(name = "OBJECT")
    private List<AddressObjectDto> list;
}
