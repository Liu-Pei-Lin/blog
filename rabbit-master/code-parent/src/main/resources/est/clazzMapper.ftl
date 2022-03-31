package cn.${package}.mapper;
import cn.${package}.model.po.${table.className};
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ${table.className}Mapper {

public ${table.className} get${table.className}ById(@Param(value = "id") Long id);

public List<${table.className}>    get${table.className}ListByMap(Map
<String,Object> param);

public Integer get${table.className}CountByMap(Map
<String,Object> param);

public Integer insert${table.className}(${table.className} ${lowerClassName});

public Integer update${table.className}(${table.className} ${lowerClassName});

public Integer delete${table.className}ById(@Param(value = "id") Long id);

public Integer batchDelete${table.className}(Map
<String,List
<String>> params);

    }
