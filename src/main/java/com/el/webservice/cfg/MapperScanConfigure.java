package com.el.webservice.cfg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 9:46
 * @Version:V1.0
 * @Description:MapperScanConfigure
 */
@Configuration
@MapperScan(value = {
        "com.el.webservice.mapper",
        "com.el.webservice.*.mapper",
        "com.el.webservice.*.*.mapper",
        "com.el.shop.*.mapper",
        "com.el.shop.*.*.mapper",
        "com.el.mbg.mapper",
})
public class MapperScanConfigure {

}
