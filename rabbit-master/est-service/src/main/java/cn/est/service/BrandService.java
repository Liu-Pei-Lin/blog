package cn.est.service;

import cn.est.pojo.Brand;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface BrandService {

    public Brand getBrandById(String id) throws Exception;

    public List<Brand> getBrandListByMap(Map<String, Object> param) throws Exception;

    public Integer getBrandCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddBrand(Brand brand) throws Exception;

    public Integer qdtxModifyBrand(Brand brand) throws Exception;

    public Integer qdtxDeleteBrandById(String id) throws Exception;

    public Integer qdtxBatchDeleteBrand(String ids) throws Exception;

}
