package cn.est.service.impl;

import cn.est.dao.MalfunctionMapper;
import cn.est.pojo.Malfunction;
import cn.est.service.MalfunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MalfunctionServiceImpl implements MalfunctionService {

    @Resource
    private MalfunctionMapper malfunctionMapper;

    public Malfunction getMalfunctionById(String id) throws Exception {
        return malfunctionMapper.getMalfunctionById(id);
    }

    public List<Malfunction> getMalfunctionListByMap(Map<String, Object> param) throws Exception {
        return malfunctionMapper.getMalfunctionListByMap(param);
    }

    public Integer getMalfunctionCountByMap(Map<String, Object> param) throws Exception {
        return malfunctionMapper.getMalfunctionCountByMap(param);
    }

    public Integer qdtxAddMalfunction(Malfunction malfunction) throws Exception {
        //malfunction.setCreatedTime(new Date());
        return malfunctionMapper.insertMalfunction(malfunction);
    }

    public Integer qdtxModifyMalfunction(Malfunction malfunction) throws Exception {
        //malfunction.setUpdatedTime(new Date());
        return malfunctionMapper.updateMalfunction(malfunction);
    }

    public Integer qdtxDeleteMalfunctionById(String id) throws Exception {
        return malfunctionMapper.deleteMalfunctionById(id);
    }

    public Integer qdtxBatchDeleteMalfunction(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return malfunctionMapper.batchDeleteMalfunction(param);
    }


}
