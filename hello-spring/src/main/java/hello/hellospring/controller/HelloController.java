package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("spring")
    public String hello(Model model){
        model.addAttribute("data","홍세현 바보");
        return "hello"; //hello.html로 넘어감
    }
}
