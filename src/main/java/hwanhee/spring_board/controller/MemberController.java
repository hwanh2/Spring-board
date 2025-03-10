package hwanhee.spring_board.controller;

import hwanhee.spring_board.domain.Member;
import hwanhee.spring_board.dto.MemberForm;
import hwanhee.spring_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupForm(){
        return "members/signup";
    }

    @PostMapping("/signup")
    public String signup(HttpSession session, MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        memberService.join(member);
        session.setAttribute("name", member.getName());
        return "redirect:/";
    }

}
