package com.hospital.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hospital.server.dao.ClinicManagerDao;
import com.hospital.server.dao.HospitalManagerDao;
import com.hospital.server.pojo.MedicalNumId;
import com.hospital.server.pojo.PurchaseInfo;
import com.hospital.server.service.IClinicManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClinicManagerServiceImpl implements IClinicManagerService {

    @Resource
    private ClinicManagerDao clinicManagerDao;

    /**
     * 诊所管理员审批申请
     * @param id
     */
    @Override
    public void updateApprove(String id) {
        clinicManagerDao.checkApprove(id);
    }

    /**
     * 诊所管理员查看购药申请
     * @param staffId
     * @return
     */
    @Override
    public List<PurchaseInfo> getApproveMsg(String staffId) {
        return clinicManagerDao.searchApprove(staffId);
    }
}
