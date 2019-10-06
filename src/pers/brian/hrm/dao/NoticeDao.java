/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:39
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import pers.brian.hrm.dao.Provider.NoticeDynaSQLProvider;
import pers.brian.hrm.domain.Notice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.NOTICETABLE;

@Component
public interface NoticeDao {
    //动态查询
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "selectByPage")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_date", property = "createDate", javaType = Date.class),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "pers.brian.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPage(Map<String, Object> params);

    //动态查询总数量
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //通过id查询通知
    //@SelectProvider(type = NoticeDynaSQLProvider.class, method = "selectById")
    @Select("SELECT * FROM " + NOTICETABLE + " WHERE id = #{id}")
    Notice selectById(int id);

    //根据id删除公告
    //@DeleteProvider(type = NoticeDynaSQLProvider.class, method = "deleteById")
    @Delete("DELETE FROM " + NOTICETABLE + " WHERE id = #{id}")
    void deleteById(Integer id);

    //动态插入公告
    @InsertProvider(type = NoticeDynaSQLProvider.class, method = "save")
    void save(Notice notice);

    //动态修改公告
    @UpdateProvider(type = NoticeDynaSQLProvider.class, method = "update")
    void update(Notice notice);
}
