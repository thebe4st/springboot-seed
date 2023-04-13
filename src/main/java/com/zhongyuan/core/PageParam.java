package com.zhongyuan.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel("分页查询参数")
@Builder
public class PageParam {
    @ApiModelProperty(value = "当前页码",required = true,example = "1")
    private Integer page=1;
    @ApiModelProperty(value = "分页大小",required = true,example = "20")
    private Integer size=20;
    public PageParam(){

    }
    public PageParam(Integer page,Integer size){
        this.page=page;
        this.size=size;
    }
    public int getFrom(){
        return this.page > 0 ? (this.page - 1) * this.size : 0;
    }
}
