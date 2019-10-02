/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:07
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import pers.brian.hrm.dao.Provider.EmployeeDynaSQLProvider;
import pers.brian.hrm.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    // 根据参数查询员工总数
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    // 根据参数动态查询员工
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "selectByPage")
    List<Employee> selectByPage(Map<String, Object> params);

    // 动态插入员工
    @InsertProvider(type = EmployeeDynaSQLProvider.class, method = "save")
    void save(Employee employee);

    // 根据id删除员工
    @DeleteProvider(type = EmployeeDynaSQLProvider.class, method = "deleteById")
   void deleteById(Integer id);

    // 根据id查询员工
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "selectById")
    Employee selectById(Integer id);

    // 动态修改员工
    @UpdateProvider(type = EmployeeDynaSQLProvider.class, method = "update")
    void update(Employee employee);
}
