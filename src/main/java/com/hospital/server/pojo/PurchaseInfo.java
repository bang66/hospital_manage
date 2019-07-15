package com.hospital.server.pojo;

import lombok.Data;

@Data
public class PurchaseInfo {

    private int id;

    //药品id
    private String medical_id;

    //药品数量
    private String medical_num;

    //审批状态
    private String approve_status;

    //职员id
    private String staff_id;


    private String create_time;

    public PurchaseInfo() {

    }

}
