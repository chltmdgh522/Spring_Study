package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 등록 //("이름지정가능")
public class MemberServiceImpl implements MemberService {
    //MemberRepository memberRepository = new MemoryMemberRepository();
    //@Autowired MemberRepository memberRepository; //필드타입 주입
    MemberRepository memberRepository;
/*
    @Autowired //자동의존관계 주입 ac.getBean(MemberRepository.class)
    // 생성자 1개일때 생략가능 // (required=false) -> 선택적으로 들어갈건지 아니걸지
*/
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
