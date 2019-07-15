package com.hospital.server.dao;

import com.hospital.server.pojo.Dep_info;
import com.hospital.server.pojo.Medical;
import com.hospital.server.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface Excal2DB {
    void excalStaff2DB(Staff staff);
    void excalMedical2DB(Medical medical);
    void excalDep2DB(Dep_info dep_info);
}
