# Mybatis
Mybatis的一些基本搭建.
1、在IDEA下创建一个新的Maven工程。

2、在resources下创建登录数据库所需要的配置文件，包括db.properties(数据库登录信息)，mybatis-config.xml(连接数据库的环境配置)

3、在数据库中创建项目所需要的表。

4、在java文件夹下创建一个pojo包，用来创建与数据库表对应的实体类，并且对属性进行封装。

5、在resource文件夹下创建实体类对应的配置文件xxxMapeer.xml，在其里面编写sql语句。

6、在java文件夹下创建接口类，接口名字与配置文件同名，接口利用动态代理来调用Mapper配置文件中对应的数据库操作方法。

7、在Test/java文件夹下创建测试类，用来调用数据库方法对数据库的内容进行模拟查询。

