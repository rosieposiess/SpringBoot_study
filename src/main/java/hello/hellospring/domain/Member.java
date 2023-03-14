package hello.hellospring.domain;

public class Member { //멤버 객체를 도메인에다 생성
    private Long id; //시스템에서의 아이디
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long Id){
        this.id=Id;
    }
}
