package pointcut.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 리플렉션으로 접근할 때 필수
@Retention(RetentionPolicy.RUNTIME)
// 클래스, 메서드에 적용 가능
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface SimpleAnnotationRequired {
}
