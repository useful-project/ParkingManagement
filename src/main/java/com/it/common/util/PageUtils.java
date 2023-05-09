package com.it.common.util;


import com.it.common.page.PageRequest;
import com.it.common.page.PageResult;
import com.github.pagehelper.PageInfo;


/**
 * @author Zhiwei Wang
 * @version $
 * @name PageUtil
 * @description
 * @date 2022/1/19 9:26
 * @history
 */
public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}

