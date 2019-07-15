package com.hospital.server.service.impl;

import com.hospital.server.dao.GuidanceDao;
import com.hospital.server.pojo.OrderUser;
import com.hospital.server.pojo.RegistInfo;
import com.hospital.server.service.IGuidanceService;
import com.hospital.server.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IGuidanceServiceImpl implements IGuidanceService {

    @Resource
    private GuidanceDao guidanceDao;

    /**
     * 获取当天所有预约的患者的预约信息
     */
    @Override
    public List<OrderUser> getOrderList(String user_id) {
        return guidanceDao.getOrderUserMsg(user_id);
    }

    /**
     * 生成挂号信息
     * @return
     */
    @Override
    public String insertRegist(int id, List<OrderUser> orderUser) {
        List<OrderUser> users = orderUser.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        if (!users.isEmpty()){
            String registerId = Tools.getTimeStamp();
            String reserveId = users.get(0).getReserve_id();
            String userId = users.get(0).getUser_id();
            String staffId = users.get(0).getStaff_id();
            RegistInfo registInfo = new RegistInfo();
            registInfo.setRegister_id(registerId);
            registInfo.setReserve_id(reserveId);
            registInfo.setStaff_id(staffId);
            registInfo.setUser_id(userId);
            int status = guidanceDao.inserRegistInfo(registInfo);
            if (status == 1){
                return "SUCCESS";
            } else {
                return "FAIL";
            }
        } else {
            return "FAIL";
        }
    }

}
