package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepositoryV3;
import hello.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.itemservice.repository.v2.ItemRepositoryV2;
import hello.itemservice.repository.v2.ItemServiceV2;
import hello.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager em;

    private final ItemRepositoryV2 itemRepositoryV2; // 스프링 데이터는 자동으로 빈으로 등록되기 때문에
    //주입만 해주면됨

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepositoryV2());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() {

        return new ItemQueryRepositoryV2(em);
    }


    @Bean
    public ItemRepository itemRepository() {

        return new JpaItemRepositoryV3(em);
    }

}
