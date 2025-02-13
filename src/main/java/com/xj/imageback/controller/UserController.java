package com.xj.imageback.controller;

import cn.hutool.core.util.StrUtil;
import com.xj.imageback.common.BaseResponse;
import com.xj.imageback.common.ResultUtils;
import com.xj.imageback.exception.ErrorCode;
import com.xj.imageback.exception.ThrowUtils;
import com.xj.imageback.model.domain.User;
import com.xj.imageback.model.dto.user.UserLoginRequest;
import com.xj.imageback.model.dto.user.UserRegisterRequest;
import com.xj.imageback.model.vo.LoginUserVo;
import com.xj.imageback.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister (@RequestBody UserRegisterRequest userRegisterRequest){
        ThrowUtils.throwIf(userRegisterRequest == null, ErrorCode.PARAMS_ERROR);
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        long result = userService.userRegitser(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    public BaseResponse<LoginUserVo> userRegister (@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        ThrowUtils.throwIf(userLoginRequest == null, ErrorCode.PARAMS_ERROR);
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        LoginUserVo user = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }
}
