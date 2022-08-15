package com.atzwz.seckill.vo;

import com.atzwz.seckill.utils.ValidatorUtil;
import com.atzwz.seckill.validator.IsMobile;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验规则
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    boolean requird=false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        requird = constraintAnnotation.requird();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (requird){
            return ValidatorUtil.isMobile(value);
        }else {
            if(StringUtils.isEmpty(value)){
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
