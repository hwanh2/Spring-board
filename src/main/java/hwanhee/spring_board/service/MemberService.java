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
        Member result = memberRepository.findByName(member.getName());
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findByAll();
    }
    public Optional<Member> fineOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    public Member findByName(String name){
        return memberRepository.findByName(name);
    }

}
