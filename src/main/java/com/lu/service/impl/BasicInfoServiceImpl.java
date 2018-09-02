package com.lu.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lu.entity.BasicInfo;
import com.lu.enums.ReturnCodeEnum;
import com.lu.mapper.BasicInfoMapper;
import com.lu.mode.response.BaseResponse;
import com.lu.mode.response.PageResponse;
import com.lu.service.BasicInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by 卢松炯 on 2018/9/1.
 */
@Service
public class BasicInfoServiceImpl extends ServiceImpl<BasicInfoMapper, BasicInfo> implements BasicInfoService {

    @Override
    public BaseResponse<BasicInfo> add(BasicInfo basicInfo) {
        BaseResponse<BasicInfo> response = new BaseResponse();
        int total = baseMapper.insert(basicInfo);
        if(total>0){
            System.out.println("wwwww:"+basicInfo.getId());
            response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        }else{
            response.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        return response;
    }

    @Override
    public BaseResponse query(BasicInfo basicInfo) {
        BaseResponse response = new BaseResponse();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",1036155182088310786L);
       int count = baseMapper.selectCount(queryWrapper);
        response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
        response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        response.setDataInfo(count);
        return null;
    }

    @Override
    public PageResponse<BasicInfo> page(BasicInfo basicInfo) {
        PageResponse pageResponse = new PageResponse();
        Page<BasicInfo> page = new Page();
        page.setCurrent(1);
        page.setSize(10);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("user_name","zhang");
         page =(Page) baseMapper.selectPage(page,queryWrapper);
         pageResponse.setRecords(page.getRecords());
         pageResponse.setTotal((int)page.getTotal());
        pageResponse.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
        pageResponse.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        return pageResponse;
    }
}
