package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("spring")
    public String hello(Model model) {
        model.addAttribute("data", "홍세현 바보");
        return "hello"; //hello.html로 넘어감
    }

    // ${data} 모델에 키값을 갖고와서 치환해주는거
    @GetMapping("hello-mvc") //MVC
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring") //API
    @ResponseBody //html body 부분에 문자내용을 직접 반환
    public String helloSpring(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
