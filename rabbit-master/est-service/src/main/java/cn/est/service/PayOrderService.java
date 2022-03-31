package cn.est.service;

import cn.est.pojo.PayOrder;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface PayOrderService {

    public PayOrder getPayOrderById(String id) throws Exception;

    public List<PayOrder> getPayOrderListByMap(Map<String, Object> param) throws Exception;

    public Integer getPayOrderCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddPayOrder(PayOrder payOrder) throws Exception;

    public Integer qdtxModifyPayOrder(PayOrder payOrder) throws Exception;

    public Integer qdtxDeletePayOrderById(String id) throws Exception;

    public Integer qdtxBatchDeletePayOrder(String ids) throws Exception;

}
