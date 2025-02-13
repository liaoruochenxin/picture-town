package com.xj.imageback.service;

import com.xj.imageback.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xj.imageback.model.vo.LoginUserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author MA
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-02-12 11:25:56
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 确认密码
     * @return 用户id
     */
    long userRegitser(String userAccount,String userPassword,String checkPassword);

    /**
     * 用户登录
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request 请求对象
     * @return 脱敏后用户数据
     */
    LoginUserVo userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 密码加密
     * @param password 原始密码
     * @return 加密后密码
     */
    String encryptPassword(String password);
}
