package com.hospital.server.dao;


import com.hospital.server.pojo.ID_Num;
import com.hospital.server.pojo.Illness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IllnessDao {
    Illness selectIllness(@Param("id") String id);
    void updateNum(ID_Num id_num);
}
