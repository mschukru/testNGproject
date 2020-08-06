package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day22_WriteExcel {

    @Test
    public void writeExcel() throws IOException {
        String path = "./src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path); //file'i acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream); //workbook'u acalim.
        Sheet sheet = workbook.getSheetAt(0); //1.sheet'e git
        Row row = sheet.getRow(0); //1.row'a git(basliklar)

        FileOutputStream fileOuputStream = new FileOutputStream(path);
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("NUFUS");

        Cell cell5 =row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");

        row.removeCell(cell5);

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("81.256.758");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("11.254.752");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("82.256.777");

        workbook.write(fileOuputStream);
        fileOuputStream.close();
        fileInputStream.close();
        workbook.close();


    }
}
