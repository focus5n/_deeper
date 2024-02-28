package pointcut.pointcuts;

import pointcut.beans.ChocoBean;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public ClassFilter getClassFilter() {
        return tmpClass -> tmpClass == ChocoBean.class;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static Check for : " + method.getName());
        return "choco".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic Check for : " + method.getName());
        int x = Integer.parseInt(args[0].toString());

        return x != 100;
    }
}
