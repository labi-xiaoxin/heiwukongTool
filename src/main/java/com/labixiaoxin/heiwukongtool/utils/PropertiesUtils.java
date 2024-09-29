package com.labixiaoxin.heiwukongtool.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author admin
 */
public class PropertiesUtils {
    private Properties properties;
    private String configFilePath;

    public PropertiesUtils(String configFilePath) {
        this.configFilePath = configFilePath;
        properties = new Properties();
    }

    // 读取配置文件
    public void loadConfig() {
        try (InputStream inputStream = new FileInputStream(configFilePath);
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            System.out.println(new File(configFilePath).getAbsolutePath());
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 修改配置文件中的属性
    public void updateProperty(String key, String value) {
        properties.setProperty(key, value); // 更新或添加属性
    }

    // 保存修改后的配置文件
    public void saveConfig() {
        try (OutputStream outputStream = new FileOutputStream(configFilePath);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            properties.store(writer, "Updated Configuration"); // 保存配置并写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
