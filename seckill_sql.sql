create table t_user(
    id              bigint(20)   not null comment '用户id，手机号码',
    nickname        varchar(255) not null ,
    password       varchar(32)  default null comment 'MD5(MD5(文明+固定salt)+salf)',
    slat         varchar(10)  default null,
    head            varchar(128) default null comment '头像',
    register_date   datetime     default null comment '注册时间',
    last_login_date datetime     default null comment '最后一次登入时间',
    login_count     int(11)      default '0' comment '登入次数',
    primary key (id)
);

create table goods(
    id bigint(20) not null auto_increment comment '商品ID',
    goods_name varchar(16) default null comment '商品名称',
    goods_title varchar(64) default null comment '商品名标题',
    goods_img varchar(64) default null comment '商品图片',
    goods_detail longtext comment '商品详情',
    goods_price decimal(10,2) default '0.0' comment '商品价格',
    goods_stock INT(11) default '0' comment '库存，-1表示没有限制',
    primary key (id)
);

create table u_order(
    id bigint(20) not null auto_increment comment '订单ID',
    user_id bigint(20) default null comment '用户ID',
    goods_id bigint(20) default null comment '商品ID',
    delivery_addr_id bigint(20) default null comment '送货地址ID',
    goods_name varchar(16) default null comment '冗余过来的商品名称',
    goods_coint int(11) default  '0' comment '商品数量',
    goods_price decimal(10,2) default '0.0' comment '商品成交单价',
    order_channel tinyint(4) default '0' comment '1pc 2android 3ios',
    order_status tinyint(4) default '0' comment '0未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
    create_date datetime default null comment '订单的创建时间',
    pay_date datetime default null comment '订单支付时间',
    primary key (id)
);


create table t_seckill_goods(
    id bigint(20) not null auto_increment comment '秒杀商品id',
    goods_id bigint(20) default null comment '商品id',
    seckill_price decimal(10,2) default '0.00' comment '秒杀价',
    stock_count int(100) default null comment '库存数量',
    start_date datetime default null comment '秒杀开始时间',
    end_date datetime default null comment '秒杀结束时间',
    primary key (id)
);


create table t_seckill_order(
    id bigint(20) not null auto_increment comment '秒杀订单id',
    user_id bigint(20) default null comment '用户id',
    order_id bigint(20) default null comment '订单id',
    goods_id bigint(20) default null comment '商品id',
    primary key (id)
);

select
    g.id,
    g.goods_name,
    g.goods_title,
    g.goods_img,
    g.goods_detail,
    g.goods_price,
    g.goods_stock,
    sg.seckill_price,
    sg.stock_count,
    sg.start_date,
    sg.end_date
    from
        u_goods g left join t_seckill_goods as sg on g.id=sg.goods_id
    where g.id=1



