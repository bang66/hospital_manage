package com.hospital.server.pojo;

import lombok.Data;


@Data
public class RegistInfo {

    private int id;

    private String register_id;

    private String reserve_id;

    private String user_id;

    private String treat_status;

    private String staff_id;

    private String create_time;

}
