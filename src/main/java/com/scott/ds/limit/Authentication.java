package com.scott.ds.limit;

import com.scott.ds.utils.AESUtils;
import com.scott.ds.utils.Ognl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

/**
 * @ClassName :Authentication
 * @Description : 请求类鉴权操作
 * @Author :Mr.薛
 * @Data :2019/12/16 0016 下午 1:00
 * @Version :V1.0
 * @Status : 编写
 **/
@Component
public class Authentication {
    private static Log log = LogFactory.getLog(Authentication.class);
    private static final String secretKeyOfWxh = "e10adc3949ba59abbe56e057f20f883f";
    private static final String appidOfWxh = "xxx";
//    @Autowired
//    private MerchantInfoService merchantInfoService;
//    private static Authentication auth;
//
//    public void setServiceMer(MerchantInfoService merchantInfoService) {
//        this.merchantInfoService = merchantInfoService;
//    }
//
//    @PostConstruct
//    public void init() {
//        auth = this;
//        auth.merchantInfoService = this.merchantInfoService;
//    }

//    public static void main(String[] args)
//    {
//        //参数签名算法测试例子
//        HashMap<String, String> signMap = new HashMap<String, String>();
//        signMap.put("devid","BC5549D899ED");
//        signMap.put("userId","1");
//        signMap.put("type","worker");
//        signMap.put("name","中文测试");
//        System.out.println("得到签名sign1:"+getSign(signMap,secretKeyOfWxh));
//    }


    /**
     * 初级鉴权测试
     * header中的Authentication不为空即可
     * */
    public static Boolean AuthenticationSample(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Boolean flag= false;
        if(Ognl.isEmpty(request.getHeader("Authentication"))){
            authReturnMsg(response,"{\"code\":400,\"msg\":\"[Authentication]auth request is fail!\"}");
        }else{
            flag =  true;
        }
        return flag;
    }



    /**
     * 接口鉴权 - Header鉴权
     * 处理request域中的头部数据
     * true:通过  false：拦截
     * */
    public static Boolean Authentication(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Boolean flag= false;
//        考虑使用header
        Long timestamp = Long.parseLong(request.getHeader("Timestamp").trim());
        String mid = request.getHeader("Mid").trim();
        String authentication = request.getHeader("Authentication").trim();
//        获取商户号的秘钥 - 缓存
        String merchantScrect = "";
        if(Ognl.isEmpty(mid)){
            log.info("[Mid]: " + mid + "  [Timestamp]: " + timestamp + "  Authentication failure...");
            authReturnMsg(response,"{\"code\":400,\"msg\":\"[Authentication]Mid Non-existent!\"}");
            return flag;
        }else{
//            查询商户秘钥 - 缓存
            merchantScrect = "";
//            merchantScrect = auth.merchantInfoService .getMerchantScrectKeyByMerNo(mid);
            if(Ognl.isEmpty(merchantScrect)){
                log.info("[Mid]: " + mid + "  [Timestamp]: " + timestamp + "  Authentication failure...");
                authReturnMsg(response,"{\"code\":400,\"msg\":\"[Authentication]Merchant information error or merchant secret key not configured!\"}");
                return flag;
            }
        }
        // 当前时间的时间戳 前推1分钟
        Long currTimestamp = System.currentTimeMillis() - 60*60*1000L;
        // 在一分钟范围之外，访问已过期
        if (currTimestamp > timestamp) {
            log.info("Visit expired...[Mid]: " + mid + "  [Timestamp]: " + timestamp + "  Authentication failure...");
            authReturnMsg(response,"{\"code\":400,\"msg\":\"[Authentication]Visit expired!\"}");
            return flag;
        }
        String checkAuth = "Basic " + AESUtils.AESEncode(mid+timestamp,merchantScrect);
        if(Ognl.isEmpty(timestamp) ||
                 !authentication.equalsIgnoreCase(checkAuth) ||
                Ognl.isEmpty(authentication)){
            log.info("[Mid]: " + mid + "  [Timestamp]: " + timestamp + "  Authentication failure...");
            authReturnMsg(response,"{\"code\":400,\"msg\":\"[Authentication]Authentication request failed,Authentication request failed, please check the header parameter configuration!\"}");
            return flag;
        }else{
            return true;
        }

    }



        /**
         * 外部接口签名验证
         * @param request
         * @return
         */
    public static Boolean checkSign(HttpServletRequest request){
        Boolean flag= false;
        String appid = request.getParameter("appid");//appid
        if(!appid.equals(appidOfWxh)){
            log.info("appid错误");
        }
        String sign = request.getParameter("sign");//签名
        String timestamp = request.getParameter("timestamp");//时间戳
        //check时间戳的值是否在当前时间戳前后一小时以内
        String currTimestamp = String.valueOf(new Date().getTime() / 1000); // 当前时间的时间戳
        int currTimestampNum = Integer.parseInt(currTimestamp);
        int verifyTimestampNum = Integer.parseInt(timestamp); // 时间戳的数值
        // 在一小时范围之外，访问已过期
        if (Math.abs(verifyTimestampNum - currTimestampNum) > 600) {
            log.info("sigin已经过期");
        }
        //检查sigin是否过期
        Enumeration<?> pNames =  request.getParameterNames();
        Map<String, String> params = new HashMap<String, String>();
        while (pNames.hasMoreElements()) {
            String pName = (String) pNames.nextElement();
            if("sign".equals(pName)) continue;
            String pValue = (String)request.getParameter(pName);
            params.put(pName, pValue);
        }
        if(sign.equals(getSign(params, secretKeyOfWxh))){
            flag = true;
        }
        return flag;
    }


    public static String utf8Encoding(String value, String sourceCharsetName) {
        try {
            return new String(value.getBytes(sourceCharsetName), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }



    private static byte[] getMD5Digest(String data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse);
        }
        return bytes;
    }


    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
            //sign.append(hex.toLowerCase());
        }
        return sign.toString();
    }


    /**
     * 得到签名
     * @param params 参数集合不含secretkey
     * @param secret 验证接口的secretkey
     * @return
     */
    public static String getSign(Map<String, String> params,String secret)
    {
        String sign="";
        StringBuilder sb = new StringBuilder();
        //step1：先对请求参数排序
        Set<String> keyset=params.keySet();
        TreeSet<String> sortSet=new TreeSet<String>();
        sortSet.addAll(keyset);
        Iterator<String> it=sortSet.iterator();
        //step2：把参数的key value链接起来 secretkey放在最后面，得到要加密的字符串
        while(it.hasNext())
        {
            String key=it.next();
            String value=params.get(key);
            sb.append(key).append(value);
        }
        sb.append(secret);
        byte[] md5Digest;
        try {
            //得到Md5加密得到sign
            md5Digest = getMD5Digest(sb.toString());
            sign = byte2hex(md5Digest);
        } catch (IOException e) {
            log.error("生成签名错误",e);
        }
        return sign;
    }


    /*返回客户端数据*/
    private static void authReturnMsg(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
