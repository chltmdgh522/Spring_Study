package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private int age;
    private Long id;
    private String username;

    public Member(){}

    public Member(String username, int age){
        this.username=username;
        this.age=age;
    }
}
