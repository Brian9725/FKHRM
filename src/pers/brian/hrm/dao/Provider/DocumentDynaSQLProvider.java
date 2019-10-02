/**
 * @Author: BrianHu
 * @Date: 2019/10/2
 * @Time: 10:45
 */
package pers.brian.hrm.dao.Provider;

import org.apache.ibatis.jdbc.SQL;
import pers.brian.hrm.domain.Document;

import java.util.Map;

import static pers.brian.hrm.util.common.HrmConstants.DOCUMENTTABLE;

public class DocumentDynaSQLProvider {
    //动态查询
    public String selectByPage(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT ('%',#{document.title},'%')");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
        }
        return sql;
    }

    //动态查询文件数量
    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM(DOCUMENTTABLE);
                if (params.get("document") != null) {
                    Document document = (Document) params.get("document");
                    if (document.getTitle() != null && !document.getTitle().equals("")) {
                        WHERE("title LIKE CONCAT ('%',#{document.title},'%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入文档
    public String save(Document document) {
        return new SQL() {
            {
                INSERT_INTO(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    VALUES("title", "#{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    VALUES("filename", "#{fileName}");
                }
                if (document.getRemark() != null && !document.getRemark().equals("")) {
                    VALUES("remark", "#{remark}");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    //根据id查询文件
    public String selectById(int id) {
        return new SQL() {
            {
                SELECT("*");
                FROM(DOCUMENTTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //根据id删除文档
    public String deleteById(Integer id) {
        return new SQL() {
            {
                DELETE_FROM(DOCUMENTTABLE);
                WHERE("id = #{id}");
            }
        }.toString();
    }

    //动态修改文档
    public String update(Document document) {
        return new SQL() {
            {
                UPDATE(DOCUMENTTABLE);
                if (document.getTitle() != null && !document.getTitle().equals("")) {
                    SET("title = #{title}");
                }
                if (document.getFileName() != null && !document.getFileName().equals("")) {
                    SET("filename = #{fileName}");
                }
                if (document.getRemark() != null && !document.getRemark().equals("")) {
                    SET("remark = #{remark}");
                }
                if (document.getUser() != null && document.getUser().getId() != null) {
                    SET("user_id = #{user.id}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
