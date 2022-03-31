package cn.est.controller;

import cn.est.dto.BrandDto;
import cn.est.dto.ClassifyDto;
import cn.est.dto.ModelDto;
import cn.est.pojo.Brand;
import cn.est.pojo.BrandClassifyRelation;
import cn.est.pojo.Classify;
import cn.est.pojo.Model;
import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import cn.est.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("home")
public class ClassifyController {
    @Autowired
    private ClassifyServiceWeb classifyServiceWeb;
    //获取商品信息列表
    @RequestMapping("classifyTree")
    public Result classifyTree() throws Exception {
        List<ClassifyDto> classifyDtoList = classifyServiceWeb.classifyTree();
        return ResultUtils.returnDataSuccess(classifyDtoList);
    }
}
