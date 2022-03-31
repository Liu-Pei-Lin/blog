package cn.est.controller;

import cn.est.dto.ModelDto;
import cn.est.dto.ModelReq;
import cn.est.dto.Page;
import cn.est.oss.OssConfig;
import cn.est.pojo.Model;
import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import cn.est.service.ModelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("model")
public class ModelController {
    @Autowired
    private ModelService modelService;
    @Autowired
    private OssConfig ossConfig;
    @RequestMapping("/search")
    @ApiOperation("查询商品列表")
    public Result search(Integer classifyId,Integer brandId,String modelName,
                         Integer pageNo,Integer pageSize) throws Exception {

        Map params = new HashMap<>();
        params.put("brandId",brandId);
        params.put("classifyId",classifyId);
        params.put("modelName",modelName);
        //获取总条数
        int total = modelService.getModelCountByMap(params);
        //分页对象
        Page page = new Page(pageNo,pageSize,total);
        /*page.setPageNo(pageNo);
        page.setTotal(total);
        page.setPageSize(pageSize);*/
        params.put("beginPos",page.getBeginPos());
        params.put("pageSize",pageSize);

        List<Model> modelList = modelService.getModelListByMap(params);
        List<ModelReq> modelDtoList = new ArrayList<ModelReq>();
        for (Model m : modelList) {
            ModelReq modelReq = new ModelReq();
            BeanUtils.copyProperties(m,modelReq);
            //拼接路径
            String newUrl = "https://"+ossConfig.getOssWebUrl()+ modelReq.getFaceImg();
            modelReq.setFaceImg(newUrl);
            modelDtoList.add(modelReq);
        }
        page.setList(modelDtoList);
        return ResultUtils.returnDataSuccess(page);
    }

    //查看商品详情
    @RequestMapping("{id}/detail")
    public Result detail(@PathVariable("id") Integer id) throws Exception {
        Model model = modelService.getModelById(id+"");
        ModelDto modelDto = new ModelDto(model);
        String newFaceImg = "https://"+ossConfig.getOssWebUrl()+ model.getFaceImg();
        String newContentImg = "https://"+ossConfig.getOssWebUrl()+ model.getContentImg();
        modelDto.setFaceImg(newFaceImg);
        modelDto.setContentImg(newContentImg);
        return ResultUtils.returnDataSuccess(modelDto);

    }
}
