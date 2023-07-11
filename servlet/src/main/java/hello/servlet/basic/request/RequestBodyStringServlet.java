package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyStringServlet", urlPatterns ="/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // http 메시비 바디를 불러온다.
        String messageBody=StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //바이트를 문자로 바꿔준다. 스트림 유틸을 스프링에서 제공해준거임
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("OK");


    }
}
