package com.atzwz.seckill.controller;

import com.atzwz.seckill.service.UserService;
import com.atzwz.seckill.vo.LoginVo;
import com.atzwz.seckill.vo.RespBean;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * 登入
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }


    @ResponseBody
    @RequestMapping("/doLogin")
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        return userService.doLogin(loginVo,request,response);
    }
}
