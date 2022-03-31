package cn.est.controller;

import cn.est.oss.OssUtils;
import cn.est.resp.Result;
import cn.est.resp.ResultUtils;
import cn.est.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private OssUtils ossUtils;

    @RequestMapping("/upload")
    public Result upload(MultipartFile pic ) throws Exception {//MultipartFile接受前端映射过来的文件对象
        File toFile = null;
        if (pic.equals("") || pic.getSize() <= 0) {
            pic = null;
        } else {
            InputStream ins = null;
            ins = pic.getInputStream();
            toFile = new File(pic.getOriginalFilename());
            FileUtils.inputStreamToFile(ins, toFile);
            ins.close();
        }
        String result= ossUtils.uploadByStream(toFile,"brand-icons/"+pic.getOriginalFilename());
        return ResultUtils.returnSuccess(result);
    }

    //下载文件
    public Result download(){
        return null;
    }

    //删除文件
    @RequestMapping("/deleteFile")
    public Result deleteFile(String fileName){
        System.out.println(fileName);
        //调用删除的方法
        ossUtils.deleteFile("brand-icons/"+fileName);

        return ResultUtils.returnSuccess("删除成功");
    }
}
