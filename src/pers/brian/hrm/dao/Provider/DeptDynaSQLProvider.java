/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 9:00
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.Dept;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.DEPTTABLE;

public class DeptDynaSQLProvider {
    //动态分页查询
    public String selectByPage(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("*");
                FROM(DEPTTABLE);
                if (params.get("dept") != null) {
                    Dept dept = (Dept) params.get("dept");
                    if (dept.getName() != null && !dept.getName().equals("")) {
                        WHERE("name LIKE CONCAT ('%', #{dept.name}, '%')");
                    }
                }
            }
        }.toString();
    }

    //查询总数量
    public String count(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("count(*)");
                FROM(DEPTTABLE);

            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }

    //查询所有部门
    public String selectAllDept() {
        return new SQL() {
            {
                SELECT("*");
                FROM(DEPTTABLE);
            }
        }.toString();
    }

    //根据id查询部门
    public String selectById(Integer id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(DEPTTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //根据id删除部门
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(DEPTTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //动态插入部门
    public String save(Dept dept) {
        return new SQL() {
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals("")) {
                    VALUES("name", "#{name}");
                }
                if (dept.getRemark() != null && !dept.getRemark().equals("")) {
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }

    //动态更新
    public String update(Dept dept) {
        return new SQL() {
            {
                UPDATE(DEPTTABLE);
                if (dept.getName() != null) {
                    SET("name = #{name}");
                }
                if (dept.getRemark() != null) {
                    SET("remark = #{remark}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
