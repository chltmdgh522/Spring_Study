package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class UncheckedTest {

    @Test
    void unchecked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void unchecked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyUncheckException.class);
    }

    /**
     * RuntimeException을 상속받은 예외는 언체크 예외가 된다.
     */
    static class MyUncheckException extends RuntimeException {
        public MyUncheckException(String message) {
            super(message);
        }
    }

    /**
     * Unchecked 예외는
     * 예외를 잡거나 던지지 않아도 된다ㅏ.
     * 예외를 잡지 않으면 자동을 밖으로 던진다.
     */

    static class Service {
        Repository repository = new Repository();

        /**
         * 필요한 경우 예외를 잡아서 처리하면 된다.
         */
        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckException e) {
                log.info("예외 메세지={}", e.getMessage(), e);
            }
        }

        /**
         * 예외를 잡지 않아도 된다ㅏ.
         * 자연스럽게 상위로 넘어간다.
         * 즉 체크예외라아 다르게 예외선언을 안해줘도 된다.
         */
        public void callThrow() {
            repository.call();
        }
    }

    static class Repository {
        public void call() {
            throw new MyUncheckException("ex");
        }
    }

}
