package com.labixiaoxin.heiwukongtool.entity;

/**
 * @author admin
 */
public class FileVo {
    private String descript;
    private String fileUrl;

    public FileVo(String descript, String fileUrl) {
        this.descript = descript;
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
