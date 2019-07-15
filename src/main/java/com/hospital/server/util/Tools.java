package com.hospital.server.util;


import com.hospital.server.pojo.Dep_info;
import com.hospital.server.pojo.Medical;
import com.hospital.server.pojo.Staff;
import jxl.Sheet;
import jxl.Workbook;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 */
public class Tools {


    /***
     * 下载文件到指定路径
     * @param urlList
     * @return
     */
    public static String downloadHelper(String urlList) {
        URL url = null;
        int imageNumber = 0;
        String imageName = null;

        try {
            url = new URL(urlList.replace("\\",""));

            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String[] s=urlList.split("/");
            imageName =  "/Users/wangwenjun/Pictures/excal/"+s[s.length-1];
            //imageName =  "/home/ant/test/zxn-cupid/Resousce/pic/"+s[s.length-1];
            System.out.println(imageName+"===========================================");

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageName;
    }


    /***
     * 将StaffExcal的数据读出
     */
    public static List<Staff> getStaffByExcel(String url){
        List<Staff> list=new ArrayList<Staff>();
        try {
//            File file = new File(url);
//            System.out.println("    "+file.length());
            Workbook rwb=Workbook.getWorkbook(new File(url));
            Sheet rs=rwb.getSheet(0);//表
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println("表的列数："+clos+" 表的行数:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数

                    String staff_id = rs.getCell(j++, i).getContents();
                    String staff_name = rs.getCell(j++, i).getContents();
                    String staff_sex = rs.getCell(j++, i).getContents();
                    String staff_bir = rs.getCell(j++, i).getContents();
                    String staff_tel = rs.getCell(j++, i).getContents();
                    String staff_img = rs.getCell(j++, i).getContents();
                    String staff_pos = rs.getCell(j++, i).getContents();
                    String staff_entry = rs.getCell(j++, i).getContents();

                    System.out.println("id:"+staff_id+" name:"+staff_name+" sex:"+staff_sex+" bir:"+staff_bir
                    +"tel:"+staff_tel+"img:"+staff_img+"pos:"+staff_pos+"entry:"+staff_entry);
                    list.add(new Staff(staff_id,staff_name,staff_sex,staff_bir,staff_tel,staff_img,staff_pos,staff_entry));

                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String[] args) {
        String excalUrl = "/Users/wangwenjun/Pictures/excal/UDgOoXD6.xls";
        List<Staff> listExcel=Tools.getStaffByExcel(excalUrl);
        System.out.println(listExcel);
    }


    /***
     * 将MedicalExcal的数据读出
     */
    public static List<Medical> getMedicalByExcel(String url){
        List<Medical> list=new ArrayList<Medical>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(url));
            Sheet rs=rwb.getSheet(0);//表
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println("表的列数："+clos+" 表的行数:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    String medical_id = rs.getCell(j++, i).getContents();
                    String medical_name = rs.getCell(j++, i).getContents();
                    String medical_desc = rs.getCell(j++, i).getContents();
                    String medical_price = rs.getCell(j++, i).getContents();
                    String produce_time = rs.getCell(j++, i).getContents();
                    String save_time = rs.getCell(j++, i).getContents();
                    String current_num = rs.getCell(j++, i).getContents();

                    System.out.println("id:"+medical_id+" name:"+medical_name+" desc:"+medical_desc+" time:"+produce_time
                            +"save:"+save_time+"current:"+current_num);
                    list.add(new Medical(medical_id,medical_name,medical_desc,Double.parseDouble(medical_price),produce_time,save_time,current_num));

                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /***
     * 将Dep_infoExcal的数据读出
     */
    public static List<Dep_info> getDepByExcel(String url){
        List<Dep_info> list=new ArrayList<Dep_info>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(url));
            Sheet rs=rwb.getSheet(0);//表
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println("表的列数："+clos+" 表的行数:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {

                    String cli_id = rs.getCell(j++, i).getContents();
                    String dep_id = rs.getCell(j++, i).getContents();
                    String dep_name = rs.getCell(j++, i).getContents();
                    String dep_master = rs.getCell(j++, i).getContents();

                    System.out.println("id:"+cli_id+" dep_id:"+dep_id+" dep_name:"+dep_name+" dep_master:"+dep_master);
                    list.add(new Dep_info(cli_id,dep_id,dep_name,dep_master));

                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }

    /***
     * 生成的时间戳
     * @return
     */
    public static String getTimeStamp() {
        String id = String.valueOf(System.currentTimeMillis());
        return id;
    }


}
