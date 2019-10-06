/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 9:29
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.Job;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.JOBTABLE;

public class JobDynaSQLProvider {
    //根据id查询职位
    public String selectById(int id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(JOBTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //查询所有职位
    public String selectAllJob() {
        return new SQL() {
            {
                SELECT("*");
                FROM(JOBTABLE);
            }
        }.toString();
    }

    // 分页动态查询
    public String selectByPage(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE("name LIKE CONCAT ('%', #{job.name}, '%')");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
        }
        return sql;
    }

    //动态查询总数量
    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(JOBTABLE);
                if (params.get("job") != null) {
                    Job job = (Job) params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE("name LIKE CONCAT ('%', #{job.name}, '%')");
                    }
                }
            }
        }.toString();
    }

    // 根据id删除职位
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(JOBTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 动态插入职位
    public String save(Job job) {
        return new SQL() {
            {
                INSERT_INTO(JOBTABLE);
                if (job.getName() != null && !job.getName().equals("")) {
                    VALUES("name", "#{name}");
                }
                if (job.getRemark() != null && !job.getRemark().equals("")) {
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }

    // 动态修改职位
    public String update(Job job) {
        return new SQL() {
            {
                UPDATE(JOBTABLE);
                if (job.getName() != null) {
                    SET(" name = #{name} ");
                }
                if (job.getRemark() != null) {
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
}
