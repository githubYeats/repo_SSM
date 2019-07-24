package cn.leap.mapper;

import cn.leap.pojo.Account;

import java.util.List;

/**
 * Author: Feiyue
 * Date: 2019/7/24 19:21
 * Desc:
 */
public interface AccountMapper {

    /**
     * 添加新账户
     * @param account
     */
    void addNewAccount(Account account);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();
}
