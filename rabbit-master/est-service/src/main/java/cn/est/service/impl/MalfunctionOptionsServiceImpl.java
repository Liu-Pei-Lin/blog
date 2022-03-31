package cn.est.service.impl;

import cn.est.dao.MalfunctionOptionsMapper;
import cn.est.pojo.MalfunctionOptions;
import cn.est.service.MalfunctionOptionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MalfunctionOptionsServiceImpl implements MalfunctionOptionsService {

    @Resource
    private MalfunctionOptionsMapper malfunctionOptionsMapper;

    public MalfunctionOptions getMalfunctionOptionsById(String id) throws Exception {
        return malfunctionOptionsMapper.getMalfunctionOptionsById(id);
    }

    public List<MalfunctionOptions> getMalfunctionOptionsListByMap(Map<String, Object> param) throws Exception {
        return malfunctionOptionsMapper.getMalfunctionOptionsListByMap(param);
    }

    public Integer getMalfunctionOptionsCountByMap(Map<String, Object> param) throws Exception {
        return malfunctionOptionsMapper.getMalfunctionOptionsCountByMap(param);
    }

    public Integer qdtxAddMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception {
        //malfunctionOptions.setCreatedTime(new Date());
        return malfunctionOptionsMapper.insertMalfunctionOptions(malfunctionOptions);
    }

    public Integer qdtxModifyMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception {
        //malfunctionOptions.setUpdatedTime(new Date());
        return malfunctionOptionsMapper.updateMalfunctionOptions(malfunctionOptions);
    }

    public Integer qdtxDeleteMalfunctionOptionsById(String id) throws Exception {
        return malfunctionOptionsMapper.deleteMalfunctionOptionsById(id);
    }

    public Integer qdtxBatchDeleteMalfunctionOptions(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return malfunctionOptionsMapper.batchDeleteMalfunctionOptions(param);
    }


}
