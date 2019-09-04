package cn.declaresystem.ssm.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.declaresystem.ssm.pojo.Staff;


public class ExportStaffExcel {
    public void Export(List<Staff> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("��ְ��ҵְ����");
        sheet.setDefaultColumnWidth((short) 15);
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("����");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("�Ա�");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("��������");
        cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("ѧ��");
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("רҵ");
        cell.setCellStyle(style);
        cell = row.createCell((short) 5);
        cell.setCellValue("ְ��");
        cell.setCellStyle(style);
        cell = row.createCell((short) 6);
        cell.setCellValue("��ְ����");
        cell.setCellStyle(style);
        for (short i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(list.get(i).getPe_name());
            row.createCell(1).setCellValue(list.get(i).getPe_sex());
            row.createCell(2).setCellValue(list.get(i).getPe_birthday());
            row.createCell(3).setCellValue(list.get(i).getDd1().getName());
            row.createCell(4).setCellValue(list.get(i).getDd2().getName());
            row.createCell(5).setCellValue(list.get(i).getDd3().getName());
            row.createCell(6).setCellValue(list.get(i).getRelation().getRe_dept());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("E://��ҵְ����" + System.currentTimeMillis() + ".xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
