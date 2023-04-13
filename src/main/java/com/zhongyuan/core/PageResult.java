package com.zhongyuan.core;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private String errMsg;
    private List<T> data;
    // 当前是第几页的数据
    private Integer page = 1;
    // 返回了多少条数据
    private Integer size = 20;
    // 总共有多少条数据
    private Integer total = 0;

    public boolean isSuccess() {
        return total != null && size != null && page != null && data != null;
    }

    public PageResult(String errMsg) {
        this.errMsg = errMsg;
    }

    public PageResult(List<T> data, Integer size, Integer total, Integer page) {
        this.data = data;
        this.size = size;
        this.total = total;
        this.page = page;
    }

    public Integer totalPage() {
        return (total + size - 1) / size;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public List<T> getData() {
        return data;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotal() {
        return total;
    }
}
