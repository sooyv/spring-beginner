package hello.member.controller;

import hello.member.domain.Member;
import hello.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    //생성자에서 memberservice초기화
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberFrom form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";        //home으로
    }

    @GetMapping("/members")
//    public List<Member> list(Model model) {
//        List<Member> members = memberService.findMembers();
//        return "members";
//    }

    //MVC model은 데이터를 담는 매개체(박스 상자) view
//    @ResponseBody
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList"; //template폴더안의 같은이름을 가진 view로 이동
    }



}
