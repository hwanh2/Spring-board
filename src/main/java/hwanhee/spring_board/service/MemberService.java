package hwanhee.spring_board.service;

import hwanhee.spring_board.domain.Member;
import hwanhee.spring_board.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository memberRepository;
    public Long join(Member member){
        Optional<Member> result = memberRepository.findByName(member.getName());
        // 중복 처리
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findByAll();
    }
}
