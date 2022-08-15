package com.atzwz.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User {
    private String id;
    private String nickname;
    private String password;
    private String slat;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
