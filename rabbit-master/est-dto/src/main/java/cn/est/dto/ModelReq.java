package cn.est.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ModelReq implements Serializable {
    @ApiModelProperty("商品型号id")
    private Long id;
    @ApiModelProperty("商品型号名称")
    private String modelName;
    @ApiModelProperty("封面图片")
    private String faceImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }
}
