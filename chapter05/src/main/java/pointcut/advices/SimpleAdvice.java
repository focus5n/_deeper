package pointcut.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(">>>>>> Invoking : " + invocation.getMethod().getName());
        Object returnValue = invocation.proceed();
        System.out.println(">>>>>> Invoking : " + invocation.getMethod().getName());

        return returnValue;
    }
}
