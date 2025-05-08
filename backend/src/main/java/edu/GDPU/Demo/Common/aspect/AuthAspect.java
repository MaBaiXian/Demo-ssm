package edu.GDPU.Demo.Common.aspect;

import edu.GDPU.Demo.Common.annotation.AuthCheck;
import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AuthAspect {

    private static final Logger log = Logger.getLogger(AuthAspect.class);
    @Autowired
    private UserService userService;

    @Around("@annotation(edu.GDPU.Demo.Common.annotation.AuthCheck)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {


        log.info("AuthAspect around11111111111111111111111111111111111111111111111111111");

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 获取注解
        AuthCheck authCheck = method.getAnnotation(AuthCheck.class);

        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];

        // 验证token
        User user = userService.getUserByToken(token);
        if (user == null) {
            throw new RuntimeException("无效的Token");
        }

        // 验证权限
        if (authCheck.roles().length > 0) {
            boolean hasRole = false;
            for (String role : authCheck.roles()) {
                if (role.equals(user.getRoles())) {
                    hasRole = true;
                    break;
                }
            }
            if (!hasRole) {
                throw new RuntimeException("权限不足");
            }
        }

        // 执行原方法
        return joinPoint.proceed();

    }

}