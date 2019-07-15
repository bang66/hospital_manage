package com.hospital.server.controller;


import com.hospital.server.service.IHospitalManagerService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hospitalManager")
public class HospitalManagerController {

    @Autowired
    private IHospitalManagerService hospitalManagerService;

    @PostMapping(value = "/approve")
    public ResponseV2 insertApprove(@RequestParam Map<String,String> para ,HttpServletRequest request){
        log.info("req url: {}",request.getRequestURL());
        String staffId = para.get("staff_id");
        String medicalList = para.get("medicallist");
        log.info("req field: {}", staffId, medicalList);
        hospitalManagerService.insertApproveMedical(staffId, medicalList);
        return ResponseHelper.create();
    }

    @GetMapping(value = "/searchApprove")
    public ResponseV2 getSearchApprove(HttpServletRequest request) {
        log.info("req url: {}",request.getRequestURL());
        String staffId = request.getParameter("staffId");
        log.info("req field: {}", staffId);
        return ResponseHelper.create(hospitalManagerService.getApproveList(staffId));
    }

}
