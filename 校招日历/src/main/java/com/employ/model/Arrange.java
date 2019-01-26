package com.employ.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Arrange implements Serializable{
    @Id
    @GeneratedValue
    private long aid;
    @Column
    private String cname;
    @Column
    private String cjob;
    @Column
    private String cmajor;
    @Column
    private String ctime;
    @Column
    private String localtion;
    @Column
    private String url;
    @Column
    private String academic;//学院
    @Column
    private String school;
    @Column
    private String priority;
    @Column
    private String atype;//类型
    public Arrange(){

    }

    public Arrange(String cname, String url, String cmajor, String ctime,String localtion,String academic) {
        this.cname = cname;
        this.url = url;
        this.cmajor = cmajor;
        this.ctime = ctime;
        this.localtion = localtion;
        this.academic = academic;
        this.school = "中南大学";
        this.priority = "D";
        this.atype="进校招聘";
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }



    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCjob() {
        return cjob;
    }

    public void setCjob(String cjob) {
        this.cjob = cjob;
    }

    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor) {
        this.cmajor = cmajor;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
