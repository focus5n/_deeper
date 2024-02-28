package pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import pointcut.advices.SimpleAdvice;
import pointcut.annotations.SimpleAnnotationRequired;
import pointcut.beans.BreadBean;
import pointcut.beans.ChocoBean;
import pointcut.beans.EaterBean;

public class MainAnnotationPointcut {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory();
        EaterBean target = new BreadBean();
        Advisor advisor;
        SimpleAdvice advice = new SimpleAdvice();
        AnnotationMatchingPointcut pointcut;
        EaterBean proxy;

        // 이 부분이 핵심
        pointcut = AnnotationMatchingPointcut.forMethodAnnotation(SimpleAnnotationRequired.class);
        advisor = new DefaultPointcutAdvisor(pointcut, advice);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        proxy = (EaterBean) proxyFactory.getProxy();

        proxy.eatBreadWithMilk(new ChocoBean());
    }
}
