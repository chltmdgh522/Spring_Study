package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    int discountFixAccount = 2000; // 1000원 할인


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.BASIC) {
            return discountFixAccount;
        } else {
            return 0;

        }
    }
}
