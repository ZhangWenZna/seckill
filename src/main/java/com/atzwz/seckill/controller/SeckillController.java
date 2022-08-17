package com.atzwz.seckill.controller;


import com.atzwz.seckill.pojo.Order;
import com.atzwz.seckill.pojo.SeckillOrder;
import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.GoodsService;
import com.atzwz.seckill.service.OrderService;
import com.atzwz.seckill.service.SeckillOrderService;
import com.atzwz.seckill.vo.GoodsVo;
import com.atzwz.seckill.vo.RespBean;
import com.atzwz.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private OrderService orderService;

    /**
     * 秒杀
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user,Long goodsId){

        System.out.println("进来了");

        if (user==null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        System.out.println("我进来了0");
        if (goods.getStockCount()<1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_ERROR);
            return "seckillFail";
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder =
                seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq
                        ("user_id", user.getId()).eq("goods_id",goodsId));
        System.out.println("我进来了1");
        if (seckillOrder!=null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROE);
            return "seckillFail";
        }
        Order order=orderService.seckill(user,goods);
        System.out.println("我进来了2");
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        //System.out.println("我到这里了");
        System.out.println(user);
        System.out.println(goods);
        System.out.println(order);

        return "orderDetail";
    }
}
