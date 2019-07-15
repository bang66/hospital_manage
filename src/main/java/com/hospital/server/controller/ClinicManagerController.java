package com.hospital.server.controller;


import com.hospital.server.service.IClinicManagerService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/clinicManager")
public class ClinicManagerController {

    @Autowired
    private IClinicManagerService clinicManagerService;

    @GetMapping(value = "/approveCheck")
    public ResponseV2 checkApprove(HttpServletRequest request){
        log.info("req url: {}",request.getRequestURL());
        String id = request.getParameter("id");
        log.info("req field: {}", id);
        clinicManagerService.updateApprove(id);
        return ResponseHelper.create();
    }

    @GetMapping(value = "/approveList")
    public ResponseV2 getSearchApprove(HttpServletRequest request) {
        log.info("req url: {}",request.getRequestURL());
        String staffId = request.getParameter("staffId");
        log.info("req field: {}", staffId);
        return ResponseHelper.create(clinicManagerService.getApproveMsg(staffId));
    }

}
