package cn.est.service.impl;

import cn.est.dao.PayOrderMapper;
import cn.est.pojo.PayOrder;
import cn.est.service.PayOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Resource
    private PayOrderMapper payOrderMapper;

    public PayOrder getPayOrderById(String id) throws Exception {
        return payOrderMapper.getPayOrderById(id);
    }

    public List<PayOrder> getPayOrderListByMap(Map<String, Object> param) throws Exception {
        return payOrderMapper.getPayOrderListByMap(param);
    }

    public Integer getPayOrderCountByMap(Map<String, Object> param) throws Exception {
        return payOrderMapper.getPayOrderCountByMap(param);
    }

    public Integer qdtxAddPayOrder(PayOrder payOrder) throws Exception {
        //payOrder.setCreatedTime(new Date());
        return payOrderMapper.insertPayOrder(payOrder);
    }

    public Integer qdtxModifyPayOrder(PayOrder payOrder) throws Exception {
        //payOrder.setUpdatedTime(new Date());
        return payOrderMapper.updatePayOrder(payOrder);
    }

    public Integer qdtxDeletePayOrderById(String id) throws Exception {
        return payOrderMapper.deletePayOrderById(id);
    }

    public Integer qdtxBatchDeletePayOrder(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return payOrderMapper.batchDeletePayOrder(param);
    }


}
