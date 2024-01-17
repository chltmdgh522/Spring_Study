package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //1. MemberService memberService = new MemberServiceImpl();
        /*2.AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이것이 AppConfig에서 @ 이들 관리 anno~~~는 @ 기반으로 만들어진것
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "최승호", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member =" + member.getName());
        System.out.println("findMember = " + findMember.getGrade());
        System.out.println(findMember);

    }
}
