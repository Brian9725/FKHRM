/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:41
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pers.brian.hrm.dao.Provider.UserDynaSQLProvider;
import pers.brian.hrm.domain.User;
import pers.brian.hrm.util.common.HrmConstants;

import java.util.List;
import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.USERTABLE;

@Component
public interface UserDao {
    //@SelectProvider(type = UserDynaSQLProvider.class, method = "selectByLoginnameAndPassword")
    @Select("SELECT * FROM " + USERTABLE + " WHERE loginname = #{loginname} AND password = #{password}")
    User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

    //@SelectProvider(type = UserDynaSQLProvider.class, method = "selectById")
    @Select("SELECT * FROM " + USERTABLE + " WHERE id = #{id}")
    User selectById(Integer id);

    //@DeleteProvider(type = UserDynaSQLProvider.class, method = "deleteById")
    @Delete(("DELETE FROM " + USERTABLE + " WHERE id = #{id}"))
    void deleteById(Integer id);

    @UpdateProvider(type = UserDynaSQLProvider.class, method = "update")
    void update(User user);

    @SelectProvider(type = UserDynaSQLProvider.class, method = "selectByPage")
    List<User> selectByPage(Map<String, Object> param);

    @SelectProvider(type = UserDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> param);

    @UpdateProvider(type = UserDynaSQLProvider.class, method = "save")
    void save(User user);
}
