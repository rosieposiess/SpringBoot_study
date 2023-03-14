package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =new MemoryMemberRepository();
    //일단 저장소 객체를 하나 만들어줌. 얘가 잘 작동하는지 확인할 것임
    //메소드 별로 확인해줌


    @AfterEach //test함수 하나 끝날때 바로 실행됨!!
    public void afterEach(){
        repository.clearStore();
    }

    @Test //@Test 붙여주면 test로 실행됨~
    public void save(){
        Member member=new Member();
        member.setName("Spring");

        repository.save(member);

        //진짜 save가 잘 되었는지 검증
        Member result=repository.findById(member.getId()).get();
        //위 멤버의 아이디로 레포에서 찾기
        //맨마지막에 get() 붙이는 이유는 Optional은 저렇게 get으로 가져온다고 함
        //Assertions.assertEquals(member,result);
        //아까 만든 member랑 repo안에 있는 동일한 아이디의 repo가 같으면 save가 제대로 된것임
        Assertions.assertThat(member).isEqualTo(result);

    }


    @Test
    public void findByName(){
        //member1 생성 및 저장 프로세스
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        //member2 생성 및 저장 프로세스
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        //이름으로 찾는다..를 어떻게 검증할까?
        //결국 내가 찾고 싶어하는 애==검증하고자하는 함수로 찾은 애 이면 검증이 된거겠지
        Member result=repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //member1 생성 및 저장 프로세스
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        //member2 생성 및 저장 프로세스
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result=repository.findAll(); // findAll()이 원래 ArrayList로 반환
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}