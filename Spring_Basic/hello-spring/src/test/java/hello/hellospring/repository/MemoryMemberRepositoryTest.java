package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository= new MemoryMemberRepository();

    @AfterEach//테스트 끝난거 초기화 할려구
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member =new Member();
        member.setName("최승호");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("chltmdgh");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("chltmdg1");
        repository.save(member2);

        Member result=repository.findByName("chltmdgh").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member3=new Member();
        member3.setName("최승호");
        repository.save(member3);

        Member member2=new Member();
        member2.setName("최승호2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }

}
