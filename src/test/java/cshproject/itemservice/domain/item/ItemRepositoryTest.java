package cshproject.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Item item = new Item("A",10000,5);
        //when
        Item saveItem = itemRepository.save(item);
        //then
        Item byId = itemRepository.findById(saveItem.getId());

        assertThat(byId).isEqualTo(saveItem);
    }

    @Test
    void update(){
        //given
        Item item = new Item("A",10000,5);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();
        //when
        Item updateParam = new Item("B", 200, 1);
        itemRepository.update(itemId,updateParam);
        //then
        Item byId = itemRepository.findById(itemId);
        assertThat(byId.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(byId.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(byId.getQuantity()).isEqualTo(updateParam.getQuantity());

    }

    @Test
    void findAll(){
        //given
        Item item1 = new Item("A",10000,5);
        Item item2 = new Item("A",10000,5);

        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> all = itemRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(item1,item2);

    }
}