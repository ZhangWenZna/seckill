package com.atzwz.seckill;

import com.atzwz.seckill.mapper.GoodsMapper;
import com.atzwz.seckill.mapper.SeckillGoodsMapper;
import com.atzwz.seckill.mapper.SeckillOrderMapper;
import com.atzwz.seckill.mapper.UserMapper;
import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.GoodsService;
import com.atzwz.seckill.service.SeckillGoodsService;
import com.atzwz.seckill.service.SeckillOrderService;
import com.atzwz.seckill.service.UserService;
import com.atzwz.seckill.vo.GoodsVo;
import com.atzwz.seckill.vo.LoginVo;
import com.atzwz.seckill.vo.RespBean;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.atzwz.seckill.mapper")
class SeckillApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Test
    void contextLoads() {

        User user = userMapper.selectById("18407846313");
        System.out.println(user);
        System.out.println(seckillGoodsMapper.selectById(1));
        System.out.println(goodsMapper.selectById(1));
        List<GoodsVo> goodsVo = goodsMapper.findGoodsVo();
        GoodsVo goodsVoByGoodsId = goodsMapper.findGoodsVoByGoodsId(1L);
        System.out.println(goodsVoByGoodsId);
        System.out.println(goodsVo);
       // System.out.println(goodsMapper.findGoodsVo());

    }

}
