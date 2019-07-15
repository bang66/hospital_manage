package com.hospital.server.controller;


import com.hospital.server.service.LeaforService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequestMapping
@RestController
public class LeaforController {
    @Resource
    private LeaforService leaforService;

    @GetMapping(value = "/leafor/cost")
    ResponseV2 catCostMsg(HttpServletRequest request){
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        log.info("用户id:"+id+" 职业类型为：（1.药品医师 2。输液室医师）"+type);
        ResponseV2 responseV2 = null;
        try {
            leaforService.leafMessage(id,type);
            responseV2 = ResponseHelper.create();
        }catch (Exception e){
            log.error("购买药品或输液设备失败："+e.getMessage());
            responseV2 = ResponseHelper.create(null,102,"购买输液设备失败");
        }


        return responseV2;
    }
}
