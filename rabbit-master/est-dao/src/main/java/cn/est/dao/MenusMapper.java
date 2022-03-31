package cn.est.dao;

import cn.est.pojo.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenusMapper {

    public Menus getMenusById(@Param(value = "id") String id) throws Exception;

    public List<Menus> getMenusListByMap(Map<String, Object> param) throws Exception;

    public Integer getMenusCountByMap(Map<String, Object> param) throws Exception;

    public Integer insertMenus(Menus menus) throws Exception;

    public Integer updateMenus(Menus menus) throws Exception;

    public Integer deleteMenusById(@Param(value = "id") String id) throws Exception;

    public Integer batchDeleteMenus(Map<String, List<String>> params);

}
