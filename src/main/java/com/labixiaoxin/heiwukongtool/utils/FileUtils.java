package com.labixiaoxin.heiwukongtool.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author admin
 */
public class FileUtils {
    /**
     * 备份文件到指定目录
     *
     * @param sourceFilePath 源文件路径
     * @param backupDirPath  备份目录路径
     * @return 备份后的文件路径
     * @throws IOException
     */
    public static Path backupFile(Path sourceFilePath, Path backupDirPath) throws IOException {
        if (Files.notExists(sourceFilePath)) {
            throw new IOException("源文件不存在: " + sourceFilePath);
        }

        if (Files.notExists(backupDirPath)) {
            // 创建备份目录
            Files.createDirectories(backupDirPath);
        }

        Path backupFilePath = backupDirPath.resolve(sourceFilePath.getFileName());
        Files.copy(sourceFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);

        return backupFilePath;
    }

    /**
     * 还原文件
     *
     * @param backupFilePath 备份文件的路径
     * @param targetFilePath 目标文件路径
     * @throws IOException
     */
    public static void restoreFile(Path backupFilePath, Path targetFilePath) throws IOException {
        if (Files.notExists(backupFilePath)) {
            throw new IOException("备份文件不存在: " + backupFilePath);
        }

        Files.copy(backupFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 删除文件
     *
     * @param filePath 要删除的文件路径
     * @throws IOException
     */
    public static void deleteFile(Path filePath) throws IOException {
        if (Files.notExists(filePath)) {
            throw new IOException("文件不存在: " + filePath);
        }

        Files.delete(filePath);
    }

    /**
     * 检查文件是否存在
     *
     * @param filePath 文件路径
     * @return 是否存在
     */
    public static boolean fileExists(Path filePath) {
        return Files.exists(filePath);
    }

    /**
     * 创建目录
     *
     * @param dirPath 目录路径
     * @throws IOException
     */
    public static void createDirectory(Path dirPath) throws IOException {
        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }
    }

    /**
     * 列出指定文件夹内的所有文件（不包含子目录）
     *
     * @param dirPath 目录路径
     * @throws IOException
     */
    public static List<Path> listFiles(Path dirPath) throws IOException {
        List<Path> fileName = new ArrayList<>();
        if (Files.notExists(dirPath) || !Files.isDirectory(dirPath)) {
            throw new IOException("指定的路径不存在或不是目录: " + dirPath);
        }

        try (Stream<Path> stream = Files.list(dirPath)) {
            stream.forEach(fileName::add);
        }

        return fileName;
    }

    public static boolean urlIsDir(String url){
        Path of = Path.of(url);
        if (Files.notExists(of) || !Files.isDirectory(of)) {
            return false;
        }

        return true;
    }

    /**
     * 判断文件名是否匹配指定的模式
     *
     * @param filePath 文件路径
     * @return 如果文件名匹配模式（以 ArchiveSaveFile. 开头并跟随数字），则返回 true；否则返回 false
     */
    public static boolean fileNameMatches(Path filePath) {
        // 获取文件名并转换为字符串
        String fileName = filePath.getFileName().toString();

        // 定义正则表达式：匹配以 ArchiveSaveFile. 开头并跟随一个或多个数字
        String regex = "^ArchiveSaveFile\\.\\d+\\.sav$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 检查文件名是否匹配正则表达式
        Matcher matcher = pattern.matcher(fileName);
        return matcher.matches();
    }

    /**
     * 判断路径是否是存档路径
     *
     * @param url 存档路径
     * @return 匹配返回true，否则返回false
     */
    public static boolean currentArchivePathMatches(String url) {
        Stream<Path> stream = null;
        try {
            Path dirPath = Path.of(url);
            if (Files.notExists(dirPath) || !Files.isDirectory(dirPath)) {
                return false;
            }
            stream = Files.list(dirPath);
            return stream.anyMatch(FileUtils::fileNameMatches);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    /**
     * 读取 resources 目录下的文件并复制到指定目录
     *
     * @param resourceFilePath resources 目录下的文件路径（例如 "config.properties"）
     * @param destinationPath  目标文件的路径（例如 "C:/target/config.properties"）
     * @throws IOException 如果读取或写入文件时出错
     */
    public void copyFileFromResources(String resourceFilePath, String destinationPath) throws IOException {
        // 使用类加载器读取 resources 目录下的文件
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceFilePath)) {
            if (inputStream == null) {
                throw new IOException("资源文件未找到: " + resourceFilePath);
            }

            // 将文件复制到指定路径，并覆盖目标文件
            Path destination = Path.of(destinationPath);
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
