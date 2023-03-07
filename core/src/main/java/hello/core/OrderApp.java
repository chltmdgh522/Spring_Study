package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /*1. MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();*/

        /*2. AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService",OrderService.class);

        long memberId = 1L;

        Member member = new Member(memberId, "최승호", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);


        System.out.println("order=" + order);
        System.out.println("order.calculatePrice=" + order.calculatePrice());
    }

}
