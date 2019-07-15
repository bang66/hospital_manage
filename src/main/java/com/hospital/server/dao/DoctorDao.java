package com.hospital.server.dao;


import com.hospital.server.pojo.Illness;
import com.hospital.server.pojo.UserMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface DoctorDao {

    ArrayList<String> getRegistList(@Param("staff_id") String staff_id, @Param("reserve_time") String reserve_time);

    UserMsg getUserMsg(@Param("staff_id")String staff_id, @Param("user_name")String user_name);

    String getUserIdByName(@Param("user_name") String user_name);

    void updateWait(@Param("user_id")String user_id, @Param("staff_id")String staff_id);

    void insertIllness(Illness illness);
}
