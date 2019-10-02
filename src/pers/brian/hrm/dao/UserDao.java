/**
 * @Author: BrianHu
 * @Date: 2019/10/1
 * @Time: 16:41
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import pers.brian.hrm.dao.Provider.UserDynaSQLProvider;
import pers.brian.hrm.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    @SelectProvider(type = UserDynaSQLProvider.class, method = "selectByLoginnameAndPassword")
    User selectByLoginnameAndPassword(String loginname, String password);

    @SelectProvider(type = UserDynaSQLProvider.class, method = "selectById")
    User selectById(Integer id);

    @DeleteProvider(type = UserDynaSQLProvider.class, method = "deleteById")
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
