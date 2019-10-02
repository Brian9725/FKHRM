/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 9:50
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.Employee;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.EMPLOYEETABLE;

public class EmployeeDynaSQLProvider {
    // 根据参数查询员工总数
    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0) {
                        WHERE("dept_id = #{employee.dept.id}");
                    }
                    if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0) {
                        WHERE("job_id = #{employee.job.id}");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE("name LIKE CONCAT ('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE("phone LIKE CONCAT ('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE("card_id LIKE CONCAT ('%',#{employee.cardId},'%')");
                    }
                    if (employee.getSex() != null && employee.getSex() != 0) {
                        WHERE("sex = #{employee.sex}");
                    }
                }
            }
        }.toString();
    }

    // 根据参数动态查询员工
    public String selectByPage(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("employee");
                    if (employee.getDept() != null && employee.getDept().getId() != null && employee.getDept().getId() != 0) {
                        WHERE("dept_id = #{employee.dept.id}");
                    }
                    if (employee.getJob() != null && employee.getJob().getId() != null && employee.getJob().getId() != 0) {
                        WHERE("job_id = #{employee.job.id}");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE("name LIKE CONCAT ('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE("phone LIKE CONCAT ('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE("card_id LIKE CONCAT ('%',#{employee.cardId},'%')");
                    }
                    if (employee.getSex() != null && employee.getSex() != 0) {
                        WHERE("sex = #{employee.sex}");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }

        return sql;
    }

    // 动态插入员工
    public String save(Employee employee) {
        return new SQL() {
            {
                INSERT_INTO(EMPLOYEETABLE);
                if (employee.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (employee.getCardId() != null) {
                    VALUES("card_id", "#{cardId}");
                }
                if (employee.getAddress() != null) {
                    VALUES("address", "#{address}");
                }
                if (employee.getPostCode() != null) {
                    VALUES("post_code", "#{postCode}");
                }
                if (employee.getTel() != null) {
                    VALUES("tel", "#{tel}");
                }
                if (employee.getPhone() != null) {
                    VALUES("phone", "#{phone}");
                }
                if (employee.getQqNum() != null) {
                    VALUES("qq_num", "#{qqNum}");
                }
                if (employee.getEmail() != null) {
                    VALUES("email", "#{email}");
                }
                if (employee.getSex() != null) {
                    VALUES("sex", "#{sex}");
                }
                if (employee.getParty() != null) {
                    VALUES("party", "#{party}");
                }
                if (employee.getBirthday() != null) {
                    VALUES("birthday", "#{birthday}");
                }
                if (employee.getRace() != null) {
                    VALUES("race", "#{race}");
                }
                if (employee.getEducation() != null) {
                    VALUES("education", "#{education}");
                }
                if (employee.getSpeciality() != null) {
                    VALUES("speciality", "#{speciality}");
                }
                if (employee.getHobby() != null) {
                    VALUES("hobby", "#{hobby}");
                }
                if (employee.getRemark() != null) {
                    VALUES("remark", "#{remark}");
                }
                if (employee.getCreateDate() != null) {
                    VALUES("create_date", "#{createDate}");
                }
                if (employee.getDept() != null) {
                    VALUES("dept_id", "#{dept.id}");
                }
                if (employee.getJob() != null) {
                    VALUES("job_id", "#{job.id}");
                }
            }
        }.toString();
    }

    // 根据id删除员工
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(EMPLOYEETABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 根据id查询员工
    public String selectById(Integer id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(EMPLOYEETABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 动态修改员工
    public String update(Employee employee) {
        return new SQL() {
            {
                UPDATE(EMPLOYEETABLE);
                if (employee.getName() != null) {
                    SET("name = #{name}");
                }
                if (employee.getCardId() != null) {
                    SET("card_id = #{cardId}");
                }
                if (employee.getAddress() != null) {
                    SET("address = #{address}");
                }
                if (employee.getPostCode() != null) {
                    SET("post_code = #{postCode}");
                }
                if (employee.getTel() != null) {
                    SET("tel = #{tel}");
                }
                if (employee.getPhone() != null) {
                    SET("phone = #{phone}");
                }
                if (employee.getQqNum() != null) {
                    SET("qq_num = #{qqNum}");
                }
                if (employee.getEmail() != null) {
                    SET("email = #{email}");
                }
                if (employee.getSex() != null) {
                    SET("sex = #{sex}");
                }
                if (employee.getParty() != null) {
                    SET("party = #{party}");
                }
                if (employee.getBirthday() != null) {
                    SET("birthday = #{birthday}");
                }
                if (employee.getRace() != null) {
                    SET("race = #{race}");
                }
                if (employee.getEducation() != null) {
                    SET("education = #{education}");
                }
                if (employee.getSpeciality() != null) {
                    SET("speciality = #{speciality}");
                }
                if (employee.getHobby() != null) {
                    SET("hobby = #{hobby}");
                }
                if (employee.getRemark() != null) {
                    SET("remark = #{remark}");
                }
                if (employee.getCreateDate() != null) {
                    SET("create_date = #{createDate}");
                }
                if (employee.getDept() != null) {
                    SET("dept_id = #{dept.id}");
                }
                if (employee.getJob() != null) {
                    SET("job_id = #{job.id}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
