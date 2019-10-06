/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:07
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import pers.brian.hrm.dao.Provider.EmployeeDynaSQLProvider;
import pers.brian.hrm.domain.Employee;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.EMPLOYEETABLE;

@Component
public interface EmployeeDao {
    //根据参数查询员工总数
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //根据参数动态查询员工
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "selectByPage")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "card_id", property = "cardId"),
            @Result(column = "post_code", property = "postCode"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "birthday", property = "birthday", javaType = Date.class),
            @Result(column = "create_date", property = "createDate", javaType = Date.class),
            @Result(column = "dept_id", property = "dept",
                    one = @One(select = "pers.brian.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "job",
                    one = @One(select = "pers.brian.hrm.dao.JobDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Employee> selectByPage(Map<String, Object> params);

    //动态插入员工
    @InsertProvider(type = EmployeeDynaSQLProvider.class, method = "save")
    void save(Employee employee);

    //根据id删除员工
    //@DeleteProvider(type = EmployeeDynaSQLProvider.class, method = "deleteById")
    @Delete("DELETE FROM " + EMPLOYEETABLE + " WHERE id = #{id}")
    void deleteById(Integer id);

    //根据id查询员工
    //@SelectProvider(type = EmployeeDynaSQLProvider.class, method = "selectById")
    @Select("SELECT * FROM " + EMPLOYEETABLE + " WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "card_id", property = "cardId"),
            @Result(column = "post_code", property = "postCode"),
            @Result(column = "qq_num", property = "qqNum"),
            @Result(column = "birthday", property = "birthday", javaType = Date.class),
            @Result(column = "create_date", property = "createDate", javaType = Date.class),
            @Result(column = "dept_id", property = "dept",
                    one = @One(select = "pers.brian.hrm.dao.DeptDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "job_id", property = "job",
                    one = @One(select = "pers.brian.hrm.dao.JobDao.selectById", fetchType = FetchType.EAGER))
    })
    Employee selectById(Integer id);

    // 动态修改员工
    @UpdateProvider(type = EmployeeDynaSQLProvider.class, method = "update")
    void update(Employee employee);
}
