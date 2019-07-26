package cn.leap.service;

import cn.leap.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * Author: Feiyue
 * Date: 2019/7/24 19:22
 * Desc:
 */
public interface AccountService {

    /**
     * 添加新账户
     * @param account
     */
    void addNewAccount(Account account) throws IOException;

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount() throws IOException;
}
