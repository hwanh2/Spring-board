package hwanhee.spring_board.controller;

import hwanhee.spring_board.domain.Member;
import hwanhee.spring_board.dto.MemberForm;
import hwanhee.spring_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController  // @Controller 대신 @RestController 사용
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public String signup(HttpSession session, @RequestBody MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        memberService.join(member);
        session.setAttribute("name", member.getName());
        return "redirect:/";
    }
}