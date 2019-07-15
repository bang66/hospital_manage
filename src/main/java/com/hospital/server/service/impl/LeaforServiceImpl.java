package com.hospital.server.service.impl;


import com.hospital.server.dao.IllnessDao;
import com.hospital.server.pojo.ID_Num;
import com.hospital.server.pojo.Illness;
import com.hospital.server.service.LeaforService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class LeaforServiceImpl implements LeaforService {

    @Resource
    private IllnessDao illnessDao;

    /**
     * 输液室医师（负责给用户提供输液药品，将仓库的药品数量减去）
     *
     * @param
     */


    @Override
    public void leafMessage(String id, String type) {
        ID_Num id_Num = new ID_Num();
        //用id查询病例信息用id查询病例信息
        Illness illnesses = illnessDao.selectIllness(id);
        log.info("illness{}", illnesses);
        if ("1".equals(type)) {//药房医师
            String medicalIDN = illnesses.getMedical_id_num();
            String id_num[] = medicalIDN.split(",");
            System.out.println(id_num[0]);
            for (int i = 0; i < id_num.length; i++) {
                String myidNum[] = id_num[i].split(":");
                id_Num.setId(Integer.parseInt(myidNum[0]));
                id_Num.setNum(Integer.parseInt(myidNum[1]));

                illnessDao.updateNum(id_Num);
                log.info("更新一条数据到数据库。。。。。");

            }


        } else {//输液室医师
            String treat = illnesses.getTreat_id_num();

            String id_num[] = treat.split(",");
            System.out.println(id_num[0]);
            for (int i = 0; i < id_num.length; i++) {
                String myidNum[] = id_num[i].split(":");
                id_Num.setId(Integer.parseInt(myidNum[0]));
                id_Num.setNum(Integer.parseInt(myidNum[1]));
                illnessDao.updateNum(id_Num);
                log.info("更新一条数据到数据库。。。。。");
            }

        }
    }
}