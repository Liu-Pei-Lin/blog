package cn.est.service;

import cn.est.pojo.Store;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface StoreService {

    public Store getStoreById(String id) throws Exception;

    public List<Store> getStoreListByMap(Map<String, Object> param) throws Exception;

    public Integer getStoreCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddStore(Store store) throws Exception;

    public Integer qdtxModifyStore(Store store) throws Exception;

    public Integer qdtxDeleteStoreById(String id) throws Exception;

    public Integer qdtxBatchDeleteStore(String ids) throws Exception;

}
