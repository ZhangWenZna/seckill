package com.atzwz.seckill.service;

import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.vo.LoginVo;
import com.atzwz.seckill.vo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService extends IService<User> {
    RespBean doLogin(LoginVo loginVo,HttpServletRequest request, HttpServletResponse response);
    User selectById(String id);

    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);

}
