package per.demo.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long cid;
    @Column
    private Long tid;
    @Column
    private String userid;
    @Column
    private String content;
    @Column
    private String date;
    @Column
    private int star;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}

