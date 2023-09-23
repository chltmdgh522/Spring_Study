package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
//        Optional<Member> byLoginId = memberRepository.findByLoginId(loginId);
//        Member member = byLoginId.get();
//        if (member.getPassword().equals(password)) {
//            return member;
//        } else {
//            return null;
//        }

        return memberRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }


}


