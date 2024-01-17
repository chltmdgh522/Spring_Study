package hello.core.singleton;

import ch.qos.logback.core.model.INamedModel;

import java.util.ArrayList;
import java.util.List;

public class SingletonService {


    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
