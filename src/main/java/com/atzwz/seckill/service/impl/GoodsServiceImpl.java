package com.atzwz.seckill.service.impl;

import com.atzwz.seckill.mapper.GoodsMapper;
import com.atzwz.seckill.pojo.Goods;
import com.atzwz.seckill.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
