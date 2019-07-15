package com.hospital.server.service.impl;

import com.hospital.server.dao.Excal2DB;
import com.hospital.server.pojo.Dep_info;
import com.hospital.server.pojo.Medical;
import com.hospital.server.pojo.Staff;
import com.hospital.server.service.ExportExcalService;
import com.hospital.server.util.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ExportExcalServiceImpl implements ExportExcalService {
    @Resource
    private Excal2DB excal2DB;
    @Override
    public void exportExcal(String url,String type) {

        String excalUrl = Tools.downloadHelper(url);
        log.info("下载Excal表格完成。。。。。");
        System.out.println("Excal路径为："+excalUrl);
        try {
            switch (type){
                case "1":
                    //诊所职工名单

                    List<Staff> listExcel=Tools.getStaffByExcel(excalUrl);
                    for (int i = 0; i <listExcel.size() ; i++) {
                        Staff staff = listExcel.get(i);
                        excal2DB.excalStaff2DB(staff);
                    }
                    break;
                case "2":
                    //药品名单
                    List<Medical> listExcel1=Tools.getMedicalByExcel(excalUrl);
                    for (int i = 0; i <listExcel1.size() ; i++) {
                        Medical medical = listExcel1.get(i);
                        excal2DB.excalMedical2DB(medical);
                    }
                    break;
                case "3":
                    //科室名单
                    List<Dep_info> listExcel2=Tools.getDepByExcel(excalUrl);
                    for (int i = 0; i <listExcel2.size() ; i++) {
                        Dep_info dep_info = listExcel2.get(i);
                        excal2DB.excalDep2DB(dep_info);
                    }
                    break;
            }
        }catch (Exception e){
            log.error("导入Excal表失败！"+e.getMessage()+"错误类："+e.getStackTrace());
        }



    }
}
