package cn.est.service;

import cn.est.pojo.Parets;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface ParetsService {

    public Parets getParetsById(String id) throws Exception;

    public List<Parets> getParetsListByMap(Map<String, Object> param) throws Exception;

    public Integer getParetsCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddParets(Parets parets) throws Exception;

    public Integer qdtxModifyParets(Parets parets) throws Exception;

    public Integer qdtxDeleteParetsById(String id) throws Exception;

    public Integer qdtxBatchDeleteParets(String ids) throws Exception;

}
