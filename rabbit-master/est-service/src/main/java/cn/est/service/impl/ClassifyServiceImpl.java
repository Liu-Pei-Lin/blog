package cn.est.service.impl;

import cn.est.dao.ClassifyMapper;
import cn.est.pojo.Classify;
import cn.est.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyMapper classifyMapper;

    public Classify getClassifyById(String id) throws Exception {
        return classifyMapper.getClassifyById(id);
    }

    public List<Classify> getClassifyListByMap(Map<String, Object> param) throws Exception {
        return classifyMapper.getClassifyListByMap(param);
    }

    public Integer getClassifyCountByMap(Map<String, Object> param) throws Exception {
        return classifyMapper.getClassifyCountByMap(param);
    }

    public Integer qdtxAddClassify(Classify classify) throws Exception {
        //classify.setCreatedTime(new Date());
        return classifyMapper.insertClassify(classify);
    }

    public Integer qdtxModifyClassify(Classify classify) throws Exception {
        //classify.setUpdatedTime(new Date());
        return classifyMapper.updateClassify(classify);
    }

    public Integer qdtxDeleteClassifyById(String id) throws Exception {
        return classifyMapper.deleteClassifyById(id);
    }

    public Integer qdtxBatchDeleteClassify(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return classifyMapper.batchDeleteClassify(param);
    }


}
