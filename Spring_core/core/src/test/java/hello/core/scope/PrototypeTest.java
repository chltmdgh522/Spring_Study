package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        ProtoTypeBean bean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean bean2 = ac.getBean(ProtoTypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);

        bean1.destroy(); //직접 작업
        ac.close();
    }


    @Scope("prototype")
    static class ProtoTypeBean{

        @PostConstruct
        public void init () {
        System.out.println("주입");
    }

        @PreDestroy
        public void destroy () {
        System.out.println("끝");
    }

    }
}
