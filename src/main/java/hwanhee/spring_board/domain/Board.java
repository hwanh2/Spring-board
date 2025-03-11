package hwanhee.spring_board.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)  // 필요에 따라 추가
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;

    // 기본 생성자 추가
    public Board() {
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Member getMember() { return member; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setMember(Member member) { this.member = member; }

    // toString 메서드 추가 (선택 사항)
    @Override
    public String toString() {
        return "Board{id=" + id + ", title='" + title + "', content='" + content + "'}";
    }

    // equals와 hashCode 메서드 추가 (선택 사항)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Board board = (Board) obj;
        return id != null && id.equals(board.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
