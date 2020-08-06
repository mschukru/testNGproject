package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day21_ReadExcel {
    @Test
    public void readExcelFile() throws IOException {
        //Data okuyacagimiz dosyainin path'ini yazalim
        String path = "./src/test/resources/ULKELER.xlsx";
        //Dosyayi(file)acalim
        FileInputStream fileInputStream = new FileInputStream(path);
        //fileInputStream kullanarak workbook'u acalim.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //1. worksheet'e gidelim (index 0 dan basliyor)
        Sheet sheet = workbook.getSheetAt(0);
        //1.Satira (row) gidelim (index 0 dan basliyor)
        Row row = sheet.getRow(0);
        //Artik test data'larini (cell) okuyabiliriz
        Cell cell = row.getCell(0);

        System.out.println("1. CELL'deki data : "+cell);
        System.out.println("2. CELL'deki data : "+row.getCell(1));
        System.out.println("3. CELL'deki data : "+row.getCell(2));

        //2.row'daki 1.cell'i consola yazdiriniz
        Row row2 =sheet.getRow(1);
        Cell cell1 = row2.getCell(0);
        System.out.println(cell1);
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));

        String row2cell1 = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(row2cell1);

        //Son row numarasini alalim
        int rowsayisi = sheet.getLastRowNum();
        System.out.println("Dosyadaki toplam satir sayisi : "+rowsayisi);

        //Kullanilan satirlarin sayisini nasil aliriz?
        int numberOfPhysicalRows = sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfPhysicalRows);

        Map<String,String> ulkeler = new HashMap<>();
        int ulkeColum = 0;
        int baskentColum = 1;
        for (int rowNum = 1 ; rowNum<= rowsayisi ; rowNum++){
            String ulke = sheet.getRow(rowNum).getCell(ulkeColum).toString();
            System.out.print(ulke+" => ");
            String baskent = sheet.getRow(rowNum).getCell(baskentColum).toString();
            System.out.println(baskent);

            //hashmap olarak nasil yazdirabiliriz?
            ulkeler.put(ulke, baskent);

        }
        System.out.println(ulkeler);
    }
}
