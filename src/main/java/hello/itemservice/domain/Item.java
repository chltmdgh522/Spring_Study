package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity //JPA 객체로 인정 즉 테이블에서 매핑되서 관리되는 객체
//@Table(name = "item") //테이블명이 객체명이랑 같으면 생략가능
public class Item {

    @Id//Pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에서 값을 넣어주는거
    private Long id;

    @Column(name = "item_name", length = 10) // 이때 db 컬럼명이랑 같으면 @Column 생략가능 근데 이거 카멜법치성립되서 생략가능
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
