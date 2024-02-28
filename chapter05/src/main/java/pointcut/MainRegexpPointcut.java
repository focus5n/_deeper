package pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import pointcut.advices.SimpleAdvice;
import pointcut.beans.BreadBean;

public class MainRegexpPointcut {

    public static void main(String[] args) {

        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        SimpleAdvice advice = new SimpleAdvice();
        Advisor advisor;
        BreadBean target = new BreadBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        BreadBean proxy;

        // 포인트컷, 어드바이스 => 어드바이저 (애스펙트)
        pointcut.setPattern(".*eat.*");
        advisor = new DefaultPointcutAdvisor(pointcut, advice);

        // 타겟, 어드바이저 => 프록시팩토리
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        
        // 프록시 => 실행
        proxy = (BreadBean) proxyFactory.getProxy();
        proxy.eatChocoBread();
        proxy.eatCheeseBread();
        proxy.eatBerryBread();
        proxy.sleep();
    }
}
