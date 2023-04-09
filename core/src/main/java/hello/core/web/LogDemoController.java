package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
   // private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    @RequestMapping("log-demo") //저게 요청이 들어오면
    @ResponseBody //화면없이 문자로 반환하겠다.
    public String logDemo(HttpServletRequest request){
        String requestURL=request.getRequestURL().toString();
        //MyLogger myLogger=myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);


        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";    }
}
