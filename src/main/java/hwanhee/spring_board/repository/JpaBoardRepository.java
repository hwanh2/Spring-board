package hwanhee.spring_board.repository;

import hwanhee.spring_board.domain.Board;
import hwanhee.spring_board.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaBoardRepository implements BoardRepository{
    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b",Board.class)
                .getResultList();
    }

    @Override
    public List<Board> findByWriterId(Long writerId) {
        return em.createQuery("SELECT b FROM Board b WHERE b.writer.id = :writerId", Board.class)
                .setParameter("writerId", writerId)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Board board = em.find(Board.class, id);
        if (board != null) {
            em.remove(board);
        }
    }
}
