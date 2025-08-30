package com.example.springbootcommon.domain;

import lombok.Data;

@Data
public class PageQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String orderBy;
    private String orderType = "desc";

    public Integer getOffset() {
        return (pageNum - 1) * pageSize;
    }
}