package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberServiceTest {
    MemberService memberService= new MemberService();
    @Test
    void 회원가입() {
        //given

        //when

        //then
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1= new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);
        IllegalStateException e= Assertions.assertThrows(IllegalStateException.class, ()->memberService.join(member2));
        //memberService.join(member2)하면 IllegalStateException이 일어나야한다는 뜻
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//
//                try{
//            memberService.join(member2);
//            //정상적으로 잘 작동한다면 여기서 exception 터져야함
//            fail(); //exception 터지는게 기본이므로 여기까지 가면 fail로 실패~
//        }
//        catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.")
//        }

        //then
    }

    @Test
    void findAllMembers() {
    }

    @Test
    void findOne() {
    }
}