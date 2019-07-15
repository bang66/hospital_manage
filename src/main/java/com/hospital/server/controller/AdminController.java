package com.hospital.server.controller;

import com.hospital.server.pojo.Hello;
import com.hospital.server.service.IAdminService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;


    @ResponseBody
    @RequestMapping(value = "/hello", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseV2 hello(HttpServletRequest request){


        //String queryString = "";

//        queryString = queryString.substring(0, queryString.length() - 1);
//        System.out.println(queryString+"$$$$$$$$$$");
//            adminService.exportWorker();
//        System.out.println(parameterMap+"sss");

        return ResponseHelper.create(new Hello("xxx"));
    }

}
