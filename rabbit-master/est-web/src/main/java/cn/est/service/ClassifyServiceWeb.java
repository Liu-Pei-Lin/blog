package cn.est.service;

import cn.est.dto.ClassifyDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassifyServiceWeb {

    public List<ClassifyDto> classifyTree() throws Exception;
}
