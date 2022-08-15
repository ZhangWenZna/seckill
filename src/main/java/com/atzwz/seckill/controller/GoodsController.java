package com.atzwz.seckill.controller;

import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;
    @RequestMapping("/toList")
    public String toList(Model model, User user){
//        if (StringUtils.isEmpty(ticket)){
//            return "login";
//        }
//        //User user = (User) session.getAttribute(ticket);
//        User user = userService.getUserByCookie(ticket,request,response);
//        if (null==user){
//            return "login";
//        }
        //model.addAttribute("user",user);
        return "goodsList";
    }
}
