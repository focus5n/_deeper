package dynamicPointcut;

import dynamicPointcut.advices.SimpleAdvice;
import dynamicPointcut.beans.SimpleBean;
import dynamicPointcut.pointcuts.SimpleDynamicPointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class MainDynamicPointcut {

    public static void main(String[] args) {

        // 포인트컷, 어드바이스 => 어드바이저 (애스펙트)
        SimpleDynamicPointcut pointcut = new SimpleDynamicPointcut();
        SimpleAdvice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        // 타겟, 어드바이저 => 프록시팩토리
        SimpleBean target = new SimpleBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        // 프록시팩토리 => 프록시
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();
        proxy.choco(10);
        proxy.choco(100);
        proxy.choco(1000);

        proxy.milk();
        proxy.milk();
        proxy.milk();
    }
}
