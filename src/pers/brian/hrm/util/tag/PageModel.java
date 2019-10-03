/**
 * @Author: BrianHu
 * @Date: 2019/10/3
 * @Time: 8:41
 */
package pers.brian.hrm.util.tag;

import pers.brian.hrm.util.common.HrmConstants;

public class PageModel {
    //分页总数据条数
    private int recordCount;
    //当前页面
    private int pageIndex;
    //每页的数据条数
    private int pageSize = HrmConstants.PAGE_DEFAULT_SIZE;
    //总页数
    private int totalSize;

    public int getRecordCount() {
        this.recordCount = (this.recordCount < 0) ? 0 : this.recordCount;
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        this.pageIndex = (this.pageSize <= 0) ? 1 : this.recordCount;
        this.pageIndex = (this.pageSize > this.getTotalSize()) ? this.totalSize : this.recordCount;
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        this.pageSize = (this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE) ? HrmConstants.PAGE_DEFAULT_SIZE : this.pageSize;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        if (this.getRecordCount() <= 0) {
            totalSize = 0;
        } else {
            totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
        }
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getFirstLimitParam() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }
}
