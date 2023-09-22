package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    //@GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/")
    public String homeLogin(@CookieValue(value = "memberId",required = false
            /*false 이유가 로그인 안한 사람도 들어오게 할려고 또한 String 이여야 되는데
            * 스프링이 자동으로 타입 컨버터 해줌*/) Long memberId, Model model) {
        if(memberId==null){
            return "home";
        }
        //로그인
        Member loginMember = memberRepository.findById(memberId);
        if(loginMember==null){
            return "home"; //굳이 해야되나 싶지만 악용이 있기때문에 해야될듯..
        }
        model.addAttribute("member",loginMember);
        return "loginHome";
    }
}