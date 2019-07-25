package cn.leap.service.impl;

import cn.leap.mapper.AccountMapper;
import cn.leap.pojo.Account;
import cn.leap.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Before;
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

    /**
     * 加载MyBatis核心配置文件，创建SqlSession对象，并初始化AccountMapper对象
     * @throws IOException
     */
    //@Before //junit中的@Before测试，在此处不能用了。
    /*
     sqlSession对象需要在每个方法中去生成。
     SqlSession还需要自己去手动创建（new出来），这是因为MyBatis框架还未与Spring框架进行整合。
     这也正是传统的SSM框架整合方式的一大缺点！！
     实际上，这只能叫web项目中使用了SSM框架，但并未将SSM三大框架有机整合起来，形成一个整体！
     */
    public AccountMapper setup() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        return accountMapper;
    }

    @Override
    public void addNewAccount(Account account) throws IOException {
        AccountMapper accountMapper = new AccountServiceImpl().setup();
        accountMapper.addNewAccount(account);
    }

    @Override
    public List<Account> findAllAccount() throws IOException {
        AccountMapper accountMapper = new AccountServiceImpl().setup();
        List<Account> accountList = accountMapper.findAllAccount();
        return accountList;
    }
}
