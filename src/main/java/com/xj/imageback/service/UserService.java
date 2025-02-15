package com.xj.imageback.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xj.imageback.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xj.imageback.model.dto.user.UserQueryRequest;
import com.xj.imageback.model.vo.LoginUserVO;
import com.xj.imageback.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 密码加密
     * @param password 原始密码
     * @return 加密后密码
     */
    String encryptPassword(String password);

    /**
     * 用户数据脱敏
     * @param user 用户信息
     * @return 脱敏后用户信息
     */
    LoginUserVO getLoginUserVo(User user);

    /**
     * 获取当前用户
     * @param request 请求
     * @return 脱敏后当前用户
     */
    LoginUserVO getCurrentUser(HttpServletRequest request);

    /**
     * 用户注销
     * @param request 请求
     * @return 是否注销成功
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 获取脱敏后用户信息
     * @param user 用户
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 批量脱敏
     * @param users
     * @return
     */
    List<UserVO> getUserVOList(List<User> users);

    /**
     * 构造分页查询的queryWrapper
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);
}
