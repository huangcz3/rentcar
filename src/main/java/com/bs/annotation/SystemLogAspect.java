package com.bs.annotation;

import com.bs.pojo.Logs;
import com.bs.pojo.User;
import com.bs.service.LogsService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.sql.Date;


/**
 * @author User
 */
@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = Logger.getLogger(SystemLogAspect.class);

    @Resource
    //设置切点
    private LogsService logsService;

    private static String getServiceMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arg = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arg.length) {
                    //添加描述
                    description = method.getAnnotation(SystemLog.class).description();
                    break;
                }
            }
        }
        return description;


    }

    @Pointcut("execution (* com.bs.controller.*.*(..))")
    public void controllerAspect() {

    }


    /**
     * 后置通知
     * @param joinPoint
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        HttpSession session = request.getSession();
        // 读取session中的用户 //待实现
        User user = (User) session.getAttribute("user");

        // 请求的IP
        String ip = request.getRemoteAddr();
        try {
            // *========控制台输出=========*//
//			System.out.println("=====后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            /*System.out.println("请求人:" + user.getFullname());
            System.out.println("请求IP:" + ip);*/
            // *========数据库=========*//
            Logs log = new Logs();
            log.setUsername(user.getUsername());
            log.setAction(getServiceMethodDescription(joinPoint));   // 描述信息
            log.setActiontime(new Date(System.currentTimeMillis()).toString());
            logsService.addLogs(log);
            logger.info(log);
        } catch (Exception e) {
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}" + e.getMessage());
        }

    }


}
