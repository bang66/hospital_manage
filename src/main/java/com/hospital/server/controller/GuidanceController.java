package com.hospital.server.controller;

import com.hospital.server.pojo.OrderUser;
import com.hospital.server.service.IGuidanceService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/guidance")
public class GuidanceController {

    @Autowired
    private IGuidanceService guidanceService;

    private List<OrderUser> orderUsers;


    @GetMapping (value = "/orderMsg")
    public ResponseV2 getOrderMsg(HttpServletRequest request){
        String userId = request.getParameter("userId");
        System.out.println("userid："+userId);
        orderUsers = guidanceService.getOrderList(userId);
        return ResponseHelper.create(orderUsers);
    }


    @GetMapping (value = "/regist")
    public ResponseV2 doRegist(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = guidanceService.insertRegist(id, orderUsers);
        return ResponseHelper.create(status);

    }

}
