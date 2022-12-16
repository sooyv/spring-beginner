package hello.member.service;

import hello.member.domain.Member;
import hello.member.repository.MemberRepository;
import hello.member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //defendence insection
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("서문범");

        //when
        Long saveId = memberService.join(member);

        //then
        Member foundMember = memberRepository.findById(saveId).get();

        assertEquals("서문범", foundMember.getName());
    }

    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setName("서문범");

        Member member2 = new Member();
        member2.setName("서문범");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));


    }
}