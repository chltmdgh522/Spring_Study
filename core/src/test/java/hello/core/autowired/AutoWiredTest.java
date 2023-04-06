package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    public void AutowiredOption(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(TestBean.class);
        TestBean bean = ac.getBean(TestBean.class);


    }
    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member member1){
            System.out.println("member1 = " + member1);
        }//의존관계없어서 아예호출안됨
        @Autowired
        public void setNoBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member3){
            System.out.println("member3 = " + member3);
        }
    }
}
