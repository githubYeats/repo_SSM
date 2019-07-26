package cn.leap.service.impl;

import cn.leap.mapper.AccountMapper;
import cn.leap.domain.Account;
import cn.leap.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: Feiyue
 * Date: 2019/7/24 19:22
 * Desc:
 */
@Service("accountService")//Spring注解，IoC控制
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public void addNewAccount(Account account) throws IOException {
        accountMapper.addNewAccount(account);
    }

    @Override
    public List<Account> findAllAccount() throws IOException {
        List<Account> accountList = accountMapper.findAllAccount();
        return accountList;
    }
}
