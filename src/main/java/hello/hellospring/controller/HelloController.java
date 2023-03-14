package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller가 웹 진입점이라고 한다!
public class HelloController {

    @GetMapping("hello") //hello 경로로 들어가면 얘를 실행시켜준다.
    public String hello(Model model){
        model.addAttribute("data","Hello!!");

        return "hello"; //templates의 hello.html으로 렌더링 해라!!!!!!!!
        // controller에서 리턴값으로 !문자!를 반환하는 경우 ?
        // ViewResolver가 맞는 화면을 찾아서 처리한다
        // resources:templates/ + {ViewName}+ .html 이런 형식으로 찾는다
        // hello가 viewName이 되는 듯 싶다
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){
        //이번에는 requestParam이라는 값으로 사용자의 요청을 인자로 받음
        // 그럼 어떻게 사용자의 요청을 인자로 넣어야될까..?
        model.addAttribute("name",name);
        return "hello-template";
        // 쿼리스트링으로 name 값 안보내주면 에러뜸
        // 참고로 @requestParm 인자로 required=false 주면 꼭 안보내도됨(여기서는 보내야지 작동하겠지만 ㅠ)ㅁ
    }



    @GetMapping("hello-string")
    @ResponseBody //이걸 추가하면 데이터 자체가 그냥 바로 http 바디에 들어감!! 템플릿 엔지이나 뷰같은거 상관 없이!
    // 이게 몬 소리냐 하면, 쿼리스트링에 name 넣어서 접근해서 화면에서 소스보기(개발자 도구말고!) 하면, 그냥 ㄹㅇ로 html 이딴 거 없이 데이터만 썡으로 내려감
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    static class Hello{ //클래스 Hello 정의
        private String name;

        //게터세터 정의~올만이야ㅠㅠ
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam ("name") String name){ //이제 Hello라는 객체를 변환하는 메소드!
        //참고로 @requestParam(name)은 사용자가 보낸 변수 'name'(왼쪽)을 오른쪽 name이라는 String으로 받는다는 거 같다
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //hello라는 객체를 반환
    }
    //json은 key,value 형태로된 구조
}
