package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

     boolean supports(Object handler);// handler는 컨트롤러를 말한다. // 어댑터가 해당 컨트롤러를 처리할수 있는지 판단하는 메서드이다.
    //즉 해당 컨트롤러를 처리할수 있는 어뎁터
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)throws ServletException, IOException;
    // 어댑터는 실제 컨트롤을 호출하고 그결과 ModelView를 반환한다.
    // 실제 컨트롤러가 ModelView를 반환하지 못하면 어댑터가 ModelView를 직접 생성해서라도 반환한다.
    // 이전에는 프론트컨트롤러가 실제 컨트롤러를 호출했지만 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출된다.
}
