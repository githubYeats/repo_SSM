package cn.leap.service.impl;

import cn.leap.mapper.AccountMapper;
import cn.leap.pojo.Account;
import cn.leap.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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

    private AccountMapper accountMapper;

    /**
     * 加载MyBatis核心配置文件，创建SqlSession对象，并初始化AccountMapper对象
     * @throws IOException
     */
    public void setup() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Override
    public void addNewAccount(Account account) {
        accountMapper.addNewAccount(account);
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> accountList = accountMapper.findAllAccount();
        return accountList;
    }
}
