package com.labixiaoxin.heiwukongtool.enums;

public enum GamesEnums {
    /**
     * 石先锋
     */
    SHIXIANGFENG(1, "saved/1/ArchiveSaveFile.4.sav","石先锋"),
    HUXIANFENG(2, "saved/2/ArchiveSaveFile.4.sav","虎先锋"),
    DASHENGCANQV(3,"saved/3/ArchiveSaveFile.4.sav","大圣残躯"),
    DUDIDAWANG(4,"saved/4/ArchiveSaveFile.4.sav","毒敌大王"),
    KANGJINXINGJUN(5,"saved/5/ArchiveSaveFile.4.sav","亢金星君"),
    XIAOHUANGLONG(6,"saved/6/ArchiveSaveFile.4.sav","小黄龙"),
    YANGJIAN(7,"saved/7/ArchiveSaveFile.4.sav","杨戬"),
    YINHU(8,"saved/8/ArchiveSaveFile.4.sav","寅虎"),
    ;

    /**
     * 关卡代码
     */
    private final int code;
    /**
     * 关卡资源
     */
    private final String url;
    private final String descript;

    public int getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public String getDescript() {
        return descript;
    }

    GamesEnums(int code, String url, String descript) {
        this.code = code;
        this.url = url;
        this.descript = descript;
    }

    /**
     * 根据code获取对应的枚举值
     */
    public static GamesEnums getByCode(int code) {
        for (GamesEnums game : values()) {
            if (game.getCode() == code) {
                return game;
            }
        }
        return null; // 如果未找到对应的枚举，可以返回null或抛出异常
    }
}
