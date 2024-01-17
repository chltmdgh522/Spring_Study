package cshproject.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer quantity;
    private Integer price;

    boolean open; //판매여부
    private List<String> regions; //등록지역
    private ItemType itemType; //상품 종류
    private String deliveryCode; // 배송방식

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
