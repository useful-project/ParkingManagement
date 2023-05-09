package com.it.common.page;


/**
 * @author Zhiwei Wang
 * @version $1.0
 * @description 分页请求
 * @date 2022/1/19 9:25
 * @history
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    public PageRequest(int start, int limit) {
        pageNum=start;
        pageSize=limit;
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

