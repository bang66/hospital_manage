package com.hospital.server.pojo;


import lombok.Data;

@Data
public class Illness {
    private Integer id;//标识id
    private String illness_id;//病例ID
    private String register_id;//挂号ID
    private String user_id;//患者ID
    private String illness_desc; //病症描述
    private String medical_id_num;//药物ID及种类
    private double total_money;//价格
    private String pay_status;//缴费状态
    private String illness_time;//病例生成日期
    private String treat_id_num;//注射器及数量
    private String create_time;

}
