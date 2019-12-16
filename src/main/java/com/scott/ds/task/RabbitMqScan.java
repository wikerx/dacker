package com.scott.ds.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName :RabbitMqScan
 * @Description :
 * @Author :Mr.薛
 * @Data :2019/12/16 0016 下午 5:50
 * @Version :V1.0
 * @Status : 编写
 **/
@Component
public class RabbitMqScan {
    private static Log log = LogFactory.getLog(RabbitMqScan.class);

//    每分钟一次
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void scheduledXpress(){
        log.info("定时增加MQ队列中的内容");
    }
}
