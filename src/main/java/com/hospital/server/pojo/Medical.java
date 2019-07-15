package com.hospital.server.pojo;

import lombok.Data;

@Data
public class Medical {
    private String medical_id;//药品
    private String medical_name;//药名
    private String medical_desc;//药物描述
    private double medical_price;//药品价格
    private String produce_time;//生产日期
    private String save_time;//保质期
    private String current_num;//当前总量
    private String create_time;

    public Medical(String medical_id, String medical_name, String medical_desc,double medical_price,
                   String product_time, String save_time, String current_num) {
        this.medical_id = medical_id;
        this.medical_name = medical_name;
        this.current_num = medical_name;
        this.medical_desc = medical_desc;
        this.produce_time = product_time;
        this.save_time = save_time;
        this.current_num = current_num;
        this.medical_price = medical_price;


    }
}
