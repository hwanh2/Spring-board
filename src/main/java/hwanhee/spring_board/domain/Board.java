package hwanhee.spring_board.domain;

import jakarta.persistence.*;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "writer_id")  // 외래 키 컬럼을 명시적으로 지정
    private Member writer;  // 하나의 Board는 하나의 Member에 속함
    private String content;
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }
}
