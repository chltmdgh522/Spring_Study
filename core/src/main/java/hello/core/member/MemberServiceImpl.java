package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 등록 //("이름지정가능")
public class MemberServiceImpl implements MemberService {
    //MemberRepository memberRepository = new MemoryMemberRepository();
    MemberRepository memberRepository;

    @Autowired //자동의존관계 주입 ac.getBean(MemberRepository.class)
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
