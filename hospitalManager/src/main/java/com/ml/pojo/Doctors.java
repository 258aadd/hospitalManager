package com.ml.pojo;

public class Doctors {
    private Integer doctor_id;
    private String job_number;
    private String password;
    private String name;
    private String avatar;
    private String phone;
    private String email;
    private String introduction;
    private Double registration_fee;
    private String entry_date;
    private Integer department_id;
    private Integer professional_title_id;

    private Departments departments;
    private Professional_titles professional_titles;

    private Integer state;//0正常 1删除


    public Doctors(String job_number, String name, String phone, Double registration_fee, String introduction, String entry_date, String email , Integer professional_title_id) {
        this.job_number = job_number;
        this.name = name;
        this.phone = phone;
        this.registration_fee = registration_fee;
        this.introduction = introduction;
        this.entry_date = entry_date;
        this.email = email;
        this.professional_title_id = professional_title_id;
    }

    public Doctors(Integer doctor_id, String job_number, String password, String name, String avatar, String phone, String email, String introduction, Double registration_fee, String entry_date, Integer department_id, Integer professional_title_id, Departments departments, Professional_titles professional_titles, Integer state) {
        this.doctor_id = doctor_id;
        this.job_number = job_number;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.introduction = introduction;
        this.registration_fee = registration_fee;
        this.entry_date = entry_date;
        this.department_id = department_id;
        this.professional_title_id = professional_title_id;
        this.departments = departments;
        this.professional_titles = professional_titles;
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Professional_titles getProfessional_titles() {
        return professional_titles;
    }

    public void setProfessional_titles(Professional_titles professional_titles) {
        this.professional_titles = professional_titles;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Double getRegistration_fee() {
        return registration_fee;
    }

    public void setRegistration_fee(Double registration_fee) {
        this.registration_fee = registration_fee;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getProfessional_title_id() {
        return professional_title_id;
    }

    public void setProfessional_title_id(Integer professional_title_id) {
        this.professional_title_id = professional_title_id;
    }
}
/*全部上传标签*/