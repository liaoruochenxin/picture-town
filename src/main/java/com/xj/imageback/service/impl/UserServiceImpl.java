package com.xj.imageback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xj.imageback.model.domain.User;
import com.xj.imageback.service.UserService;
import com.xj.imageback.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author MA
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2025-02-12 11:25:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




