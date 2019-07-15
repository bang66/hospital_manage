package com.hospital.server.controller;



import com.hospital.server.service.ExportExcalService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/manager")
public class ExportExcalController {
    @Resource
    private ExportExcalService exportExcalService;

    @GetMapping(value = "/excal")
    ResponseV2 ExcalImport(HttpServletRequest request){
       String url = request.getParameter("url");
       String type = request.getParameter("type");
       ResponseV2 responseV2 = null;
       try {
           exportExcalService.exportExcal(url,type);
           responseV2 = ResponseHelper.create();

       }catch (Exception e){
           responseV2 = ResponseHelper.create(null,101,type+"：类型信息表入失败");
       }

    return  responseV2;
    }
}
