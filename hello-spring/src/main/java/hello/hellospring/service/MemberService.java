package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복 회원 x
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent//만약에 m에 값이 있으면
                (m -> {
                    throw new IllegalStateException("이미 존재하는 회원인데용");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
