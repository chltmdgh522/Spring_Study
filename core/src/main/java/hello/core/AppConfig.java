package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
public class AppConfig {
    //call AppConfig.memberService();
    //call AppConfig.memberRepository();
    //call AppConfig.memberRepository();
    //call AppConfig.orderService();
    //call AppConfig.memberRepository();
    //call AppConfig.memberService();
    //call AppConfig.memberRepository();
    //call AppConfig.orderService();

    @Bean//(name="dafsd") ->이렇게 빈이름부여 가능
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());
        //return null;
    }
    @Bean
    public MemberRepository memberRepository() {
        //
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        //return new RateDiscountPolicy();
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository();
    }



}
