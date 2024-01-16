package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class BasicTxTest {

    @Autowired
    PlatformTransactionManager txManger;

    @Autowired
    DataSource dataSource;

    @TestConfiguration
    static class Config {
        @Bean
        PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

    }

    @Test
    void commit() {
        log.info("트랜잭션 시작");
        TransactionStatus status = txManger.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");
        txManger.commit(status);
        log.info("트랜잭션 커밋 완료");

    }

    @Test
    void rollback() {
        log.info("트랜잭션 시작");
        TransactionStatus status = txManger.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");
        txManger.rollback(status);
        log.info("트랜잭션 롤백 완료");

    }

    @Test
    void double_commit() {
        log.info("트랜잭션1 시작");
        TransactionStatus status1 = txManger.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 1커밋 시작");
        txManger.commit(status1);
        log.info("트랜잭션 1커밋 완료");

        log.info("트랜잭션2 시작");
        TransactionStatus status2 = txManger.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 2커밋 시작");
        txManger.commit(status2);
        log.info("트랜잭션 2커밋 완료");


    }

    @Test
    void double_commit_rollback() {
        log.info("트랜잭션1 시작");
        TransactionStatus status1 = txManger.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 1커밋 시작");
        txManger.commit(status1);
        log.info("트랜잭션 1커밋 완료");

        log.info("트랜잭션2 시작");
        TransactionStatus status2 = txManger.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션 2롤백 시작");
        txManger.rollback(status2);
        log.info("트랜잭션 2롤백 완료");


    }

}
