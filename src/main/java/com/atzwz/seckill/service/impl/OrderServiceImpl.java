package com.atzwz.seckill.service.impl;

import com.atzwz.seckill.mapper.OrderMapper;
import com.atzwz.seckill.pojo.Order;
import com.atzwz.seckill.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 黄果
 * @since 2022-08-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
