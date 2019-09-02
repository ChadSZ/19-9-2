## Jdbc

* JDBC:Java DataBase Connectivity(Java语言连接数据库)

1. JDBC本质：
```
    JDBC是Sun公司制定的一套接口，是java.sql.*包下的。
    接口有调用者和实现者，即面向接口调用和面向接口写实现类，这都属于面向接口编程。
```

2. 为什么要面向接口编程？
```
    为了实现解耦合，降低程序的耦合性，提高程序的扩展能力；
    多态机制就是典型的面向抽象编程，(不要面向具体编程)。

    建议：
    Animal a = new Dog();
    Animal a = new Cat();
    public void feed(Animal a){ //面向父类型编程。

    }
    不建议：
    Dog a = new Dog();
    Cat a = new Cat();

```

3. 为什么SUN制定一套JDBC接口？
```
    因为每一个数据库的都有自己的底层实现原理。
    Oracle 数据库有自己的实现原理，
    MySQL 也有自己的实现原理，
    MS SqlServer 同样有自己的原理，
    ...
    每一个数据库都不同，那么每次实现数据库的数据访问会很麻烦。

```    
* **注意**：

        每一种数据库都对应的有各个版本的驱动，其存在形式是jar包。
        Jar包当中的每一个.class 文件都是JDBC接口的实现类。

        驱动不是SUN公司提供的，是各大数据库厂家负责提供的，下载驱动jar包需要去数据库官网下载。


* JDBC到底是什么？ 即 一套接口。 

4. JDBC开发前的准备工作，先从官网下载对应的驱动Jar包，然后将其配置到环境变量classpath中。 

    classpath=.;H:\java\myeclipse10.7\JDBC01\mysql-connector-java-5.1.7-bin.jar

    以上的配置是针对于文本编辑器的方式开发，使用IDEA工具的时候，不需要配置以上的环境变量，IDEA有自己的配置方式。


5. JDBC编程六步(需要背会)

    1. 第一步：注册驱动(告诉Java程序，即将要连接的是哪个品牌的Java数据库)

        1. 
            方法1：
            DriverManager 驱动管理器中有静态方法registerDriver，通过它来注册com.mysql.jdbc.Driver().
        2. 
            方法2：
            通过反射机制 Class.forName()，来放入参数"com.mysql.jdbc.Driver"，通过类加载动作，该包下的类具有静态方法可以实现注册功能，来完成驱动的注册。
    
    2. 第二步：获取连接(表示JVM的进程和数据库之间的进程打开了，这属于进程间的通信，使用完后一定要关闭)

        通过调用驱动管理器DriverManager的方法 getConnection，来获取连接，返回Connection类型的对象。

    3. 第三步：获取数据库操作对象(专门执行sql语句的对象)

        通过数据库连接对象conn，来获取数据库操作对象，Connection的方法createStatement，返回Statement类型的数据库操作对象。

    4. 第四步：执行SQL 语句(DQL DML...)

        返回的数据库操作对象stmt 可以执行数据库操作的功能，executeUpdate(insert,delete,update)以及executeQuery(select)

    5. 第五步：处理查询结果集(只有当第四步执行的是select语句的时候，才有第五步处理查询结果集)

        执行select的SQL语句之后会返回ResultSet类的结果集，我们可以通过遍历方式来查询具体的数据库表信息，先通过结果集的.next()方法，实现将当前光标向前移一行，再通过结果集的getString或者getInt等方法来获取列数据，参数有以下两种：

            1. 列索引，从1开始，
            2. 列标签名，
 
    6. 第六步：释放资源(使用完资源之后一定要关闭资源，Java和数据库之间属于进程的通信，开启之后一定要关闭)

        释放资源，即关闭打开的进程，要遵循从小到大的顺序，
        
            首先，判断是否连接未被关闭，即是否为null，要对其进行SQLException 捕捉。
            从结果集rs开始关闭，再是stmt，最后是conn，关闭连接通道后，即释放资源完毕。


### 涨姿势啦~~~
    * @SuppressWarnings("null")：告诉编译器对被批注的代码元素内部的某些警告保持静默。
    
        添加@SuppressWarings批注，以使我们不在看到该警告。

    * model:模型; module:模块

* **关于类名的动词和名词的关系认识：**

    PreparedStatement:预编译名词，即用来创造对象。
    PrepareStatement:预编译动词，即动作，进行预编译的过程。

* 关于抛出异常和捕捉异常
 
    最外层需要捕捉，而内部的异常一般都是抛出。

* 自动生成方法的头注释格式：
    
    快捷键： alt + shift + j


## 实现功能：
    1. 需求：模拟用户登录功能的实现。
    2. 业务描述：
        程序运行时，通过一个输入的入口，可以让用户输入用户名和密码，用户输入用户名和密码之后，提交信息，java 程序收集到用户信息，java程序连接数据库验证用户名和密码是否合法，
        合法：显示登录成功
        不合法：显示登录失败
    3. 数据的准备：
        在实际开发中，表的设计会使用专业的建模工具，我们可以使用PowerDesigner ，使用PD工具来进行数据库表的设计。参见脚本(user-login.sql)
    4. 当前程序存在的问题：
        用户名：fdsa
        密码：fdsa' or '1'='1
        登录成功
        这种现象被称为SQL注入。(安全隐患  黑客常用的)

    * 上述出现sql注入的原因是：该密码代码出现了代码拼接，导致代码成功发送给DBMS，DBMS进行了编译，正好将非法的信息编译进去，导致了sql语句的含义被扭曲。
    
根本原因是：用户**输入的信息中含有sql语句的关键字**，并且这些关键字参与了sql语句的编译过程，导致sql语句的愿意被扭曲，进而造成sql注入。    

* source 功能： dos命令中：source + .sql文件路径 可以直接到达该文件路径下。

* ANSI ：简体中文的意思。


## 悲观锁和乐观锁

1. 悲观锁：

    事物必须排队执行。数据锁住了，不允许并发。(行级锁：select 后面添加 for update)

2. 乐观锁：

    支持并发，事务也不需要排队，只不过需要一个版本号。