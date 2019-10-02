/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:30
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.Notice;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.NOTICETABLE;

public class NoticeDynaSQLProvider {
    // 动态查询
    public String selectByPage(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT ('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("content LIKE CONCAT ('%',#{notice.content},'%')");
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
                FROM(NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT ('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE("content LIKE CONCAT ('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
    }

    //通过id查询通知
    public String selectById(int id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(NOTICETABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 根据id删除公告
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(NOTICETABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 动态插入公告
    public String save(Notice notice) {
        return new SQL() {
            {
                INSERT_INTO(NOTICETABLE);
                if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                    VALUES("title", "#{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals("")) {
                    VALUES("content", "#{content}");
                }
                if (notice.getUser() != null && notice.getUser().getId() != null) {
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    // 动态修改公告
    public String update(Notice notice) {
        return new SQL() {
            {
                UPDATE(NOTICETABLE);
                if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                    SET("title = #{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals("")) {
                    SET("content = #{content}");
                }
                if (notice.getUser() != null && notice.getUser().getId() != null) {
                    SET("user_id = #{user.id}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
