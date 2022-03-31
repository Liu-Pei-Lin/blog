package cn.est.service;

import cn.est.pojo.BrandClassifyRelation;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface BrandClassifyRelationService {

    public BrandClassifyRelation getBrandClassifyRelationById(String id) throws Exception;

    public List<BrandClassifyRelation> getBrandClassifyRelationListByMap(Map<String, Object> param) throws Exception;

    public Integer getBrandClassifyRelationCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception;

    public Integer qdtxModifyBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception;

    public Integer qdtxDeleteBrandClassifyRelationById(String id) throws Exception;

    public Integer qdtxBatchDeleteBrandClassifyRelation(String ids) throws Exception;

}
