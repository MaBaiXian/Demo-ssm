package edu.GDPU.Demo.Common.aspect;

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

    public AuthAspect() {
        log.info("AuthAspect initialized!");
    }

    @Autowired
    private UserService userService;

    @Around("execution(* edu.GDPU.Demo.Announcement.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        String token = null;

        // 查找String类型的token参数
        for (Object arg : args) {
            if (arg instanceof String) {
                token = (String) arg;
                break;
            }
        }

        if (token == null) {
            throw new RuntimeException("未找到Token参数");
        }

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 验证token
        User user = userService.getUserByToken(token);
        if (user == null) {
            throw new RuntimeException("无效的Token");
        }

//        // 验证权限
//        String[] requiredRoles = {"DormAdmin", "SysAdmin"};
//        boolean hasRole = false;
//        for (String role : requiredRoles) {
//            if (role.equals(user.getRoles())) {
//                hasRole = true;
//                break;
//            }
//        }
//        if (!hasRole) {
//            throw new RuntimeException("权限不足");
//        }

        // 执行原方法
        return joinPoint.proceed();
    }

}