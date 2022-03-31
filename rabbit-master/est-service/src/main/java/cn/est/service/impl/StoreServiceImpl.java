package cn.est.service.impl;

import cn.est.dao.StoreMapper;
import cn.est.pojo.Store;
import cn.est.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreMapper storeMapper;

    public Store getStoreById(String id) throws Exception {
        return storeMapper.getStoreById(id);
    }

    public List<Store> getStoreListByMap(Map<String, Object> param) throws Exception {
        return storeMapper.getStoreListByMap(param);
    }

    public Integer getStoreCountByMap(Map<String, Object> param) throws Exception {
        return storeMapper.getStoreCountByMap(param);
    }

    public Integer qdtxAddStore(Store store) throws Exception {
        //store.setCreatedTime(new Date());
        return storeMapper.insertStore(store);
    }

    public Integer qdtxModifyStore(Store store) throws Exception {
        //store.setUpdatedTime(new Date());
        return storeMapper.updateStore(store);
    }

    public Integer qdtxDeleteStoreById(String id) throws Exception {
        return storeMapper.deleteStoreById(id);
    }

    public Integer qdtxBatchDeleteStore(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return storeMapper.batchDeleteStore(param);
    }


}
