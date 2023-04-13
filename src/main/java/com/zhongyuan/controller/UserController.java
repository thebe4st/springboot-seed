package com.zhongyuan.controller;

import com.github.pagehelper.PageHelper;
import com.zhongyuan.commons.PageUtil;
import com.zhongyuan.core.PageResult;
import com.zhongyuan.core.Result;
import com.zhongyuan.core.ResultGenerator;
import com.zhongyuan.dto.req.UserListReq;
import com.zhongyuan.dto.resp.UserListResp;
import com.zhongyuan.entity.User;
import com.zhongyuan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 敢敢
 * @since 2023-04-13
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<PageResult<UserListResp>> userList(@RequestBody UserListReq req) {
        PageHelper.startPage(req.getPageParam().getPage(), req.getPageParam().getSize());
        List<User> list = userService.lambdaQuery().list();
        return ResultGenerator.genSuccessResult(PageUtil.toPageResult(list, UserListResp.class));
    }
}
