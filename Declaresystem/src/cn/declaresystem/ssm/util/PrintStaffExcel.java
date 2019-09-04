package cn.declaresystem.ssm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.util.CellRangeAddress;

import cn.declaresystem.ssm.pojo.BasicInfo;
import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.pojo.Staff;

public class PrintStaffExcel {
    private static final String EXCEL_XLS = "group.xls";

    public void writeExcel(HttpServletRequest request, Enterprise enterprise, BasicInfo info, List<Staff> managerList, Integer totalCount) {

        String filePath = request.getSession().getServletContext().getRealPath("file/")
                + File.separatorChar + EXCEL_XLS;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
            HSSFSheet sheet = null;
            HSSFRow row = null;
            HSSFCell cell = null;
            sheet = workbook.getSheet("����");
            row = sheet.getRow((short) 6);
            cell = row.getCell((short) 3);
            cell.setCellValue(enterprise.getName());
            Calendar calendar = Calendar.getInstance();
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = calendar.get(Calendar.MONTH) + 1;
            Integer day = calendar.get(Calendar.DATE);
            row = sheet.getRow((short) 10);
            cell = row.getCell((short) 3);
            cell.setCellValue(year);
            cell = row.getCell((short) 5);
            cell.setCellValue(month);
            cell = row.getCell((short) 7);
            cell.setCellValue(day);
            sheet = workbook.getSheet("��1");
            row = sheet.getRow((short) 3);
            cell = row.getCell((short) 3);
            cell.setCellValue(enterprise.getName());
            row = sheet.getRow((short) 4);
            cell = row.getCell((short) 3);
            if (1 == info.getType()) {
                cell.setCellValue("�̹���    ������     ������");
            } else if (2 == info.getType()) {
                cell.setCellValue("������    ������     ������");
            } else {
                cell.setCellValue("������    ������     ������");
            }
            row = sheet.getRow((short) 5);
            cell = row.getCell((short) 3);
            cell.setCellValue(info.getAddress());
            row = sheet.getRow((short) 5);
            cell = row.getCell((short) 10);
            cell.setCellValue(info.getPostcode());
            row = sheet.getRow((short) 6);
            cell = row.getCell((short) 3);
            cell.setCellValue(info.getTel());
            row = sheet.getRow((short) 6);
            cell = row.getCell((short) 7);
            cell.setCellValue(info.getFax());
            row = sheet.getRow((short) 6);
            cell = row.getCell((short) 10);
            cell.setCellValue(info.getEmail());
            row = sheet.getRow((short) 7);
            cell = row.getCell((short) 3);
            cell.setCellValue(enterprise.getLicense());

            for (int i = 0; i < totalCount; i++) {
                row = sheet.getRow((short) i + 10);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getPe_name());
                cell = row.getCell((short) 3);
                String sex = null;
                if ("1" == managerList.get(i).getPe_sex()) {
                    sex = "��";
                } else {
                    sex = "Ů";
                }
                cell.setCellValue(sex);
                cell = row.getCell((short) 4);
                cell.setCellValue(managerList.get(i).getPe_birthday());
                cell = row.getCell((short) 5);
                cell.setCellValue(managerList.get(i).getDd2().getName());
                cell = row.getCell((short) 7);
                cell.setCellValue(managerList.get(i).getDd3().getName());
                cell = row.getCell((short) 8);
                cell.setCellValue(managerList.get(i).getRelation().getRe_dept());
                cell = row.getCell((short) 10);
                cell.setCellValue(managerList.get(i).getDd4().getName());
            }

            for (int i = 0; i < totalCount; i++) {
                sheet = workbook.getSheet("��2-" + (i + 1));
                row = sheet.getRow((short) 3);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getPe_name());
                row = sheet.getRow((short) 3);
                cell = row.getCell((short) 4);
                String sex = null;
                System.out.println(managerList.get(i).getPe_sex());
                if ("1".equals(managerList.get(i).getPe_sex())) {
                    sex = "��";
                } else {
                    sex = "Ů";
                }
                cell.setCellValue(sex);
                row = sheet.getRow((short) 4);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getPe_birthday());
                row = sheet.getRow((short) 4);
                cell = row.getCell((short) 4);
                cell.setCellValue(managerList.get(i).getDd1().getName());
                row = sheet.getRow((short) 5);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getPe_school());
                row = sheet.getRow((short) 5);
                cell = row.getCell((short) 4);
                cell.setCellValue(managerList.get(i).getDd2().getName());
                row = sheet.getRow((short) 6);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getDd3().getName());
                row = sheet.getRow((short) 6);
                cell = row.getCell((short) 4);
                cell.setCellValue(managerList.get(i).getPe_assess_date());
                row = sheet.getRow((short) 7);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getDd4().getName());
                row = sheet.getRow((short) 8);
                cell = row.getCell((short) 2);
                cell.setCellValue(managerList.get(i).getPe_speciality());
            }
			
/*			if(totalCount>3){
				for(int i=0;i<totalCount-3;i++){
					sheet = workbook.createSheet("��2-"+(i+4));
					HSSFSheet _sheet = workbook.getSheet("��2-1");
					this.copySheet(_sheet, sheet);
				}				
			}*/


            FileOutputStream outputStream = new FileOutputStream("E://group" + System.currentTimeMillis() + ".xls");
            workbook.write(outputStream);
            outputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	/*private static HSSFSheet copySheet(HSSFSheet sheetFrom,HSSFSheet sheetTo) { 
        // ���ڻ�
        CellRangeAddress region = null; 
        Row rowFrom = null; 
        Row rowTo = null; 
        Cell cellFrom = null; 
        Cell cellTo = null; 
        //����Y�ϤΥ��ԩ` 
        for (int i = 0; i < sheetFrom.getNumMergedRegions(); i++) { 
            region = sheetFrom.getMergedRegion(i); 
            if ((region.getFirstColumn() >= sheetFrom.getFirstRowNum()) 
                    && (region.getLastRow() <= sheetFrom.getLastRowNum())) { 
                sheetTo.addMergedRegion(region); 
            } 
        } 

        //����Υ��ԩ` 
        for (int intRow = sheetFrom.getFirstRowNum(); intRow < sheetFrom.getLastRowNum(); intRow++) { 
            rowFrom = sheetFrom.getRow(intRow); 
            rowTo = sheetTo.createRow(intRow); 
            if (null == rowFrom) 
                continue; 
            rowTo.setHeight(rowFrom.getHeight()); 
            for (int intCol = 0; intCol < rowFrom.getLastCellNum(); intCol++) { 
                //������Υ��ԩ` 
                sheetTo.setDefaultColumnStyle(intCol, sheetFrom.getColumnStyle(intCol)); 
                sheetTo.setColumnWidth(intCol, sheetFrom.getColumnWidth(intCol)); 
                cellFrom = rowFrom.getCell(intCol); 
                cellTo = rowTo.createCell(intCol); 
                if (null == cellFrom) 
                    continue; 
                //���륹������ȥ����פΥ��ԩ` 
                cellTo.setCellStyle(cellFrom.getCellStyle()); 
                cellTo.setCellType(cellFrom.getCellType()); 
                 
                //�����ȥ����ݤΥ��ԩ` 
                if (null != cellFrom.getStringCellValue() && !"".equals(cellFrom.getStringCellValue().trim())) 
                    cellTo.setCellValue(cellFrom.getStringCellValue()); 
            } 
        }          
        //�������O�� 
        sheetTo.setDisplayGridlines(false); 
        //Excel�Υ��`���O�� 
        sheetTo.setZoom(80, 100);  
        //���`�Ȥ���롣 
        return sheetTo; 
    }*/

}
