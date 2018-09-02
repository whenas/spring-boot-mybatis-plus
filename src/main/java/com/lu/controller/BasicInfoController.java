package com.lu.controller;

import com.lu.entity.BasicInfo;
import com.lu.mode.response.BaseResponse;
import com.lu.mode.response.PageResponse;
import com.lu.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 卢松炯 on 2018/9/1.
 */
@RestController
@RequestMapping("/basicInfo")
public class BasicInfoController {

    @Autowired
    private BasicInfoService basicInfoService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestBody BasicInfo basicInfo){
        return basicInfoService.add(basicInfo);
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse query(@RequestBody BasicInfo basicInfo){
        return basicInfoService.query(basicInfo);
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ResponseBody
    public PageResponse page(@RequestBody BasicInfo basicInfo){
        return basicInfoService.page(basicInfo);
    }
}
