package cn.est.dao;

import cn.est.pojo.BrandClassifyRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandClassifyRelationMapper {

    public BrandClassifyRelation getBrandClassifyRelationById(@Param(value = "id") String id) throws Exception;

    public List<BrandClassifyRelation> getBrandClassifyRelationListByMap(Map<String, Object> param) throws Exception;

    public Integer getBrandClassifyRelationCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception;

    public Integer updateBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation) throws Exception;

    public Integer deleteBrandClassifyRelationById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteBrandClassifyRelation(Map<String, List<String>> params);

}
