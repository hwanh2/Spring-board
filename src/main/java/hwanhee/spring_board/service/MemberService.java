package hwanhee.spring_board.service;

import hwanhee.spring_board.domain.Member;
import hwanhee.spring_board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
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
    public Optional<Member> fineOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
