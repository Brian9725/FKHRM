/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 9:22
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import pers.brian.hrm.dao.Provider.DeptDynaSQLProvider;
import pers.brian.hrm.domain.Dept;

import java.util.List;
import java.util.Map;

public interface DeptDao {
    //动态分页查询
    @SelectProvider(type = DeptDynaSQLProvider.class, method = "selectByPage")
    List<Dept> selectByPage(Map<String, Object> param);

    //查询总数量
    @SelectProvider(type = DeptDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> param);

    //查询所有部门
    @SelectProvider(type = DeptDynaSQLProvider.class, method = "selectAllDept")
    List<Dept> selectAllDept();

    //根据id查询部门
    @SelectProvider(type = DeptDynaSQLProvider.class, method = "selectById")
    Dept selectById(Integer id);

    //根据id删除部门
    @DeleteProvider(type = DeptDynaSQLProvider.class, method = "deleteById")
    void deleteById(Integer id);

    //动态插入部门
    @InsertProvider(type = DeptDynaSQLProvider.class, method = "save")
    void save(Dept dept);

    //动态更新
    @UpdateProvider(type = DeptDynaSQLProvider.class, method = "update")
    void update(Dept dept);
}
