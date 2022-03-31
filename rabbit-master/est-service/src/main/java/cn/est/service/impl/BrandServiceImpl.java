package cn.est.service.impl;

import cn.est.dao.BrandMapper;
import cn.est.pojo.Brand;
import cn.est.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    public Brand getBrandById(String id) throws Exception {
        return brandMapper.getBrandById(id);
    }

    public List<Brand> getBrandListByMap(Map<String, Object> param) throws Exception {
        return brandMapper.getBrandListByMap(param);
    }

    public Integer getBrandCountByMap(Map<String, Object> param) throws Exception {
        return brandMapper.getBrandCountByMap(param);
    }

    public Integer qdtxAddBrand(Brand brand) throws Exception {
        //brand.setCreatedTime(new Date());
        return brandMapper.insertBrand(brand);
    }

    public Integer qdtxModifyBrand(Brand brand) throws Exception {
        //brand.setUpdatedTime(new Date());
        return brandMapper.updateBrand(brand);
    }

    public Integer qdtxDeleteBrandById(String id) throws Exception {
        return brandMapper.deleteBrandById(id);
    }

    public Integer qdtxBatchDeleteBrand(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return brandMapper.batchDeleteBrand(param);
    }


}
