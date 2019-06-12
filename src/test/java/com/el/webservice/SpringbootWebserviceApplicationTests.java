package com.el.webservice;

import com.el.webservice.model.Dept;
import com.el.webservice.service.DeptService;
import com.el.webservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootWebserviceApplicationTests {

    /**
     * 1.代理工厂方法
     */
    @Test
    public void contextLoads() {
        //接口地址
        String address="http://127.0.0.1:8080/soap/dept?wsdl";
        //创建代理类工厂
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        //设置代理地址
        factoryBean.setAddress(address);
        //设置接口类型
        factoryBean.setServiceClass(DeptService.class);
        //创建一个代理接口实现
        DeptService deptService = (DeptService)factoryBean.create();
        //数据准备
        Long i=1L;
        //调用代理类接口方法，并返回对应结果
        Dept dept = deptService.get(i);
        log.info("dept:{}",dept);
    }
    @Test
    public void test2(){
        //创建动态客户端
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://127.0.0.1:8080/soap/dept?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        // invoke("方法名",参数1,参数2,参数3....);
        try {
            Object[] dpets = client.invoke("get", 1L);
            Object[] dpetList = client.invoke("list");
            Object[] invoke = client.invoke("add", new Dept("客户端测试"));

            log.info("动态调用获取的数据:{}",dpets[0]);
            log.info("动态调用获取的数据:{}",invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
