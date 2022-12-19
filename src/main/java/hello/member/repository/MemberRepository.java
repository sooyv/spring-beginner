package hello.member.repository;

import hello.member.domain.Member;

import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    //optional은 null방지
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
