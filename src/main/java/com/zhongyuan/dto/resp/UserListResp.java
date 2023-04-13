package com.zhongyuan.dto.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserListResp {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "邮箱")
    private String email;
}
