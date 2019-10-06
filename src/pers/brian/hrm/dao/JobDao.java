/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 9:43
 */
package pers.brian.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import pers.brian.hrm.dao.Provider.JobDynaSQLProvider;
import pers.brian.hrm.domain.Job;

import java.util.List;
import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.JOBTABLE;

@Component
public interface JobDao {
    //根据id查询职位
    //@SelectProvider(type = JobDynaSQLProvider.class, method = "selectById")
    @Select("SELECT * FROM " + JOBTABLE + " WHERE id = #{id}")
    Job selectById(int id);

    //查询所有职位
    //@SelectProvider(type = JobDynaSQLProvider.class, method = "selectAllJob")
    @Select("SELECT * FROM " + JOBTABLE)
    List<Job> selectAllJob();

    //分页动态查询
    @SelectProvider(type = JobDynaSQLProvider.class, method = "selectByPage")
    List<Job> selectByPage(Map<String, Object> params);

    //动态查询总数量
    @SelectProvider(type = JobDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //根据id删除职位
    //@DeleteProvider(type = JobDynaSQLProvider.class, method = "deleteById")
    @Delete("DELETE FROM " + JOBTABLE + " WHERE id = #{id}")
    void deleteById(Integer id);

    //动态插入职位
    @InsertProvider(type = JobDynaSQLProvider.class, method = "save")
    void save(Job job);

    //动态修改职位
    @UpdateProvider(type = JobDynaSQLProvider.class, method = "update")
    void update(Job job);
}
