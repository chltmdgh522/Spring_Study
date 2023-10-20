package hello.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
    private String memberId;
    private int money;

    public Member() {

    }
}
