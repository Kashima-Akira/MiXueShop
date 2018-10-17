package com.xzy.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by css on 2018/7/30.
 */
public class EasyUIDataGridResult<E> implements Serializable {
    private Long total;
    private List<E> rows;
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}
