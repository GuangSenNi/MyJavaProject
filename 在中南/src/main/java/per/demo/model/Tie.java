package per.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tie implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tid;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String picture;
    @Column
    private String date;
    @Column
    private String owner;
    @Column
    private int star;
    @Column
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
