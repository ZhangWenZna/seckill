package com.atzwz.seckill.service.impl;

import com.atzwz.seckill.exception.GlobalException;
import com.atzwz.seckill.mapper.UserMapper;
import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.UserService;
import com.atzwz.seckill.utils.CookieUtil;
import com.atzwz.seckill.utils.MD5Util;
import com.atzwz.seckill.utils.UUIDUtil;
import com.atzwz.seckill.vo.LoginVo;
import com.atzwz.seckill.vo.RespBean;
import com.atzwz.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String password = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        //if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password))
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        //if (! ValidatorUtil.isMobile(mobile)){
            //return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        //}
        User user=userMapper.selectById(mobile);
        if (null==user){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (! MD5Util.fromPassToDBPass(password,user.getSlat()).equals(user.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        redisTemplate.opsForValue().set("user"+ticket,user);
        //request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);

        return RespBean.success();
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)){
            //System.out.println(111);
            return null;
        }
        //System.out.println(userTicket);
        User user = (User) redisTemplate.opsForValue().get("user"+userTicket);
        //System.out.println(user);
        if (user!=null){
            CookieUtil.setCookie(request,response,"userTicket",userTicket);
        }
        return user;
    }


}
