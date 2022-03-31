package cn.est.service;

import cn.est.pojo.MalfunctionOptions;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface MalfunctionOptionsService {

    public MalfunctionOptions getMalfunctionOptionsById(String id) throws Exception;

    public List<MalfunctionOptions> getMalfunctionOptionsListByMap(Map<String, Object> param) throws Exception;

    public Integer getMalfunctionOptionsCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception;

    public Integer qdtxModifyMalfunctionOptions(MalfunctionOptions malfunctionOptions) throws Exception;

    public Integer qdtxDeleteMalfunctionOptionsById(String id) throws Exception;

    public Integer qdtxBatchDeleteMalfunctionOptions(String ids) throws Exception;

}
