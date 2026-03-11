package com.moa.project2.dto;

import lombok.Data;

@Data
public class Page {
    private static final long PAGE = 1;
    private static final long SIZE = 10;
    private static final long COUNT = 10;
    private long page;
    private long size;
    private long count;
    private long total;
    private long start;
    private long end;
    private long first;
    private long last;
    private long prev;
    private long next;
    private long index;

    public Page() {
        this(0);
    }

    public Page(long total) {
        this(PAGE, total);
    }

    public Page(long page, long total) {
        this(page, SIZE, COUNT, total);
    }

    public Page(long page, long size, long count, long total) {
        this.page = page;
        this.size = size;
        this.count = count;
        this.total = total;
        calc();
    }

    public void calc() {
        this.first = 1;
        this.last=  (this.total - 1) / size+1;
        this.start=((page-1)/count) * count+1;
        this.end = ((page-1)/count+1)*count;
        this.end=Math.min(this.end, this.last);
        this.prev=this.page-1;
        this.next=this.page+1;
        this.index=(this.page-1)*this.size;
    }

    public void setTotal(long total){
        this.total=total;
        calc();
    }
}
