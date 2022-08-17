package com.atzwz.seckill.controller;

import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.GoodsService;
import com.atzwz.seckill.service.UserService;
import com.atzwz.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


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
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date starDate = goodsVo.getStarDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        System.out.println(starDate);
        System.out.println(nowDate);
        System.out.println();
        //秒杀状态
        int secKillStaus=0;
        //秒杀倒计时
        int remainSeconds=0;
        //秒杀未开始
        if (nowDate.before(starDate)){
            remainSeconds = ((int)((starDate.getTime() - nowDate.getTime()) / 1000));

        } else if (nowDate.after(endDate)) {
            //秒杀已结束
            secKillStaus=2;
            remainSeconds=-1;

        }else {
            //秒杀进行中
            secKillStaus=1;
            remainSeconds=0;
        }
        model.addAttribute("remainSeconds",remainSeconds);

        model.addAttribute("secKillStaus",secKillStaus);

        model.addAttribute("goods",goodsVo);


        return "goodsDetail";
    }
}
