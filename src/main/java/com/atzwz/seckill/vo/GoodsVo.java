package com.atzwz.seckill.vo;

import com.atzwz.seckill.pojo.Goods;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 商品返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GoodsVo extends Goods {
    private BigDecimal seckillPrice;
    private Integer stockCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date starDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endDate;
}
