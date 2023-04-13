package com.zhongyuan.commons;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import com.zhongyuan.core.PageResult;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
public class PageUtil {
    public static <T> PageResult<T> toPageResult(List<T> l) {
        if(l instanceof Page) {
            PageInfo<T> pi = new PageInfo<T>(l);
            return new PageResult<T>(l,pi.getPageSize(),(int)pi.getTotal(),pi.getPageNum());
        }
        return new PageResult<T>(l,0,0,0);
    }
    public static <T,D> PageResult<D> toPageResult(List<T> l, Class<D> clazz) {
        return toPageResult(l,clazz,x->{});
    }
    public static <T,D> PageResult<D> toPageResult(List<T> l, Class<D> clazz, Consumer<D> postProcess) {
        List<D> dl = l.stream().map(t -> {
            try {
                D d = clazz.newInstance();
                BeanUtil.copyProperties(t, d, CopyOptions.create().ignoreNullValue().ignoreError().ignoreCase());
                return d;
            } catch (Exception e) {
                throw new RuntimeException(clazz.getName() + " new instance fail");
            }
        }).peek(postProcess).collect(Collectors.toList());
        if(l instanceof Page) {
            PageInfo<T> pi = new PageInfo<T>(l);
            return new PageResult<D>(dl,pi.getPageSize(),(int)pi.getTotal(),pi.getPageNum());
        }
        return new PageResult<D>(dl,0,0,0);
    }
}
