package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, Member> store=new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        List<Member> all = findAll();
        for (Member member : all) {
            if (member.getLoginId() == loginId) {
                return Optional.of(member);
            }
        }
        return Optional.empty();

        /*
        return findAll().stream() // 마치 루프를 도는것이다.
                .filter(member -> member.getLoginId().equals(loginId))
                //filter 만족하는 조건만 넘어간다.
                .findFirst(); //먼저 나오는애를 반환한다.
                */
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
