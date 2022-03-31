package com.${package}.service;
import com.${package}.bean.${table.className};
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.dy.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ${table.className}Service {

public ${table.className} get${table.className}ById(Long id);

public List<${table.className}>    get${table.className}ListByMap(Map
<String,Object> param);

public Integer get${table.className}CountByMap(Map
<String,Object> param);

public Integer qdtxAdd${table.className}(${table.className} ${lowerClassName});

public Integer qdtxModify${table.className}(${table.className} ${lowerClassName});

public Integer qdtxDelete${table.className}ById(Long id);

public Integer qdtxBatchDelete${table.className}(String ids);

public Page<${table.className}> query${table.className}PageByMap(Map
<String,Object> param,Integer pageNo,Integer pageSize);

}
