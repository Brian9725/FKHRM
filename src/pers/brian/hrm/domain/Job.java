/**
 * @Author: BrianHu
 * @Date: 2019/9/30
 * @Time: 16:37
 */
package pers.brian.hrm.domain;

import java.io.Serializable;

public class Job implements Serializable {
    //职位ID
    private Integer id;
    //职位名称
    private String name;
    //详细描述
    private String remark;

    public Job() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
