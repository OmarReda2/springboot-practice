package com.myapp.demo.aspect;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.myapp.demo.dao.*.*(..))")
    private void forDaoPackage(){}

    // create pointcut for getter methode
    @Pointcut("execution(* com.myapp.demo.dao.*.get*(..))")
    private void getter(){}

    // create pointcut for setter methode
    @Pointcut("execution(* com.myapp.demo.dao.*.set*(..))")
    private void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter")
    public void performApiAnalytics(){
        System.out.println("\n=====> Performing Api Analytics");
    }

    @Before("forDaoPackageNoGetterSetter")
    public void logToCloudAsync(){
        System.out.println("\n=====> logging to cloud in async fashion");
    }
}
