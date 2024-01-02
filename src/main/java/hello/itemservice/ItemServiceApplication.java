package hello.itemservice;

import com.zaxxer.hikari.HikariDataSource;
import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


//@Import(MemoryConfig.class) //스프링 구성 클래스에 다른 구성 클래스를 가져와서 해당 클래스의 빈(Bean) 설정을 현재 구성 클래스에 추가하도록 지시합니다.
// 즉 해당 빈타입을 여기다가 가져다가 쓸려고 다시말해서 빈 수동등록이라고 보면될듯 빈을 여기다 쓰면 @Configuration
//@Import(JdbcTemplateV2Config.class)
//@Import(JdbcTemplateV3Config.class)
//@Import(MyBatisConfig.class)
//@Import(JpaConfig.class)
//@Import(SpringDataJpaConfig.class)
@Import(QuerydslConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
@Slf4j
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

//	@Bean
//	@Profile("test")
//	public DataSource dataSource(){
//		log.info("데이터 초기화");
//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.se
//	}
}
