package pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import pointcut.advices.SimpleAdvice;
import pointcut.beans.BreadBean;

public class MainControlPointcut {

    public static void main(String[] args) {

        MainControlPointcut example = new MainControlPointcut();
        example.run();
    }

    private void run() {

        Pointcut pointcut = new ControlFlowPointcut(MainControlPointcut.class, "test");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        BreadBean target = new BreadBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        BreadBean proxy = (BreadBean) proxyFactory.getProxy();
        System.out.println(":::::: Trying Invoke :\n");
        proxy.sleep();
        System.out.println(":::::: Trying Control Invoke :\n");
        control(proxy);
    }

    private void control(BreadBean bean) {
        bean.sleep();
    }
}
