package hello.itemservice.domain;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import hello.itemservice.repository.memory.MemoryItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@Slf4j
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

//    @Autowired
//    PlatformTransactionManager transactionManager;
//    TransactionStatus status;
//
//    @BeforeEach
//    void beforeEach(){
//        //트랜잭션 시작
//        status = transactionManager.getTransaction(new DefaultTransactionDefinition());
//
//    }

    @AfterEach
    void afterEach() {
        //MemoryItemRepository 의 경우 제한적으로 사용
        if (itemRepository instanceof MemoryItemRepository) {
            ((MemoryItemRepository) itemRepository).clearStore();
        }
        //트랜잭션 롤백
        //transactionManager.rollback(status);
    }



    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId()).get();
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
        //sql 쿼리문 보기 위해 왜냐하면 JPa는 save에서 데이터가 캐시로 저장되든데 이 매ㅔ소드가 쿼리를 안쓰고
    // 캐시로 조회하기 때문!
    // 쿼리가 다른 애들에 비해 남지않는이유는 트랜잭션이 커밋되는 시점에 쿼리 생성되기때문에 가만히 있음 즉 데이터를 변경하면 \
        // 바로 DB에 반영되지 않고 커밋되는 시점에 DB에 반영이됨 그치만 다른애들은 예로 들어 save는
    //save 메서드가 신규 객체를 DB에 추가하기 위한 JPQL 쿼리를 생성하기 때문입니다. 따라서 INSERT 쿼리는 로그에 남게 됩니다.
    // 즉 데이터베이스에 입력해야지만 ID를 알 수 있기에 쿼리를 강제로 실행합니다 :)
    void updateItem() {
        //given
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        ItemUpdateDto updateParam = new ItemUpdateDto("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);

        //then
        Item findItem = itemRepository.findById(itemId).get();
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

    @Test
    void findItems() {
        //given
        Item item1 = new Item("itemA-1", 10000, 10);
        Item item2 = new Item("itemA-2", 20000, 20);
        Item item3 = new Item("itemB-1", 30000, 30);

        log.info("repository={}",itemRepository.getClass());
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        //둘 다 없음 검증
        test(null, null, item1, item2, item3);
        test("", null, item1, item2, item3);

        //itemName 검증
        test("itemA", null, item1, item2);
        test("temA", null, item1, item2);
        test("itemB", null, item3);

        //maxPrice 검증
        test(null, 10000, item1);

        //둘 다 있음 검증
        test("itemA", 10000, item1);
    }

    void test(String itemName, Integer maxPrice, Item... items) {
        List<Item> result = itemRepository.findAll(new ItemSearchCond(itemName, maxPrice));
        assertThat(result).containsExactly(items);
    }
}
