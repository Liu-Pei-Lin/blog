package cn.est.dao;

import cn.est.pojo.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    public Store getStoreById(@Param(value = "id") String id) throws Exception;

    public List<Store> getStoreListByMap(Map<String, Object> param) throws Exception;

    public Integer getStoreCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertStore(Store store) throws Exception;

    public Integer updateStore(Store store) throws Exception;

    public Integer deleteStoreById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteStore(Map<String, List<String>> params);

}
