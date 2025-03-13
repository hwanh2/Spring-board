package hwanhee.spring_board.controller;

import hwanhee.spring_board.domain.Board;
import hwanhee.spring_board.domain.Member;
import hwanhee.spring_board.dto.BoardForm;
import hwanhee.spring_board.service.BoardService;
import hwanhee.spring_board.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberSevice;
    @Autowired
    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberSevice = memberService;
    }
    @GetMapping("/regist")
    public String registForm(){
        return "board/regist";
    }

    @PostMapping("/regist")
    public String regist(HttpSession session,@ModelAttribute BoardForm form) {
        String memberName = (String) session.getAttribute("name");
        if (memberName == null) {
            return "redirect:/members/signup";  // 로그인 안 되어 있으면 회원가입 페이지로 이동
        }

        Member member = memberSevice.findByName(memberName);
        if (member == null) {
            return "redirect:/members/signup";
        }

        Board board = new Board();
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        board.setMember(member);

        boardService.save(board);

        return "redirect:/";
    }

    @GetMapping("/list")
    public List<Board> list(Model model) {
        return boardService.findAll();  // 게시글 목록을 보여주는 화면으로 반환
    }

}
