package com.hospital.server.pojo;

import lombok.Data;

/**
 * 科室
 */
@Data
public class Dep_info {

    private String cli_id;//诊所ID
    private String dep_id;//dep_id
    private String dep_name;//科室名称;
    private String dep_master;//管理人员
    private String create_time;

    public Dep_info(String cli_id, String dep_id, String dep_name, String dep_master) {
        this.cli_id = cli_id;
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_master = dep_master;
    }
}
