package hello.core.autowired;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"최승호", Grade.VIP));
        OrderService orderService=new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        orderService.createOrder(1L,"승호상품",1000);
    }


}
