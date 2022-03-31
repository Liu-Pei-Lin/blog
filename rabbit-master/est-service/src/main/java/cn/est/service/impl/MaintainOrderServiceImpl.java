package cn.est.service.impl;

import cn.est.dao.MaintainOrderMapper;
import cn.est.pojo.MaintainOrder;
import cn.est.service.MaintainOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MaintainOrderServiceImpl implements MaintainOrderService {

    @Resource
    private MaintainOrderMapper maintainOrderMapper;

    public MaintainOrder getMaintainOrderById(String id) throws Exception {
        return maintainOrderMapper.getMaintainOrderById(id);
    }

    public List<MaintainOrder> getMaintainOrderListByMap(Map<String, Object> param) throws Exception {
        return maintainOrderMapper.getMaintainOrderListByMap(param);
    }

    public Integer getMaintainOrderCountByMap(Map<String, Object> param) throws Exception {
        return maintainOrderMapper.getMaintainOrderCountByMap(param);
    }

    public Integer qdtxAddMaintainOrder(MaintainOrder maintainOrder) throws Exception {
        //maintainOrder.setCreatedTime(new Date());
        return maintainOrderMapper.insertMaintainOrder(maintainOrder);
    }

    public Integer qdtxModifyMaintainOrder(MaintainOrder maintainOrder) throws Exception {
        //maintainOrder.setUpdatedTime(new Date());
        return maintainOrderMapper.updateMaintainOrder(maintainOrder);
    }

    public Integer qdtxDeleteMaintainOrderById(String id) throws Exception {
        return maintainOrderMapper.deleteMaintainOrderById(id);
    }

    public Integer qdtxBatchDeleteMaintainOrder(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return maintainOrderMapper.batchDeleteMaintainOrder(param);
    }


}
