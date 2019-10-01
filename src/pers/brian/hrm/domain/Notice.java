/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:26
 */
package pers.brian.hrm.domain;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    //通知ID
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //创建时间
    private Date createDate;
    //创建者
    private User user;

    public Notice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
