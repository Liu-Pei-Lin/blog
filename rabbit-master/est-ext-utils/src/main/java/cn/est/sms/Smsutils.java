package cn.est.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Smsutils {
    @Autowired
    private AliSmsConfig aliSmsConfig;

    public String sendSms(String phone, String code){
        DefaultProfile profile = DefaultProfile.getProfile(aliSmsConfig.getRegionId(),
                aliSmsConfig.getAccessKeyId(), aliSmsConfig.getAccessKeySecret());//秘钥
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(aliSmsConfig.getDomain());//产品的域名
        request.setSysVersion(aliSmsConfig.getVersion());
        request.setSysAction("SendSms");//操作类型:发送短信
        request.putQueryParameter("RegionId", aliSmsConfig.getRegionId());   //区域
        request.putQueryParameter("PhoneNumbers", phone);//手机号
        request.putQueryParameter("SignName", aliSmsConfig.getSignName());   //签名
        request.putQueryParameter("TemplateCode", aliSmsConfig.getTemplateCode());//模板的编号
        request.putQueryParameter("TemplateParam","{\"code\":\""+code+"\"}");//参数
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject jsObject = JSONObject.parseObject(response.getData());
            if(jsObject.get("Message").equals("OK") && jsObject.get("Code").equals("OK")) {
                return "OK";
            }
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
