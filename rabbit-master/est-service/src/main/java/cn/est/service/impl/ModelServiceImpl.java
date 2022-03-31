package cn.est.service.impl;

import cn.est.dao.ModelMapper;
import cn.est.pojo.Model;
import cn.est.service.ModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelMapper modelMapper;

    public Model getModelById(String id) throws Exception {
        return modelMapper.getModelById(id);
    }

    public List<Model> getModelListByMap(Map<String, Object> param) throws Exception {
        return modelMapper.getModelListByMap(param);
    }

    public Integer getModelCountByMap(Map<String, Object> param) throws Exception {
        return modelMapper.getModelCountByMap(param);
    }

    public Integer qdtxAddModel(Model model) throws Exception {
        //model.setCreatedTime(new Date());
        return modelMapper.insertModel(model);
    }

    public Integer qdtxModifyModel(Model model) throws Exception {
        //model.setUpdatedTime(new Date());
        return modelMapper.updateModel(model);
    }

    public Integer qdtxDeleteModelById(String id) throws Exception {
        return modelMapper.deleteModelById(id);
    }

    public Integer qdtxBatchDeleteModel(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return modelMapper.batchDeleteModel(param);
    }


}
