package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("spring")
    public String hello(Model model){
        model.addAttribute("data","홍세현 바보");
        return "hello"; //hello.html로 넘어감
    }
   // ${data} 모델에 키값을 갖고와서 치환해주는거
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}
