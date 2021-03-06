package com.hospital.server.dao;

import com.hospital.server.pojo.PurchaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ClinicManagerDao {

    void checkApprove(@Param("id")String id);

    List<PurchaseInfo> searchApprove(@Param("staffId") String staffId);
}
