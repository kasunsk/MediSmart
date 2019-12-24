package com.company.medismart.channel.param;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableSupport implements Pageable {

    private int pageNumber;
    private int pageSize = 10;
    private int limit;
    private int offset;
    private boolean isPaged = false;

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public boolean isPaged() {
        return isPaged;
    }

    public void setPaged(boolean paged) {
        isPaged = paged;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
