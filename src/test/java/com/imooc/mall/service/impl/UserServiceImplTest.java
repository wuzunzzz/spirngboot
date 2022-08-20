package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {


    public static final String USERNAME = "jack";

    public static final String PASSWORD = "123456";
    @Autowired
    private IUserService userService;

    @Before
    public void register() throws ParseException {
        Date data1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-3-10");
        Date data2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-3-11");
        User user = new User(USERNAME, PASSWORD, "jack@qq.com", RoleEnum.CUSTOMER.getCode(), data1, data2);
        ;
        userService.register(user);
    }

    @Test
    public void login() throws ParseException {
        register();
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}