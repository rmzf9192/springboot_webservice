package com.el.webservice.controller;


import com.el.webservice.model.Dept;
import com.el.webservice.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/28 17:15
 * @Version:V1.0
 * @Description:DeptController
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {

        Dept dept =  this.service.get(id);
        log.info("dept equal null is "+(null==dept));
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    @RequestMapping(value="/dept/list",method= RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }


    public Dept processHystrix_Get(@PathVariable("id") Long id){

        return new Dept().setDeptno(id).setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
}
