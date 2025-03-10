package hwanhee.spring_board.service;

import hwanhee.spring_board.domain.Board;
import hwanhee.spring_board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board saveBoard(Board board){
        boardRepository.save(board);
        return board;
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    public List<Board> findByWriterId(Long id){
        return boardRepository.findByWriterId(id);
    }

    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
}
