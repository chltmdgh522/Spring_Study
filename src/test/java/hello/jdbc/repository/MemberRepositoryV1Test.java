package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV0 repository=new MemberRepositoryV0();
    @Test
    void crud() throws SQLException {
        Member member = new Member("최승호10", 1000000000);
        repository.save(member);

        //findid
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}",findMember);

        assertThat(findMember).isEqualTo(member);

        //update
        repository.update(member.getMemberId(),99);
        Member updateMember= repository.findById(member.getMemberId());
        assertThat(updateMember.getMoney()).isEqualTo(99);

        //delte
        repository.delete(member.getMemberId());
        assertThatThrownBy(()->repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class); // 저거 하면 이 예외가 뜨니???

    }

    @Test
    void crud1() throws SQLException{
        repository.findById("최승호3");
    }
}