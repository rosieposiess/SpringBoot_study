package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //멤버들이 있는 저장소의 객체
    //MemberRepository는 멤버를 저장하는 저장소 비슷한건데 인터페이스임
    Member save(Member member);
    Optional<Member> findByName(String name);
    Optional<Member> findById(Long id);
    List<Member> findAll();
}
