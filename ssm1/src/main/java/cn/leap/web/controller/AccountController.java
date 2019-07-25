package cn.leap.web.controller;

import cn.leap.pojo.Account;
import cn.leap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Author: Feiyue
 * Date: 2019/7/24 19:23
 * Desc:
 */
@Controller //Spring注解，IoC控制
@RequestMapping("/account")
public class AccountController {

    @Autowired //Spring注解，按类型注入Bean对象
    private AccountService accountService;

    /**
     * 新增账户
     * --接收并处理http请求，向数据库加入数据
     * --不从数据库取任何数据，但仍要给前端页面响应一些提示信息！
     * ------新增账户后，给前端页面响应一下，给一个提示：添加账户成功！
     * ----------实际业务中，新增成功后，应该跳到账户信息展示页面。这里只做案例演示而已！
     * @param account
     */
    @RequestMapping("/add") //SpringMVC注解，设置请求路径映射
    @ResponseBody //SpringMVC注解，告知框架，该业务方法不是要做页面跳转，而是回写数据
    public String addNewAccount(Account account) throws IOException {
        accountService.addNewAccount(account);
        //return "添加账户成功！";//哪个页面发送的http请求，该提示信息就返回给哪个页面  add.jsp
        return "add success";
    }

    /**
     * 查询所有账户信息
     * --接收并处理http请求，从数据库中取数据
     * --取完数据后，要将查询结果返回给前端页面：通过@ResponseBody注解 + ModelAndView对象
     */
    @RequestMapping("/findAllAccount")
    public ModelAndView findAllAccount() throws IOException {
        ModelAndView mv = new ModelAndView();
        List<Account> accountList = accountService.findAllAccount();
        mv.addObject("accounts",accountList);
        mv.setViewName("list");//展示查询结果的页面是list.jsp
        return mv;
    }
}
