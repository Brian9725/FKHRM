/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:18
 */
package pers.brian.hrm.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    //职员ID
    private Integer id;
    //所属部门
    private Dept dept;
    //职位
    private Job job;
    //姓名
    private String name;
    //身份证号码
    private String cardId;
    //地址
    private String address;
    //邮编
    private String postcade;
    //电话号码
    private String tel;
    //手机号码
    private String phone;
    //QQ号
    private String qqNum;
    //邮箱
    private String email;
    //性别
    private Integer sex;
    //政治面貌
    private String parth;
    //生日
    private Date birthday;
    //民族
    private String race;
    //学历
    private String education;
    //专业
    private String speciality;
    //爱好
    private String hobby;
    //详细说明
    private String remark;
    //创建时间
    private Date createDate;

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcade() {
        return postcade;
    }

    public void setPostcade(String postcade) {
        this.postcade = postcade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParth() {
        return parth;
    }

    public void setParth(String parth) {
        this.parth = parth;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
