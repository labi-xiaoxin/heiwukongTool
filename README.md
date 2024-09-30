<p align="center">
	<strong>欢迎使用👏🏻heiwukongTool</strong>
</p>
<a href="#" target="_blank">
    <img alt="License: Apache-2.0" src="https://img.shields.io/badge/License-Apache2.0-red.svg" />
</a>

----------

## 🌆 简介

heiwukongTool，基于`javaFX`进行开发，用于黑神话悟空存档，理论上wegame和steam版本均可正常使用。提供备份当前存档、添加存档等功能，目前所使用的存档来源为：《宋潮不夜城》存档，含有：**石先锋、虎先锋、大圣残躯、毒敌大王、亢金星君、小黄龙、杨戬、寅虎**关卡存档。

----------

## 🚀 功能点

- **备份当前游戏存档**：在指定目录进行当前游戏存档，每次根据时间在指定目录下创建诸如`202409301016`文件夹，进行备份
- **指定BOSS存档替换**：目前提供的存档来源为《宋潮不夜城》，替换游戏中**存档10（请保持存档数小于10，否则存档10会被替换）**。

----------

## 🔥 使用

### 项目环境

下载项目包：`https://pan.baidu.com/s/1EZm8St7UhDJPerWC00sLqA?pwd=lbxx`

确保文件目录含有如下

---|
---|graalvm-jdk-21.0.4
---|config.properties
---|黑悟空存档助手.exe

### 运行项目

运行项目包内：`黑悟空存档助手.exe`,即可进入。

![软件界面](https://raw.githubusercontent.com/labi-xiaoxin/img/main/20240930104223.png)

#### 修改游戏路径

将【当前游戏路径】修改为你本机的游戏存档路径。
`例：C:\WeGameApps\rail_apps\BlackMythWukong(2002122)\b1\Saved\SaveGames\17293822637844226597`

然后点击【修改】，提示成功。

![修改成功](https://raw.githubusercontent.com/labi-xiaoxin/img/main/20240930104549.png)

#### 备份存档

将【备份存档路径】修改为你想设置的目录，点击【修改】即可保存备份存档目录

点击【备份当前存档】，将`当前游戏的存档`备份至【备份存档路径/20240930XXXX】目录下

![备份存档](https://raw.githubusercontent.com/labi-xiaoxin/img/main/20240930104855.png)

#### 指定BOSSS存档替换

**确保游戏内存档数小于10**，选择想跳转的BOSS，点击【添加存档至存档10】

![选择存档](https://raw.githubusercontent.com/labi-xiaoxin/img/main/20240930105302.png)

重新进入游戏，在【载入游戏】界面，即可看到所选的存档。

![所选存档](https://raw.githubusercontent.com/labi-xiaoxin/img/main/20240930105359.png)


## 开发计划
- [ ] 恢复存档功能
- [ ] 支持更多关卡BOSS
- [ ] 支持自定义选择存档

## 🤝 为项目添砖加瓦

欢迎提出 Contributions, issues 与 feature requests!<br />
随时查看 [issues page](https://github.com/labi-xiaoxin/heiwukongTool/issues).


## 感谢支持 🙏

如果这个项目对你产生了一点的帮助，请为这个项目点上一颗 ⭐️
