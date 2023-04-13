package com.zhongyuan.service.impl;

import com.zhongyuan.entity.User;
import com.zhongyuan.mapper.UserMapper;
import com.zhongyuan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 敢敢
 * @since 2023-04-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
