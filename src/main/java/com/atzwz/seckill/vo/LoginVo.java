package com.atzwz.seckill.vo;

import com.atzwz.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
    @NotNull
    @IsMobile(requird = true)
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;

    public LoginVo(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
}
