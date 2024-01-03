package hello.springtx.apply;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class TxBasicTest {

    @Autowired
    BasicService basicService;

    @Test
    void proxyCheck(){
        log.info("aop class={}",basicService.getClass());
        Assertions.assertThat(AopUtils.isAopProxy(basicService)).isTrue(); //Aop 적용여부
    }

    @Test
    void txTest(){
        basicService.tx();
        basicService.nx();
    }

    @TestConfiguration
    static class TxAppLyBasicConfig{
        @Bean
        BasicService basicService(){
            return new BasicService();
        }
    }

    @Slf4j
    static class BasicService{
        @Transactional
        public void tx(){
            log.info("call tx");
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive(); //트랜잭션이 활성화됐냐
            log.info("tx active={}",txActive);
        }

        public void nx(){
            log.info("call nonTx");
            boolean txActive = TransactionSynchronizationManager.isActualTransactionActive(); //트랜잭션이 활성화됐냐
            log.info("tx active={}",txActive); //트랜잭션 관련 로직 수행안함 왜냐면 없기때문에 
        }
    }
}
