package com.atzwz.seckill.controller;

import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.GoodsService;
import com.atzwz.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

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
        model.addAttribute("user",user);
        //System.out.println(goodsService.findGoodsVo());
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转商品详情页
     * @return
     * goods/toDetail
     */
    @GetMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId){
        model.addAttribute("user",user);
        //System.out.println(goodsService.findGoodsVoByGoodsId(goodsId));
        model.addAttribute("goods",goodsService.findGoodsVoByGoodsId(goodsId));


        return "goodsDetail";
    }
}
