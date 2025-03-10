package hwanhee.spring_board.repository;

import hwanhee.spring_board.domain.Board;
import hwanhee.spring_board.domain.Member;

import java.util.List;

public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
    List<Board> findByWriterId(Long writerId);
    void deleteById(Long id);

}
