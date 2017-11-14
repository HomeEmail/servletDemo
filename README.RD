

## JAVA servlet程序项目

参考：http://blog.csdn.net/yhao2014/article/details/45740111

项目ide配置不会上传到代码仓库，所以拉下代码后要根据你的ide配置项目：

1.配置jdk（配置了的请忽略）

2.out文件夹目录设置为源码编译输出目录

3.项目拉取下来时，需要设置项目结构 指定sources，使ide识别java文件

4.生成jar包 打开项目配置 配置Artifacts type选择JAR

4.1 配置开发编译，配置Artifacts; type选择Web Application: Exploded 注意配置output layout时设置output root包含编译的class文件目录 （一般右边input去左边就好）(大概有如下目录结构：WEB-INF/classes)

5.添加tomcat：modules dependencies

6.生成war包，配置Artifacts; type选择Web Application: Archive 注意配置output layout时设置output root包含编译的class文件目录

部署到线上：把生成的war包放到tomcat的webapps目录下，启动tomcat时会自动解压











javaBean和Servlet的区别

http://blog.csdn.net/xiaoyu714543065/article/details/8735139

servlet和JSP和javabean的区别

https://zhidao.baidu.com/question/32393912.html

总结：
  (1)javabean只含有属性、set、get方法。
  (2)servlet 用于处理数据、逻辑
  (3)javabean 说笼统点是表现，显示数据
  (4)javabean、servlet、jsp分别对应M（odel）、C（ontroller）、V（iew）
举例： servlet查询数据库-----javabean保存查询结果-----jsp显示查询结果
javabean就是一个普通的Java类，里面为属性增加了getter和setter并提供默认构造。可以在多层架构的各层存在。想用它作什么都行。
而Servlet是展示层的东西……应当只在展示层存在。常作为MVC中的控制器。







