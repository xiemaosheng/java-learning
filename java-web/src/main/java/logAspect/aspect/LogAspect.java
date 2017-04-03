package logAspect.aspect;

import logAspect.domain.annocation.LogAnnotation;
import logAspect.domain.model.Log;
import logAspect.domain.model.UserReq;
import logAspect.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
@Aspect
@Component
public class LogAspect {
    @Resource
    private LogService logService;

    @Around("aspect()")
    public Object aroundControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result = null;

        Log log = new Log();

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        UserReq req = null;
        String id = null;

        //获取方法体的相关参数
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        Class[] paramTypes = methodSignature.getParameterTypes();
        String[] paramNames = methodSignature.getParameterNames();
        Object[] params = joinPoint.getArgs();

        if (!ObjectUtils.isEmpty(params)){
           for (int i = 0; i < params.length;i++){
               Object param = params[i];
               Class type = paramTypes[i];
               String paramName = paramNames[i];

               if (UserReq.class == type){
                   req = (UserReq) param;
               }else if("id".equals(paramName)){
                   id = (String) param;
               }
           }
        }

        LogAnnotation logAnnotation = giveController(methodSignature);
        String action = logAnnotation.action();

        log.setIp(request.getRemoteAddr());
        log.setUsername(req.getUsername());
        if (!StringUtils.isEmpty(id)){
            log.setId(id);
            if ("保存".equals(action)){
                log.setOperator("save");
            }else if ("删除".equals(action)){
                log.setOperator("delete");
            }
        }

        try {
            result = joinPoint.proceed();
            logService.save(log);
        }catch (Throwable e){
            log.setOperator("fail");
            logService.save(log);
            throw e;
        }
        return result;
    }

    /**
     * 是否存在注解，如果存在就记录日志
     *
     * @param methodSignature
     * @return
     * @throws Exception
     */
    private LogAnnotation giveController(MethodSignature methodSignature) throws Exception {
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(LogAnnotation.class);
        }
        return null;
    }

    /**
     * @deprecated 切点表达式，只切 console 包下包含 @RequestMapping  的方法
     */
    @Pointcut("@annotation(logAspect.domain.annocation.LogAnnotation)")
    public void aspect() {
    }
}
