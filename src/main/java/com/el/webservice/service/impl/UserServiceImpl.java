package com.el.webservice.service.impl;

import com.el.webservice.model.UserModel;
import com.el.webservice.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 16:10
 * @Version:V1.0
 * @Description:UserServiceImpl
 */
@WebService(serviceName="UserService",//对外发布的服务名
        targetNamespace="http://service.webservice.el.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface="com.el.webservice.service.UserService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class UserServiceImpl implements UserService {
    @Override
    public UserModel getUser(long id) {

        return new UserModel("小米",true,10);
    }

    @Override
    public List<UserModel> getUsers(UserModel model) {
        List lists =new ArrayList();
        lists.add(new UserModel("小明",false,11));
        lists.add(new UserModel("小李",false,11));
        lists.add(new UserModel("小张",false,11));
        return lists;
    }
}
