package cshproject.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer quantity;

    private Integer price;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
