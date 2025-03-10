package hwanhee.spring_board.dto;

import hwanhee.spring_board.domain.Member;

public class BoardForm {
    private String title;
    private Member member;
    private String contnet;

    public String getContnet() {
        return contnet;
    }

    public void setContnet(String contnet) {
        this.contnet = contnet;
    }

    public BoardForm(String title, Member member) {
        this.title = title;
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
