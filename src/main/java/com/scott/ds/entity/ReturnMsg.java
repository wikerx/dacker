package com.scott.ds.entity;

/**
 * @ClassName :ReturnMsg
 * @Description :限流测试的返回结果
 * @Author :Mr.薛
 * @Data :2019/11/15  10:32
 * @Version :V1.0
 * @Status : 编写
 **/
public class ReturnMsg {
//    返回结果
    private String respCode;
//    返回原因
    private String respMsg;
//    订单号
    private String orderNo;

//    get  set

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
