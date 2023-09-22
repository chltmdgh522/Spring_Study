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
        Member member = memberRepository.findByLoginId(loginId);
        if (member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }
    }

//        return memberRepository.findByLoginId(loginId)
//                .filter(m -> m.getPassword().equals(password))
//                .orElse(null);
}


