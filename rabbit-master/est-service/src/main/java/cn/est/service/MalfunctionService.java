package cn.est.service;

import cn.est.pojo.Malfunction;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface MalfunctionService {

    public Malfunction getMalfunctionById(String id) throws Exception;

    public List<Malfunction> getMalfunctionListByMap(Map<String, Object> param) throws Exception;

    public Integer getMalfunctionCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddMalfunction(Malfunction malfunction) throws Exception;

    public Integer qdtxModifyMalfunction(Malfunction malfunction) throws Exception;

    public Integer qdtxDeleteMalfunctionById(String id) throws Exception;

    public Integer qdtxBatchDeleteMalfunction(String ids) throws Exception;

}
