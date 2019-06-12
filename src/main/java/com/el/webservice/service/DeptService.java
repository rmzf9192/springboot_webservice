package com.el.webservice.service;

import com.el.webservice.model.Dept;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/28 17:14
 * @Version:V1.0
 * @Description:DeptService
 */
@WebService(targetNamespace="http://service.webservice.el.com")
public interface DeptService {
    boolean add(Dept dept);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    Dept    get(Long id);

    @WebMethod
//标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    List<Dept> list();
}
