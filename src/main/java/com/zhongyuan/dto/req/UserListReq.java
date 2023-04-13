package com.zhongyuan.dto.req;

import com.github.pagehelper.page.PageParams;
import com.zhongyuan.core.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserListReq {
    @ApiModelProperty(value = "分页参数")
    private PageParam pageParam = new PageParam();
}
