package com.atzwz.seckill.service;

import com.atzwz.seckill.pojo.Order;
import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.extension.service.IService;


public interface OrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
