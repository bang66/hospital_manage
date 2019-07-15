package com.hospital.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hospital.server.dao.DoctorDao;
import com.hospital.server.pojo.Illness;
import com.hospital.server.pojo.UserMsg;
import com.hospital.server.service.IDoctorService;
import com.hospital.server.util.Tools;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DoctorServiceImpl implements IDoctorService {

    private static final Map<String, Integer> priceMap = new HashMap();

    static {
        priceMap.put("001", 10);
        priceMap.put("002", 15);
        priceMap.put("003", 24);
        priceMap.put("004", 22);
        priceMap.put("005", 30);
        priceMap.put("006", 35);
        priceMap.put("007", 120);
    }

    @Resource
    private DoctorDao doctorDao;

    /**
     * 医生查看排号人数和名单
     * @return
     */
    @Override
    public ArrayList getRegistList(String staffId) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String reserveTime = dateFormat.format(date);
        return doctorDao.getRegistList(staffId,"2019-06-01");
    }

    /**
     * 医生呼叫下一个患者
     * @param staff_id
     * @param user_name
     */
    @Override
    public void nextPatient(String staff_id, String user_name) {
        String userId = doctorDao.getUserIdByName(user_name);
        log.info("userId : {}", userId);
        doctorDao.updateWait(userId, staff_id);

    }

    /**
     * 生成病历具体信息
     * @param staffId
     * @param currentPatient
     */
    @Override
    public void createIllness(String staffId, String currentPatient, String medical_id_num, String illness_desc, String treat_id_num) {
        UserMsg userMsg = doctorDao.getUserMsg(staffId,currentPatient);
        log.info("userMsg : {}",userMsg);
        String userId = userMsg.getUser_id();
        String registerId = userMsg.getRegister_id();
        String reserveTime = userMsg.getReserve_time();
        String illnessId = Tools.getTimeStamp();
        JSONArray jsonArray = JSON.parseArray(medical_id_num);
        int totalPrice = 0;
        for (int i = 0; i < jsonArray.size(); i++) {
            Map idNumMap = (Map) jsonArray.get(i);
            String id = (String) idNumMap.get("medical_id");
            int num = (int) idNumMap.get("medical_num");
            totalPrice += num * priceMap.get(id);
        }

        if (!StringUtils.isBlank(treat_id_num)) {
            JSONArray treatArray = JSON.parseArray(treat_id_num);
            Map idNumMap = (Map) treatArray.get(0);
            String id = (String) idNumMap.get("treat_id");
            int num = (int) idNumMap.get("treat_num");
            totalPrice += num * priceMap.get(id);
        }
        Illness illness = new Illness();
        illness.setIllness_id(illnessId);
        illness.setMedical_id_num(medical_id_num);
        illness.setPay_status("UNPAY");
        illness.setRegister_id(registerId);
        illness.setTotal_money(totalPrice);
        illness.setTreat_id_num(treat_id_num);
        illness.setUser_id(userId);
        illness.setIllness_desc(illness_desc);
        illness.setIllness_time(reserveTime);
        log.info("ill : {}", illness);
        doctorDao.insertIllness(illness);
    }
}
