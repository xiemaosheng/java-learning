package logAspect.domain.annocation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String action() default "";
}
