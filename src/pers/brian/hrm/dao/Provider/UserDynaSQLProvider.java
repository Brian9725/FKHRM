/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:42
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.User;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.USERTABLE;

public class UserDynaSQLProvider {
    //根据登录名和密码查询员工
    public String selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password) {
        return new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                WHERE("loginname = #{loginname}");
                WHERE("password = #{password}");
            }
        }.toString();
    }

    //根据ID查询用户
    public String selectById(Integer id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //根据ID删除用户
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(USERTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //动态修改用户
    public String update(User user) {
        return new SQL() {
            {
                UPDATE(USERTABLE);
                if (user.getUsername() != null) {
                    SET("username = #{username}");
                }
                if (user.getPassword() != null) {
                    SET("password = #{password}");
                }
                if (user.getLoginname() != null) {
                    SET("loginname = #{loginname}");
                }
                if (user.getStatus() != null) {
                    SET("status = #{status}");
                }
                if (user.getCreateDate() != null) {
                    SET("createdate = #{createDate}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //动态查询
    public String selectByPage(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")) {
                        WHERE("username LIKE CONCAT ('%', #{user.username}, '%')");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals((""))) {
                        WHERE("status LIKE CONCAT ('%', #{user.status}, '%')");
                    }
                }
            }
        }.toString();
    }

    //根据参数查询用户总数
    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !user.getUsername().equals("")) {
                        WHERE("username LIKE CONCAT ('%', #{user.username}, '%')");
                    }
                    if (user.getStatus() != null && !user.getStatus().equals((""))) {
                        WHERE("status LIKE CONCAT ('%', #{user.status}, '%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入用户
    public String save(User user) {
        return new SQL() {
            {
                INSERT_INTO(USERTABLE);
                if (user.getUsername() != null && !user.getUsername().equals("")) {
                    VALUES("username", "#{username}");
                }
                if (user.getStatus() != null && !user.getStatus().equals("")) {
                    VALUES("status", "#{status}");
                }
                if (user.getLoginname() != null && !user.getLoginname().equals("")) {
                    VALUES("loginname", "#{loginname}");
                }
                if (user.getPassword() != null && !user.getPassword().equals("")) {
                    VALUES("password", "#{password}");
                }
            }
        }.toString();
    }
}
