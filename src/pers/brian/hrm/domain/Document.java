/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:28
 */
package pers.brian.hrm.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {
    //文件ID
    private Integer id;
    //标题
    private String title;
    //文件名
    private String fileName;
    //文件
    private MultipartFile file;
    //描述
    private String remark;
    //上传时间
    private Date createDate;
    //上传者
    private User user;

    public Document() {
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
