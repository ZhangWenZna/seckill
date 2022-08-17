package com.atzwz.seckill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("u_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 送货地址ID
     */
    private Long deliveryAddrId;

    /**
     * 冗余过来的商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCoint;

    /**
     * 商品成交单价
     */
    private BigDecimal goodsPrice;

    /**
     * 1pc 2android 3ios
     */
    private Integer orderChannel;

    /**
     * 0未支付，1已支付，2已发货，3已收货，4已退款，5已完成
     */
    private Integer orderStatus;

    /**
     * 订单的创建时间
     */
    private Date createDate;

    /**
     * 订单支付时间
     */
    private Date payDate;

}
