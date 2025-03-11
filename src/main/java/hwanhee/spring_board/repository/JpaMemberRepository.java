package hwanhee.spring_board.repository;

import hwanhee.spring_board.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Member findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        // 만약 리스트가 비어있거나, 여러 명의 멤버가 존재하면 null을 반환
        return result.isEmpty() ? null : result.get(0);
    }


    @Override
    public List<Member> findByAll() {
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }
}
