package com.hospital.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hospital.server.dao.HospitalManagerDao;
import com.hospital.server.pojo.PurchaseInfo;
import com.hospital.server.pojo.MedicalNumId;
import com.hospital.server.service.IHospitalManagerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class HospitalManagerServiceImpl implements IHospitalManagerService {

    @Resource
    private HospitalManagerDao hospitalManagerDao;

    /**
     * 药房管理员申请采购药品
     * @param staffId
     * @param medicalList
     */
    @Override
    public void insertApproveMedical(String staffId, String medicalList) {
        JSONArray jsonArray = JSONArray.parseArray(medicalList);
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            MedicalNumId medicalNumId = JSON.toJavaObject(jsonObject, MedicalNumId.class);
            String medicalId = medicalNumId.getMedical_id();
            String medicalNum = medicalNumId.getMedical_num();
            PurchaseInfo purchaseInfo = new PurchaseInfo();
            purchaseInfo.setMedical_id(medicalId);
            purchaseInfo.setMedical_num(medicalNum);
            purchaseInfo.setApprove_status("FALSE");
            purchaseInfo.setStaff_id(staffId);
            hospitalManagerDao.insertApprove(purchaseInfo);
        }
    }

    /**
     * 药房管理员查看审批结果
     * @param staffId
     * @return
     */
    @Override
    public List<PurchaseInfo> getApproveList(String staffId) {
        return hospitalManagerDao.searchApprove(staffId);
    }
}
