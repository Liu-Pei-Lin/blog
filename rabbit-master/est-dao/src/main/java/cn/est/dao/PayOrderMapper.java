package cn.est.dao;

import cn.est.pojo.PayOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayOrderMapper {

    public PayOrder getPayOrderById(@Param(value = "id") String id) throws Exception;

    public List<PayOrder> getPayOrderListByMap(Map<String, Object> param) throws Exception;

    public Integer getPayOrderCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertPayOrder(PayOrder payOrder) throws Exception;

    public Integer updatePayOrder(PayOrder payOrder) throws Exception;

    public Integer deletePayOrderById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeletePayOrder(Map<String, List<String>> params);

}
