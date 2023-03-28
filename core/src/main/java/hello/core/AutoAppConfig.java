package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", //이렇게 하면 member만 돌아간다 패키지 지정
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @Filter(type= FilterType.ANNOTATION, classes=Configuration.class )
        // 컴포넌트로 다 저장하는데 뺄것를 지정
        //Configuration.class를 왜 지정했냐면 저번에 한게 있어서 다뺀거임
)

public class AutoAppConfig {
    @Bean(name="memoryMemberRepository")
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}