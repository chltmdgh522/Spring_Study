package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {


    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form" ,method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String processV3Form() {
        return "new-form";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String processV3Save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member",member);
        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.POST)
    @GetMapping
    public String processV3List(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }
}