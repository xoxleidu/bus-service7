/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-13
 * Time: 13:42
 */
package com.zjts.buscenter.pio.convert;

import com.zjts.buscenter.web.model.BusInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XlsMain {


    /*public static void main(String[] args) {
        String path ="C:\\Users\\zs\\Desktop\\公交处\\公交处资料\\公交处资料\\廊坊市公共交通运输集团有限公司车辆技术档案2017.12.21.xlsx";
        XlsMain xlsMain = new XlsMain();
        try {
            List<BusInfo> list = xlsMain.readXls(path);
            for (int i = 0; i < list.size(); i++) {
                System.err.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public List<BusInfo> readXls(String path) throws Exception {

        File excelFile = new File(path);
        InputStream is = new FileInputStream(excelFile);
        // HSSFWorkbook 标识整个excel
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        if(xssfWorkbook==null){
            System.err.println("未读取到内容,请检查路径！");
            return null;
        }

        BusInfo busInfo = null;
        List<BusInfo> list = new ArrayList<>();
        //获取Excel表中所有sheet 页数
        int size = xssfWorkbook.getNumberOfSheets();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < size; numSheet++) {
            // HSSFSheet 标识某一页
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            int lastRowNum = xssfSheet.getLastRowNum();
            for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                busInfo = new BusInfo();
                // 循环列Cell
                // 0序号 1线路 2车牌号 3厂牌型号 4车辆登记证编号 5发动机号 6车辆识别代码 7座位数 8登记日期 9备注 10验车日期
             /*   XSSFCell id = xssfRow.getCell(0);
                if (id == null) {
                    continue;
                }
                busInfo.setId(getValue(id));*/
                XSSFCell line = xssfRow.getCell(1);
                if (line == null) {
                    continue;
                }
                busInfo.setLine(getValue(line));
                XSSFCell busLicense = xssfRow.getCell(2);
                if (busLicense == null) {
                    continue;
                }
                busInfo.setBusLicense(getValue(busLicense));
                XSSFCell brandCachet = xssfRow.getCell(3);
                if (brandCachet == null) {
                    continue;
                }
                busInfo.setBrandCachet(getValue(brandCachet));
                XSSFCell registrationNumber = xssfRow.getCell(4);
                if (registrationNumber == null) {
                    continue;
                }
                busInfo.setRegistrationNumber(getValue(registrationNumber));
                XSSFCell engineNumber = xssfRow.getCell(5);
                if (engineNumber == null) {
                    continue;
                }
                busInfo.setEngineNumber(getValue(engineNumber));
                XSSFCell vehicleIdentification = xssfRow.getCell(6);
                if (vehicleIdentification == null) {
                    continue;
                }
                busInfo.setVehicleIdentification(getValue(vehicleIdentification));
                XSSFCell seating = xssfRow.getCell(7);
                if (seating == null) {
                    continue;
                }
                busInfo.setSeating(getValue(seating));
                XSSFCell recordDate = xssfRow.getCell(8);
                if (recordDate == null) {
                    continue;
                }
                busInfo.setRecordDate(getValue(recordDate));
                XSSFCell remarks = xssfRow.getCell(9);
                if (remarks == null) {
                    continue;
                }
                busInfo.setRemarks(getValue(remarks));
                XSSFCell vehicleExamination = xssfRow.getCell(10);
                if (vehicleExamination == null) {
                    continue;
                }
                busInfo.setVehicleExamination(getValue(vehicleExamination));
                list.add(busInfo);
            }
        }

        return list;
    }
    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfCell) {
        if(xssfCell==null){
            return "---";
        }
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            double cur=xssfCell.getNumericCellValue();
            long longVal = Math.round(cur);
            Object inputValue = null;
            if(Double.parseDouble(longVal + ".0") == cur){
                inputValue = longVal;
            }else {
                inputValue = longVal;
            }
            return String.valueOf(inputValue);
        } else {
            // 返回字符串类型的值
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }
}
