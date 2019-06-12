package com.el.webservice.cfg;

import com.el.webservice.service.DeptService;
import com.el.webservice.service.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 15:36
 * @Version:V1.0
 * @Description:CxfConfigure
 */
@Configuration
public class CxfConfigure {
    @Autowired
    private Bus bus;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;

    /**
           * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
           * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
           * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
           * @return
           */
    /* @SuppressWarnings("all")
     @Bean
    public ServletRegistrationBean dispatcherServlet() {

         return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
     }*/
    @Bean
    public ServletRegistrationBean disServlet(){

        return new ServletRegistrationBean(new CXFServlet() , "/soap/*");
    }

   /* @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");// 发布服务名称 localhost:8080/cxf

    }*/


    /** JAX-WS
           * 站点服务
           * **/
     @Bean
     public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, deptService);
        endpoint.publish("/dept");
        return endpoint;
     }
    /** JAX-WS
     * 站点服务
     * **/
    @Bean
    public Endpoint userService() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService);
        endpoint.publish("/user");
        return endpoint;
    }
}
