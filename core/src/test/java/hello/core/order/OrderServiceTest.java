package hello.core.order;

import hello.core.AppConfig;
import hello.core.OrderApp;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    //MemberService memberService=new MemberServiceImpl();
    //OrderService orderService=new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;
    @BeforeEach //test실행하기전에 무조건 실행
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService=appConfig.memberService();
        orderService=appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberID=1L;
        Member member= new Member(memberID, "최승호", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberID,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}
