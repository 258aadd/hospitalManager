package com.ml.pojo;

public class DoctorsQuery {
    private String did;//科室id
    private String pid;//职称id
    private String dname;//医生姓名
    private String jobnum;//工号
    private String page;//当前页

    public DoctorsQuery(String did, String pid, String dname, String jobnum, String page) {
        this.did = did;
        this.pid = pid;
        this.dname = dname;
        this.jobnum = jobnum;
        this.page = page;
    }

    public DoctorsQuery() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "DoctorsQuery{" +
                "did='" + did + '\'' +
                ", pid='" + pid + '\'' +
                ", dname='" + dname + '\'' +
                ", jobnum='" + jobnum + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
