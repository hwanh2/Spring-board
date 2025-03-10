package hwanhee.spring_board.repository;

import hwanhee.spring_board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {
    Board save(Board board);
    List<Board> findByAll();

}
