package cn.est.dao;

import cn.est.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {

    public Brand getBrandById(@Param(value = "id") String id) throws Exception;

    public List<Brand> getBrandListByMap(Map<String, Object> param) throws Exception;

    public Integer getBrandCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertBrand(Brand brand) throws Exception;

    public Integer updateBrand(Brand brand) throws Exception;

    public Integer deleteBrandById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteBrand(Map<String, List<String>> params);

}
