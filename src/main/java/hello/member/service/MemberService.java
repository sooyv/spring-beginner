package hello.member.service;

import hello.member.domain.Member;
import hello.member.repository.MemberRepository;
import hello.member.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입(저장)
    //회원가입 후 id를 던져줌
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        //repository를 통해서 db에 접근
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                                //functionalinterface 그때 그때 로직을 넣기 위해서, 람다 사용 가능
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //특정 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
