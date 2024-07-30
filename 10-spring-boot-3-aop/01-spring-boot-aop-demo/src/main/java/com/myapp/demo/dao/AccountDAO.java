package com.myapp.demo.dao;

import com.myapp.demo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
