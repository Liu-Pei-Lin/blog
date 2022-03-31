package cn.est.service;

import cn.est.pojo.Menus;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shang-pc on 2015/11/7.
 */
public interface MenusService {

    public Menus getMenusById(String id) throws Exception;

    public List<Menus> getMenusListByMap(Map<String, Object> param) throws Exception;

    public Integer getMenusCountByMap(Map<String, Object> param) throws Exception;

    public Integer qdtxAddMenus(Menus menus) throws Exception;

    public Integer qdtxModifyMenus(Menus menus) throws Exception;

    public Integer qdtxDeleteMenusById(String id) throws Exception;

    public Integer qdtxBatchDeleteMenus(String ids) throws Exception;

}
