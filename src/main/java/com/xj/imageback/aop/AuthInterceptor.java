package com.xj.imageback.aop;

import com.xj.imageback.annotation.AuthCheck;
import com.xj.imageback.exception.BusinessException;
import com.xj.imageback.exception.ErrorCode;
import com.xj.imageback.model.enums.UserRoleEnum;
import com.xj.imageback.model.vo.LoginUserVO;
import com.xj.imageback.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 执行拦截
     *
     * @param joinPoint 切入点
     * @param authCheck 权限校验注解
     * @return
     * @throws Throwable
     */
    @Around("@annotation(authCheck)")
    public Object authCheck(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 获取当前登录用户
        LoginUserVO currentUser = userService.getCurrentUser(request);
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        // 不需要权限则放行
        if (mustRoleEnum == null) {
            return joinPoint.proceed();
        }
        // 获取当前用户权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(currentUser.getUserRole());
        // 没有权限则拒绝
        if (userRoleEnum == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 管理员权限校验
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum) && ! UserRoleEnum.ADMIN.equals(userRoleEnum)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 通过校验则放行
        return joinPoint.proceed();
    }
}
