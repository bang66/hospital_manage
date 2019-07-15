package com.hospital.server.pojo;

import lombok.Data;

@Data
public class Staff {//Excal文件导入
    private String staff_id;//工号
    private String staff_name;//姓名
    private String staff_sex;//性别
    private String staff_bir;//出生日期
    private String staff_tel;//电话
    private String staff_img;//照片
    private String staff_pos;//职称
    private String staff_entry;//入职时间等
    private String create_time;

    public Staff(String staff_id, String staff_name, String staff_sex, String staff_bir, String staff_tel, String staff_img, String staff_pos, String staff_entry) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_sex = staff_sex;
        this.staff_bir = staff_bir;
        this.staff_tel = staff_tel;
        this.staff_img = staff_img;
        this.staff_entry = staff_entry;
        this.staff_pos = staff_pos;

    }
}
