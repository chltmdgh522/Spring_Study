package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 멤버변수를 생성자를 만들어줌
public class OrderServiceImpl implements OrderService {
    //MemberRepository memberRepository = new MemoryMemberRepository();
    //DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //DiscountPolicy discountPolicy = new RateDiscountPolicy();
    final MemberRepository memberRepository; //실수할때 fianl 쓰면 생성자 바로 알아낼 수 있음
    final DiscountPolicy discountPolicy;
    /*@Autowired //수정자
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("dd") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    } //@RequiredArgsConstructor 이거작성하면 이거 안써도 됨

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
