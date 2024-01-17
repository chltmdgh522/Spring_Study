package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /*
    private DataSource dataSource; //데이터베이스와 연결해줄수있는 데이터 소스를 만든다.
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }



    /*@Bean
    public MemberRepository memberRepository() {

        //return new JpaMemberRepository(em);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
        //return new MemoryMemberRepository();
    }*/

}
