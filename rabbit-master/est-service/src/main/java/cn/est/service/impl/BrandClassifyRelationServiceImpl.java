package cn.est.service.impl;

import cn.est.dao.BrandClassifyRelationMapper;
import cn.est.pojo.BrandClassifyRelation;
import cn.est.service.BrandClassifyRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BrandClassifyRelationServiceImpl implements BrandClassifyRelationService {

    @Resource
    private BrandClassifyRelationMapper brandClassifyRelationMapper;

    public BrandClassifyRelation getBrandClassifyRelationById(String id) throws Exception {
        return brandClassifyRelationMapper.getBrandClassifyRelationById(id);
    }

    public List<BrandClassifyRelation> getBrandClassifyRelationListByMap(Map<String, Object> param) throws Exception {
        return brandClassifyRelationMapper.getBrandClassifyRelationListByMap(param);
    }

    public Integer getBrandClassifyRelationCountByMap(Map<String, Object> param) throws Exception {
        return brandClassifyRelationMapper.getBrandClassifyRelationCountByMap(param);
    }

    public Integer qdtxAddBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception {
        //brandClassifyRelation.setCreatedTime(new Date());
        return brandClassifyRelationMapper.insertBrandClassifyRelation(brandClassifyRelation);
    }

    public Integer qdtxModifyBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception {
        //brandClassifyRelation.setUpdatedTime(new Date());
        return brandClassifyRelationMapper.updateBrandClassifyRelation(brandClassifyRelation);
    }

    public Integer qdtxDeleteBrandClassifyRelationById(String id) throws Exception {
        return brandClassifyRelationMapper.deleteBrandClassifyRelationById(id);
    }

    public Integer qdtxBatchDeleteBrandClassifyRelation(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return brandClassifyRelationMapper.batchDeleteBrandClassifyRelation(param);
    }


}
