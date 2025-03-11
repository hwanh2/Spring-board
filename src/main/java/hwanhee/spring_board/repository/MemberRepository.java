package hwanhee.spring_board.repository;

import hwanhee.spring_board.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Member findByName(String name);
    List<Member> findByAll();
}
