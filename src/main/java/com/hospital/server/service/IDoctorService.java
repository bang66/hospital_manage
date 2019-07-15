package com.hospital.server.service;

import java.util.ArrayList;

public interface IDoctorService {

    ArrayList getRegistList(String staffId);

    void nextPatient(String staff_id, String user_name);

    void createIllness(String staffId, String currentPatient, String medical_id_num, String illness_desc, String treat_id_num);
}
