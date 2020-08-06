package com.techproed.utilities;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Bu class'in amaci, congigration.properties dosyasindaki verileri(test data) okumaktir.
    //Create Properties instance
    private static Properties properties;
    //FileInputStream kullanarak bir dosya aciyoruz.
    //Properties' bu dosyaya yüklüyoruz.
    //Daha sonra da properties dosyasini okuyacagiz.
    //baslatmak icin static blok olusturduk.
    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    //OKumak icin static bir method olusturalim
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
