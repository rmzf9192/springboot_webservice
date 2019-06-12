package com.el.webservice.service.impl;



import com.el.webservice.mapper.DeptDao;
import com.el.webservice.mapper.DeptMapper;
import com.el.webservice.model.Dept;
import com.el.webservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/28 17:14
 * @Version:V1.0
 * @Description:DeptServiceImpl
 */
//@Service
@WebService(serviceName="DeptService",//对外发布的服务名
        targetNamespace="http://service.webservice.el.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface="com.el.webservice.service.DeptService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private DeptMapper deptMapper ;


    @Override
    public boolean add(Dept dept) {
       // return deptMapper.addDept(dept);
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        //return deptMapper.findById(id);
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
//        List<Dept> deptList = deptMapper.findAll();
        List<Dept> deptList = deptDao.findAll();
        Integer [] str=new Integer[4];
        str[0]=1;
        str[1]=2;
        str[2]=3;
        str[3]=4;
        List<Dept> dept11=new ArrayList<>();
        for(int i=1;i<=4;i++){
            Dept dept1 = new Dept();
            dept1.setDname("生成"+i);
            dept1.setId(i);
            dept11.add(dept1);
        }

        Map<Integer, List<Dept>> collect = deptList.stream().collect(Collectors.groupingBy(dept -> dept.getId()));

        for(Dept i:dept11){
            HashMap<Integer, List<Dept>> hashMap = new HashMap<>();

            int id = i.getId();
            List<Dept> depts = collect.get(id);

            for(Dept dept:depts){
                if(hashMap.keySet().contains(dept.getPid())){
                    hashMap.get(dept.getPid()).add(dept);
                }else{
                    List<Dept> list = new ArrayList<>();
                    list.add(dept);
                    hashMap.put(dept.getPid(),list);
                }
            }

            if(hashMap.keySet().contains(id)){
                i.setChildren(hashMap.get(id));
            }

            for(Dept dept:depts){
                int cid = dept.getCid();
                if(hashMap.keySet().contains(cid)){
                    dept.setChildren(hashMap.get(cid));
                }
            }

        }

        return dept11;
    }
}
