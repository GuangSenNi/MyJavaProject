package com.employ.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Company implements Serializable{
    @Id
    @GeneratedValue
    private int cid;
    @Column
    private String cname;
    @Column
    private String cemil;
    @Column
    private String ctel;
    @Column
    private String cinfo;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemil() {
        return cemil;
    }

    public void setCemil(String cemil) {
        this.cemil = cemil;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }
}
