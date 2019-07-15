package com.hospital.server.util;

import java.util.HashMap;
import java.util.Map;

public class ConstTable {

    private static final Map<String, Integer> medicalPrice;

    static {
        medicalPrice = new HashMap<>();
        medicalPrice.put("001", 10);
        medicalPrice.put("002", 15);
        medicalPrice.put("003", 20);
    }

}
