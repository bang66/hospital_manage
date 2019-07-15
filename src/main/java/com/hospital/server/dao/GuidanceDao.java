package com.hospital.server.dao;

import com.hospital.server.pojo.OrderUser;
import com.hospital.server.pojo.RegistInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GuidanceDao {

    List<OrderUser> getOrderUserMsg(@Param("user_id") String user_id);

    int inserRegistInfo(@Param("registInfo") RegistInfo registInfo);

}
