package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {



    @Test
    public void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); //bean으로됨
        AppConfig appConfig=ac.getBean(AppConfig.class);
        System.out.println("appConfig.getClass() = " + appConfig.getClass());

    }


}
