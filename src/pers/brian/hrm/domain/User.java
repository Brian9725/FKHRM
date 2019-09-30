/**
 * @Author: BrianHu
 * @Date: 2019/9/30
 * @Time: 16:31
 */
package pers.brian.hrm.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    //用户ID
    private Integer id;
    //用户名
    private String username;
    //登录名
    private String loginname;
    //登录密码
    private String password;
    //状态
    private Integer status;
    //用户创建日期
    private Date createDate;

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
