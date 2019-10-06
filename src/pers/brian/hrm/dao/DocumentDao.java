/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:54
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import pers.brian.hrm.dao.Provider.DocumentDynaSQLProvider;
import pers.brian.hrm.domain.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.DOCUMENTTABLE;

@Component
public interface DocumentDao {
    //动态查询
    @SelectProvider(type = DocumentDynaSQLProvider.class, method = "selectByPage")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "filename", property = "fileName"),
            @Result(column = "create_date", property = "createDate", javaType = Date.class),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "pers.brian.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String, Object> params);

    //动态查询文件数量
    @SelectProvider(type = DocumentDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //动态插入文档
    @InsertProvider(type = DocumentDynaSQLProvider.class, method = "save")
    void save(Document document);

    //根据id查询文件
    //@SelectProvider(type = DocumentDynaSQLProvider.class, method = "selectById")
    @Select("SELECT * FROM " + DOCUMENTTABLE + " WHERE id = #{id}")
    Document selectById(int id);

    //根据id删除文档
    //@DeleteProvider(type = DocumentDynaSQLProvider.class, method = "deleteById")
    @Delete("DELETE FROM " + DOCUMENTTABLE + " WHERE id = #{id}")
    void deleteById(Integer id);

    //动态修改文档
    @UpdateProvider(type = DocumentDynaSQLProvider.class, method = "update")
    void update(Document document);
}
