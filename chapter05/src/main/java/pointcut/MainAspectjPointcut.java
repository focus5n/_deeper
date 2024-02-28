package pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import pointcut.advices.SimpleAdvice;
import pointcut.beans.BreadBean;

public class MainAspectjPointcut {

    public static void main(String[] args) {

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        SimpleAdvice advice = new SimpleAdvice();
        Advisor advisor;
        BreadBean target = new BreadBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        BreadBean proxy;

        // 표현식 예시
        // 모든 매개변수 타입 : *(..)
        // 특정 메서드 : execution(* methodName*(..))
        // 모든 메서드 : execution(* *(..))
        // 특정 클래스 내부의 모든 메서드 : execution(* com.example.MyClass.*(..))
        // 특정 패키지 내부의 모든 메서드 : execution(* com.example..*(..))
        // 특정 반환값 갖는 모든 메서드 : execution(public String *(..))
        // 특정 어노테이션이 지정된 모든 메서드 : execution(@com.example.MyAnnotation * *(..))

        pointcut.setExpression("execution(* eat*(..))");
        advisor = new DefaultPointcutAdvisor(pointcut, advice);

        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);
        proxy = (BreadBean) proxyFactory.getProxy();

        proxy.eatChocoBread();
        proxy.eatBerryBread();
        proxy.eatCheeseBread();
        proxy.sleep();
    }
}
