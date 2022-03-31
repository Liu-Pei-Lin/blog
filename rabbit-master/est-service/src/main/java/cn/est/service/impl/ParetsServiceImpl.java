package cn.est.service.impl;

import cn.est.dao.ParetsMapper;
import cn.est.pojo.Parets;
import cn.est.service.ParetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ParetsServiceImpl implements ParetsService {

    @Resource
    private ParetsMapper paretsMapper;

    public Parets getParetsById(String id) throws Exception {
        return paretsMapper.getParetsById(id);
    }

    public List<Parets> getParetsListByMap(Map<String, Object> param) throws Exception {
        return paretsMapper.getParetsListByMap(param);
    }

    public Integer getParetsCountByMap(Map<String, Object> param) throws Exception {
        return paretsMapper.getParetsCountByMap(param);
    }

    public Integer qdtxAddParets(Parets parets) throws Exception {
        //parets.setCreatedTime(new Date());
        return paretsMapper.insertParets(parets);
    }

    public Integer qdtxModifyParets(Parets parets) throws Exception {
        //parets.setUpdatedTime(new Date());
        return paretsMapper.updateParets(parets);
    }

    public Integer qdtxDeleteParetsById(String id) throws Exception {
        return paretsMapper.deleteParetsById(id);
    }

    public Integer qdtxBatchDeleteParets(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return paretsMapper.batchDeleteParets(param);
    }


}
