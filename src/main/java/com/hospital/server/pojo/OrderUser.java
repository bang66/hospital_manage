package com.hospital.server.pojo;

import lombok.Builder;
import lombok.Data;


@Data
public class OrderUser {

    private int id;

    //预约号
    private String reserve_id;

    //用户id
    private String user_id;

    //科室id
    private String dep_id;

    //病情
    private String illness_content;

    //预约医生
    private String staff_id;

    //预约时间段
    private String reserve_time;

    //预约状态
    private String reserve_status;

    //数据插入时间
    private String create_time;

}
