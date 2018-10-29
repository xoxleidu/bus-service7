package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.plugins.Page;

public class PageHelper  {

    private static final long serialVersionUID = 1L;

    private Integer currentPage;

    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
