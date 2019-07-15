package com.hospital.server.service;

import com.hospital.server.pojo.PurchaseInfo;

import java.util.List;

public interface IClinicManagerService {

    void updateApprove(String staffId);

    List<PurchaseInfo> getApproveMsg(String staffId);
}
