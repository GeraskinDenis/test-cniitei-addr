package dao.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "ITEMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressesHierarchyItemsDto {
    @XmlElement(name = "ITEM")
    private List<AddressHierarchyDto> items;

}
