package com.labixiaoxin.heiwukongtool;

import com.labixiaoxin.heiwukongtool.enums.GamesEnums;
import com.labixiaoxin.heiwukongtool.utils.FileUtils;
import com.labixiaoxin.heiwukongtool.utils.PropertiesUtils;
import com.labixiaoxin.heiwukongtool.utils.TimeConverter;
import com.labixiaoxin.heiwukongtool.utils.WindowsUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author admin
 */
public class HelloController implements Initializable {
    @FXML
    public TextField shixianfengArchivePath;
    @FXML
    public TextField huxianfengArchivePath;
    @FXML
    public TextField dashengcanqvArchivePath;
    @FXML
    public TextField dudidawangArchivePath;
    @FXML
    public TextField kangjinxingjunArchivePath;
    @FXML
    public TextField xiaohuanglongArchivePath;
    @FXML
    public TextField yangjianArchivePath;
    @FXML
    public TextField yinhuArchivePath;

    private PropertiesUtils propertiesUtils;
    private FileUtils fileUtils;

    public HelloController() {
        propertiesUtils = new PropertiesUtils("config.properties");
        propertiesUtils.loadConfig();
        fileUtils = new FileUtils();
    }

    /**
     * 当前备份路径
     */
    @FXML
    public TextField backCurrentArchivePath;

    /**
     * 当前游戏存档路径
     */
    @FXML
    private TextField currentArchivePath;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //读取配置文件
        PropertiesUtils propertiesUtils = new PropertiesUtils("config.properties");
        propertiesUtils.loadConfig();
        currentArchivePath.setText(propertiesUtils.getProperty("currentArchiveUrl"));
        backCurrentArchivePath.setText(propertiesUtils.getProperty("backCurrentArchiveUrl"));

        //文件列表
//        descript.setCellValueFactory(new PropertyValueFactory<FileVo, String>("descript"));
//        fileUrl.setCellValueFactory(new PropertyValueFactory<FileVo, String>("fileUrl"));
//        fileTable.setItems(FXCollections.observableArrayList(
//                new FileVo("石先锋", propertiesUtils.getProperty("shixianfengArchivePath")),
//                new FileVo("虎先锋", propertiesUtils.getProperty("huxianfengArchivePath"))
//        ));

        shixianfengArchivePath.setText(propertiesUtils.getProperty("shixianfengArchivePath"));
        huxianfengArchivePath.setText(propertiesUtils.getProperty("huxianfengArchivePath"));
        dashengcanqvArchivePath.setText(propertiesUtils.getProperty("dashengcanqvArchivePath"));
        dudidawangArchivePath.setText(propertiesUtils.getProperty("dudidawangArchivePath"));
        kangjinxingjunArchivePath.setText(propertiesUtils.getProperty("kangjinxingjunArchivePath"));
        xiaohuanglongArchivePath.setText(propertiesUtils.getProperty("xiaohuanglongArchivePath"));
        yangjianArchivePath.setText(propertiesUtils.getProperty("yangjianArchivePath"));
        yinhuArchivePath.setText(propertiesUtils.getProperty("yinhuArchivePath"));
    }

    /**
     * 点击备份当前存档按钮
     */
    @FXML
    public void onBackupTheCurrentArchiveButtonClick() {
        try {
            List<Path> paths = FileUtils.listFiles(Path.of(currentArchivePath.getText()));
            String url = backCurrentArchivePath.getText() + "\\" + TimeConverter.convertTimestampToDate();
            for (Path path : paths) {
                FileUtils.backupFile(path, Path.of(url));
            }
            WindowsUtils.alertInformation("成功提示", "备份成功", "备份地址：" + url);
            backCurrentArchivePath.setText(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    public void onGetTheCurrentBackupPathButtonClick() {
//    }

    /**
     * 修改当前游戏路径
     */
    @FXML
    public void changeCurrentArchivePath() {
        //判断路径是否正确
        if (!FileUtils.currentArchivePathMatches(currentArchivePath.getText())) {
            //路径错误
            WindowsUtils.alertError("错误提示", "当前游戏路径错误", "请检查“当前游戏路径”");
            //刷回
            currentArchivePath.setText(propertiesUtils.getProperty("currentArchiveUrl"));
            return;
        }
        //修改配置文件
        propertiesUtils.updateProperty("currentArchiveUrl", currentArchivePath.getText());
        propertiesUtils.saveConfig();
        //提示修改成功
        WindowsUtils.alertInformation("成功提示", "当前游戏路径修改成功", null);
    }

    /**
     * 修改备份存档路径
     */
    @FXML
    public void changeBackCurrentArchivePath() {
        if (!FileUtils.urlIsDir(backCurrentArchivePath.getText())) {
            //路径错误
            WindowsUtils.alertError("错误提示", "备份存档路径错误", "请检查“备份存档路径”");
            //刷回
            backCurrentArchivePath.setText(propertiesUtils.getProperty("backCurrentArchiveUrl"));
            return;
        }
        //修改配置文件
        propertiesUtils.updateProperty("backCurrentArchiveUrl", backCurrentArchivePath.getText());
        propertiesUtils.saveConfig();
        //提示修改成功
        WindowsUtils.alertInformation("成功提示", "备份存档路径修改成功", null);
    }

    private void addArchiveToArchive(int type) throws IOException {
        //TODO 前置检查

        //执行最终操作
        GamesEnums byCode = GamesEnums.getByCode(type);
        if (null != byCode) {
            String url = byCode.getUrl();
            //将资源添加进去
            try {
                fileUtils.copyFileFromResources(url, currentArchivePath.getText() + "/ArchiveSaveFile.10.sav");
            } catch (IOException e) {
                throw new IOException("Archive addition failure");
            }
            //提示最终操作完成
            WindowsUtils.alertInformation("成功提示","所选存档已存入",byCode.getDescript());
        }

    }

    @FXML
    public void onAddSxfArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddHxfArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAdddscqArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddddddwArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddkjxjArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddxhlArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddyjArchiveToArchive() {
        //执行最终操作
        try {
            this.addArchiveToArchive(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddyhArchiveToArchive() {//执行最终操作
        try {
            this.addArchiveToArchive(8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}