package org.bestsoft.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

public class FastJsonHttpMessageConverterImpl extends FastJsonHttpMessageConverter {

    @Override
    protected boolean supports(Class<?> clazz) {
        if (clazz.equals(byte[].class)) {
            return false;
        }
        return true;
    }

}
