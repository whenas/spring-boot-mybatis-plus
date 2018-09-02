package com.lu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.entity.BasicInfo;
import com.lu.mode.response.BaseResponse;
import com.lu.mode.response.PageResponse;

/**
 * Created by 卢松炯 on 2018/9/1.
 */
public interface BasicInfoService extends IService<BasicInfo> {
    BaseResponse add(BasicInfo basicInfo);
    BaseResponse query(BasicInfo basicInfo);
    PageResponse page(BasicInfo basicInfo);

}
