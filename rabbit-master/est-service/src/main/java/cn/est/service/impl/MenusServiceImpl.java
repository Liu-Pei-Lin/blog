package cn.est.service.impl;

import cn.est.dao.MenusMapper;
import cn.est.pojo.Menus;
import cn.est.service.MenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MenusServiceImpl implements MenusService {

    @Resource
    private MenusMapper menusMapper;

    public Menus getMenusById(String id) throws Exception {
        return menusMapper.getMenusById(id);
    }

    public List<Menus> getMenusListByMap(Map<String, Object> param) throws Exception {
        return menusMapper.getMenusListByMap(param);
    }

    public Integer getMenusCountByMap(Map<String, Object> param) throws Exception {
        return menusMapper.getMenusCountByMap(param);
    }

    public Integer qdtxAddMenus(Menus menus) throws Exception {
        //menus.setCreatedTime(new Date());
        return menusMapper.insertMenus(menus);
    }

    public Integer qdtxModifyMenus(Menus menus) throws Exception {
        //menus.setUpdatedTime(new Date());
        return menusMapper.updateMenus(menus);
    }

    public Integer qdtxDeleteMenusById(String id) throws Exception {
        return menusMapper.deleteMenusById(id);
    }

    public Integer qdtxBatchDeleteMenus(String ids) throws Exception {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return menusMapper.batchDeleteMenus(param);
    }


}
