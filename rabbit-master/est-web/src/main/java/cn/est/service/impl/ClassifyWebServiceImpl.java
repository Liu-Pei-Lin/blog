package cn.est.service.impl;

import cn.est.constants.Constants;
import cn.est.dto.BrandDto;
import cn.est.dto.ClassifyDto;
import cn.est.dto.ModelDto;
import cn.est.pojo.Brand;
import cn.est.pojo.BrandClassifyRelation;
import cn.est.pojo.Classify;
import cn.est.pojo.Model;
import cn.est.redis.RedisKeyUtils;
import cn.est.redis.RedisUtils;
import cn.est.service.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClassifyWebServiceImpl implements ClassifyServiceWeb {
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandClassifyRelationService bcrService;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<ClassifyDto> classifyTree() throws Exception {
        //编写调用查询业务层对应的方法,组装数据
        //性能优化
        //获取redis是否存储商品分类信息
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.KEY_HOME_TREE);
        Object obj = redisUtils.get(key);
        List<Classify> classifyList = classifyService.getClassifyListByMap(null);
        List<ClassifyDto> classifyDtoList = new ArrayList<ClassifyDto>();
        if(obj == null) {
            //调用业务商品分类的查询方法
            List<Brand> brandList = brandService.getBrandListByMap(null);
            for (Classify c : classifyList) {
                ClassifyDto classifyDto = new ClassifyDto();
                //BeanUtils对实体对象操作的工具类
                //copyProperties(y原来的对象,新的对象) 复制属性并赋值
                BeanUtils.copyProperties(c, classifyDto);

                //给branList集合赋值
                //手机 ———— 品牌 手机的品牌
                Map cParam = new HashMap<>();
                cParam.put("classifyId", c.getId());
                List<BrandClassifyRelation> bcrList = bcrService.getBrandClassifyRelationListByMap(cParam);
                List<BrandDto> brandDtoList = new ArrayList<BrandDto>();
                for (BrandClassifyRelation bcr : bcrList) {
                    for (Brand b : brandList) {
                        if (bcr.getBrandId() == b.getId()) {
                            BrandDto brandDto = new BrandDto();
                            BeanUtils.copyProperties(b, brandDto);//拷贝属性
                            //给品牌得型号列表类型(modelList)
                            brandDtoList.add(brandDto);
                            List<ModelDto> modelDtoList = new ArrayList<ModelDto>();
                            Map mParam = new HashMap();
                            mParam.put("brandId", b.getId());
                            mParam.put("classifyId", bcr.getClassifyId());
                            List<Model> modelList = modelService.getModelListByMap(mParam);
                            for (Model m : modelList) {
                                ModelDto modelDto = new ModelDto();
                                BeanUtils.copyProperties(m, modelDto);
                                modelDtoList.add(modelDto);
                            }
                            brandDto.setModelList(modelDtoList);
                            brandDtoList.add(brandDto);
                        }
                    }
                }
                classifyDto.setBrandList(brandDtoList);//给brandList赋值
                classifyDtoList.add(classifyDto);//把classifyDto添加到classifyDtoList集合
            }
            //将商品分类信息存储到redis中
            redisUtils.set(key,JSONObject.toJSONString(classifyDtoList));
        }else{

            classifyDtoList = JSONObject.parseArray(redisUtils.getValue(key),ClassifyDto.class);
        }
        return classifyDtoList;
    }
}
