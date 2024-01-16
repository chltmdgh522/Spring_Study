package hello.typeconverter.type;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode //객체 값이 같는지 확인해주는 어노테이션 
public class IpPort {
    private String ip;
    private int port;
}
