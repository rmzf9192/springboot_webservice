package com.el.webservice.service;

import com.el.webservice.model.UserModel;

import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 16:08
 * @Version:V1.0
 * @Description:UserService
 */
@WebService(targetNamespace="http://service.webservice.el.com")
public interface UserService {
    UserModel getUser(long id);

    List<UserModel> getUsers(UserModel model);

}
