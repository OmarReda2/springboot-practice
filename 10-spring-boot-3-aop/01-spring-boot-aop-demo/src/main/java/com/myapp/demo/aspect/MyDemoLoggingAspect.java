package com.myapp.demo.aspect;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this where we add all of our related advices for logging

    // let's start with @Before advice


    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.myapp.demo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(public * add*())")
    // @Before("execution(public * add*(com.myapp.demo.Account))")
    //@Before("execution(public * add*(com.myapp.demo.Account, ..))")
    // @Before("execution(public * add*(..))")

    @Before("execution(* com.myapp.demo.*.*.add*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }
}
