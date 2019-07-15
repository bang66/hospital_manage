package com.hospital.server.service;

import com.hospital.server.pojo.PurchaseInfo;

import java.util.List;

public interface IHospitalManagerService {

    void insertApproveMedical(String staffId, String medicalList);

    List<PurchaseInfo> getApproveList(String staffId);
}
