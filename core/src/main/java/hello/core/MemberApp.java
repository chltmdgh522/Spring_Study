package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //1. MemberService memberService = new MemberServiceImpl();
        /*2.AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();*/

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(); // AppConfig에서 @ 이들 관리

        Member member = new Member(1L, "최승호", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member =" + member.getName());
        System.out.println("findMember = " + findMember.getGrade());
        System.out.println(findMember);
    }
}
