package hello.hellospring.controller;

import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class MemberController {

    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //조회할 때 쓰임
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //데이터를 폼 같은데 넣어서 전달
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        System.out.println(member.getName());
        memberService.join(member);
        return "redirect:/"; //??
    }
    @GetMapping("/members")
    public String list(Model model){
       List<Member> members= memberService.findMembers();
       model.addAttribute("members",members);
       return "members/memberList";
    }




}
