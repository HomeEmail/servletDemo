

## JAVA servlet程序项目

参考：http://blog.csdn.net/yhao2014/article/details/45740111

项目ide配置不会上传到代码仓库，所以拉下代码后要根据你的ide配置项目：

1.配置jdk（配置了的请忽略）

2.out文件夹目录设置为源码编译输出目录

3.项目拉取下来时，需要设置项目结构 指定sources，使ide识别java文件

4.生成jar包 打开项目配置 配置Artifacts 注意配置output layout时设置output root包含编译的class文件目录 （一般右边input去左边就好）(大概有如下目录结构：WEB-INF/classes)

5.配置tomcat：modules dependencies










