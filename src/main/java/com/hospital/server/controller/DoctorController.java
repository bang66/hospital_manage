package com.hospital.server.controller;


import com.hospital.server.service.IDoctorService;
import com.hospital.server.util.ResponseHelper;
import com.hospital.server.util.ResponseV2;
import com.hospital.server.util.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private Map<String, ArrayList<String>> registerMap = new HashMap<>();

    private Map<String, ArrayList<String>> treatMap = new HashMap<>();

    @Autowired
    private IDoctorService doctorService;

    @GetMapping(value = "/registList")
    public ResponseV2 getRegistList(HttpServletRequest request){
        log.info("req url: {}",request.getRequestURL());
        String staffId = request.getParameter("staffId");
        log.info("req field: {}", staffId);
        if (registerMap.containsKey(staffId)) {
            ArrayList<String> arrayList = registerMap.get(staffId);
            if (arrayList == null || arrayList.isEmpty()) {
                ArrayList<String> registers = doctorService.getRegistList(staffId);
                registerMap.put(staffId, registers);
                return ResponseHelper.create(registers);
            } else {
                return ResponseHelper.create(arrayList);
            }
        } else {
            ArrayList<String> registers = doctorService.getRegistList(staffId);
            registerMap.put(staffId, registers);
            return ResponseHelper.create(registers);
        }
    }

    //TODO : 没写完，还有推送
    @GetMapping(value = "/next")
    public ResponseV2 nextPatient(HttpServletRequest request) {
        log.info("req url: {}",request.getRequestURL());
        String staffId = request.getParameter("staffId");
        log.info("req field: {}", staffId);
        ArrayList<String> registers = registerMap.get(staffId);
        String firstPatient = registers.get(0);
        String nextPatient = registers.get(1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(firstPatient);
        treatMap.put(staffId, arrayList);
        registers.remove(0);
        doctorService.nextPatient(staffId, firstPatient);
        String message = "当前呼叫患者：" + firstPatient + "  下一位患者：" + nextPatient;
        WebSocketServer web = new WebSocketServer();
        web.onMessage(message,null);
        log.info("current patient : {}",firstPatient);
        log.info("next patient : {}",nextPatient);
        return ResponseHelper.create();
    }

    @GetMapping(value = "/illnessInfo")
    public ResponseV2 insertIllness (HttpServletRequest request) {
        log.info("req url: {}",request.getRequestURL());
        String staffId = request.getParameter("staffId");
        log.info("req field: {}", staffId);
        ArrayList treatList = treatMap.get(staffId);
        String currentPatient = (String) treatList.get(treatList.size()-1);
        String medical_id_num = "[{\"type\":\"001\",\"medical_num\":10},{\"type\":\"002\",\"medical_num\":10},{\"medical_id\":\"003\",\"medical_num\":10}]";
        String illness_desc = "感冒";
        String treat_id_num = "[{\"treat_id\":\"007\",\"treat_num\":1}]";
        doctorService.createIllness(staffId, currentPatient, medical_id_num, illness_desc, treat_id_num);
        return ResponseHelper.create();
    }
}
