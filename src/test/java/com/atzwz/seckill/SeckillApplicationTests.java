package com.atzwz.seckill;

import com.atzwz.seckill.mapper.UserMapper;
import com.atzwz.seckill.pojo.User;
import com.atzwz.seckill.service.UserService;
import com.atzwz.seckill.vo.LoginVo;
import com.atzwz.seckill.vo.RespBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeckillApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {

        User user = userMapper.selectById("18407846313");
        System.out.println(user);
    }

}
