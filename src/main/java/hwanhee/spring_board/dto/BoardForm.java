package hwanhee.spring_board.dto;

import hwanhee.spring_board.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {
    private String title;
    private String content;
}
