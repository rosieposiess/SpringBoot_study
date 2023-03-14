package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //MemoryMemberRepository는 그냥 저장소였고 저장소의 특징을 정의한거라면(시스템적으로)
    //MemberService는 찐 비즈니스 로직 등을 정의한 곳이당!

    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //저장소 생성

    /**
     *  회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 x
        ValidateDuplicateMember(member); //ctrl + alt + m 으로 메소드 추출 가능
        memberRepository.save(member);
        return member.getId();
    }

    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 찾기
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
