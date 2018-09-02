package com.lu.mode.response;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by 卢松炯 on 2018/9/2.
 */
public class PageResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<T> records;
    private int total;
    private int size;
    private int pages;
    private int current;
    private boolean searchCount;
    private boolean optimizeCount;
    private String orderByField;
    private boolean isAsc;
    private Integer returnCode;
    private String message;

    public PageResponse() {
        this.records = Collections.emptyList();
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.optimizeCount = false;
        this.isAsc = true;
    }

    public PageResponse(int current, int size) {
        this(current, size, true);
    }

    public PageResponse(int current, int size, String orderByField) {
        this.records = Collections.emptyList();
        this.setOrderByField(orderByField);
    }

    public PageResponse(int current, int size, boolean searchCount) {
        this.records = Collections.emptyList();
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.optimizeCount = false;
        this.isAsc = true;
        if(current > 1) {
            this.current = current;
        }

        this.size = size;
        this.searchCount = searchCount;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    protected static int offsetCurrent(int current, int size) {
        return current > 0?(current - 1) * size:0;
    }

    public int getOffsetCurrent() {
        return offsetCurrent(this.current, this.size);
    }

    public boolean hasPrevious() {
        return this.current > 1;
    }

    public boolean hasNext() {
        return this.current < this.pages;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        if(this.size == 0) {
            return 0;
        } else {
            this.pages = this.total / this.size;
            if(this.total % this.size != 0) {
                ++this.pages;
            }

            return this.pages;
        }
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCurrent() {
        return this.current;
    }

    public boolean isSearchCount() {
        return this.searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public boolean isOptimizeCount() {
        return this.optimizeCount;
    }

    public void setOptimizeCount(boolean optimizeCount) {
        this.optimizeCount = optimizeCount;
    }

    public String getOrderByField() {
        return this.orderByField;
    }

    public void setOrderByField(String orderByField) {
        if(StringUtils.isNotEmpty(orderByField)) {
            this.orderByField = orderByField;
        }

    }

    public boolean isAsc() {
        return this.isAsc;
    }

    public void setAsc(boolean isAsc) {
        this.isAsc = isAsc;
    }

    public String toString() {
        StringBuffer pg = new StringBuffer();
        pg.append(" Page:{ [").append(super.toString()).append("], ");
        if(this.records != null) {
            pg.append("records-size:").append(this.records.size());
        } else {
            pg.append("records is null");
        }

        return pg.append(" }").toString();
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReturnCode() {
        return this.returnCode;
    }

    public String getMessage() {
        return this.message;
    }
}

