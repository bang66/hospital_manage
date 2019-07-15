package com.hospital.server.service;

import com.hospital.server.pojo.OrderUser;

import java.util.List;

public interface IGuidanceService {

    List<OrderUser> getOrderList(String orderId);

    String insertRegist(int id, List<OrderUser> orderUser);
}
