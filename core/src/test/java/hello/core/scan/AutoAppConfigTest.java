package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;


public class AutoAppConfigTest {
    @Test
    public void basicScan(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService=ac.getBean(MemberService.class);
        System.out.println("----");

       assertThat(memberService).isInstanceOf(MemberService.class);

       OrderService been =ac.getBean(OrderServiceImpl.class);

        System.out.println(been);

    }
}
