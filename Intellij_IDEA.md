1、快速打印输出
除了用 sout 开头快速生成，还能在后面快速生成。

2、快速定义局部变量
在字符串或者数字……后面输入 .var，回车，IDEA会自动推断并快速定义一个局部变量，不过它是 final 类型的。

3、快速定义成员变量
在值后面输入.field，可以快速定义一个成员变量，如果当前方法是静态的，那生成的变量也是静态的。

4、快速格式化字符串
在字符串后面输入.format，回车，IDEA会自动生成 String.format...语句，牛逼吧！

5、快速判断（非）空
if (xx != null)
if (xx == null)
像上面这种判断空/非空的情况非常多吧，其实可以快速生成 if 判断语句块，非空：.notnull 或者 .nn，空：.null。

6、快速取反判断
输入 .not 可以让布尔值快速取反，再输入 .if 可快速生成 if 判断语句块。

7、快速遍历集合
下面是几种 for 循环语句的快速生成演示，.for, .fori, .forr 都可以满足你的要求。

8、快速返回值
在值后面输入.return，可以让当前值快速返回。

9、快速生成同步锁
在对象后面输入.synchronized，可以快速生成该对象的同步锁语句块。

10、快速生成JDK8语句
下面演示的是快速生成 Lambda 以及 Optional 语句。


## IDEA 

1. IDEA 是用于JAVA语言开发的集成环境，也可用于其他语言。是业界认为的最好开发java的开发工具之一。尤其在智能代码助手、代码自动提示、重构、J2EE支持、Ant、JUnit、CVS整合、代码审查、创新的GUI设计等方面功能都是超常的。
2. JetBrains公司提出口号：Capable and Erogomomic IDE for JVM，即面向JVM，符合人体工程学的IDE。


## IDEA安装
1. create associations：关联文件类型，.java .groovy .kt(即如果选择.java，则以后打开.java文件，会默认选择intellij idea打开。)


## IDEA 的自维护项目文件
1. .idea
2.  xxx.iml

* 隐藏IDEA的项目配置文件，在editor的file types → ignore 下面加上
  1. .idea
  2. *.iml 


## 普通JAVA文件运行
1. 点击绿色三角
2. 右击，run main


## IDEA快捷键
1. ctrl+d 向下复制某行内容
2. ctrl+y 删除某行内容
3. alt+enter 导包以及添加变量
4. rename 重命名，选中其中的某个类 shift+F6
5. 注释，同eclipse
6. 为某一部分代码加 if / for / while / try catch ... 都可以通过 ctrl+alt+t
7. 添加getter && setter：alt+insert

* 修改快捷键的基于eclipse方式：keymap中设置。


## IDEA创建模板
1. live templates中创建
   1. live template
   2. templates group
      1. 创建分组
      2. 添加模板
      3. 设置模板缩写(abbreviation , description , 模板text , define 模板试用范围)
      4. 即可使用模板 
   

## 模板的试用
1. 对模板的内容简单修改
   1. file and code templates 对不同组件模板内容修改
2. 注释模板
   1. 在file and code templates 中的includes，有file header 可以设置注释模板
        ```
         /**
         *  @Author: 
         *  @Date: ${DATE}
         *  @Description: ${PACKAGE_NAME}
         *  @version: 
         */
         ```
    2. 方法注释模板 
        ```
         /**
         *  功能描述：
         *  @param:$param$
         *  @return:$return$
         *  @author:$user$
         *  @date:$date$ $time$
         */
        ```
   

## 创建web工程
1. java enterprise
2. sdk(software development kit):软件开发包
3. java ee version
4. app server 服务器选择
5. web application版本选择
6. 设置web项目名称
7. 即可应用web工程


## 去掉参数名称标记(hints)
* 在editor的general中有appearance，去掉show parameter name hints的勾


## 配置项目访问路径
* edit configurations
* url 以及 http port
* deployment设置
1. 默认访问路径 / 
2. 修改访问路径


## 创建Maven项目

### Maven

* 发展：Make->Ant->Maven->Gradle

1. 配置maven
   1. 在系统变量中设置maven的路径
   2. 设置path：%M2_HOME%\bin
   3. 检验安装是否成功：mvn -version
2. maven在idea中的配置
   1. settings 中设置maven的home directory 和 setting files
3. 创建maven项(鼠标右击才可以选中archetype)
   1. quickstart：快速创建
   2. site：聚合项
   3. webapp：maven普通web项
4. 配置项目构建插件
   1. -DarchetypeCatalog=internal(在build tools → maven → runner → VM Options)
   2. 项目删除：
      1. remove module
      2. delete pom
5. 工程结构认识及补齐
   1. sources：原代码存放
   2. tests：测试代码
   3. resources：资源文件
   4. test resources：测试资源文件


## Maven项目实现业务并启动Tomcat
1. 首先要对pom文件进行添加坐标
2. pom.xml中使用junit，版本是4.12
   1. 如果出现 junit not found，可以在工程结构中的librares中添加junit包，
      1. hamcrest-core-1.3.jar
      2. junit-4.12.jar
3. 如果servlet-api在tomcat或容器中已经包含了，那么告诉maven，这个java包不用加入，否则，会出现两套java包。

### 理解Maven中的GroupId和AritifactID
```
GroupId和ArtifactId被统称为“坐标”是为了保证项目唯一性而提出的，如果你要把你项目弄到maven本地仓库去，你想要找到你的项目就必须根据这两个id去查找。

　　GroupId一般分为多个段，这里我只说两段，第一段为域，第二段为公司名称。域又分为org、com、cn等等许多，其中org为非营利组织，com为商业组织。举个apache公司的tomcat项目例子：这个项目的GroupId是org.apache，它的域是org（因为tomcat是非营利项目），公司名称是apache，ArtifactId是tomcat。
　　
　　比如我创建一个项目，我一般会将GroupId设置为cn.mht，cn表示域为中国，mht是我个人姓名缩写，ArtifactId设置为testProj，表示你这个项目的名称是testProj，依照这个设置，在你创建Maven工程后，新建包的时候，包结构最好是cn.zr.testProj打头的，如果有个StudentDao[Dao层的]，它的全路径就是cn.zr.testProj.dao.StudentDao
```

4. 配置servlet
   1. doget dopost
   2. web.xml中设置servlet-mapping
      1. servlet-name
      2. url-pattern
         ```
        <servlet-mapping>
        <servlet-name>Servlet</servlet-name>
        <url-pattern>/addUser</url-pattern>
        </servlet-mapping>
        ```
5. 启动maven的tomcat插件
* 注意：tomcat8.x不需要设置插件依赖
``` 
举例：<dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>3.0-alpha-1</version>
        </dependency>
通过插件启动tomcat的时候，报错，里面有一段是这样的：Caused by: java.lang.LinkageError: loader constraint violation: loader
```
* 解决方法：添加<scope>provided</scope>，因为provided表明该包**只在编译和测试的时候用**，所以，当启动tomcat的时候，就不会冲突了.
* 而compile，**在编译，测试，运行阶段都需要**这个artifact对应的jar包在classpath中。


## 创建maven的聚合工程
1. 项目结构
   1. manager(工程创建，内部是模板module创建)
      1. manager-pojo(jar)
      2. manager-dao(jar)
      3. manager-service(jar)
      4. manager-web(war)
   2. 依次创建上述的各项工程，完成整套聚合工程的创建。

2. 在pom.xml中添加依赖
   1. 配置manager的依赖

### manager注入
      ```
  <!--对依赖的坐标版本做集中管理-->
  <properties>
    <junit.version>4.12</junit.version>
    <spring.version>4.1.3.RELEASE</spring.version>
    <mybatis.version>3.2.8</mybatis.version>
    <mybatis.spring.version>1.2.2</mybatis.spring.version>
    <mysql.version>5.1.32</mysql.version>
    <druid.version>1.0.9</druid.version>
    <jstl.version>1.2</jstl.version>
    <servlet.version>2.5</servlet.version>
    <jsp.version>2.0</jsp.version>
    <tomcat.version>2.2</tomcat.version>
  </properties>
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>${junit.version}</version>
      </dependency>
      <!--mybatis-->
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${mybatis.version}</version>
      </dependency>
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>${mybatis.spring.version}</version>
      </dependency>
      <!--mysql-->
      <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>${mysql.version}</version>
      </dependency>
      <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>${druid.version}</version>
      </dependency>
      <!--spring-->
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>

      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>${spring.version}</version>
      </dependency>
      <!--jsp&servlet-->
      <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>${jstl.version}</version>
      </dependency>
      <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>${servlet.version}</version>
      </dependency>
      <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jsp-api</artifactId>
        <version>${jsp.version}</version>
      </dependency>
    </dependencies>
  </dependencyManagement>
  <build>
    <!--配置资源拷贝插件-->
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.xml</include>
          <include>**/*.properties</include>
        </includes>
      </resource>
    </resources>
    <!--配置tomcat插件-->
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>${tomcat.version}</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
      ```
### mapper
* **mapper主要用于操作数据库**
  
1. mapper注入
```

   <dependencies>
        <dependency>
            <groupId>com.bjsxt</groupId>
            <!--mapper依赖于pojo-->
            <artifactId>manager-pojo</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <!--因为版本是集成关系，所以只需要有父版本即可，不需要再加入版本信息-->
            <!--<version>${mybatis.version}</version>-->
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <!--<version>${mybatis.spring.version}</version>-->
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connect-java</artifactId>
            <!--<version>${mysql.version}</version>-->
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <!--<version>${druid.version}</version>-->
        </dependency>
    </dependencies>
```
2. 创建mapper接口与映射文件
3. 测试mapper
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class ManagerTest {
    @Autowired
    private UsersMapper usersmapper;

    @Test
    public void insertUserTest(){
        Users users = new Users();
        users.setUserAge(20);
        users.setUserName("admin");
        this.usersmapper.insertUser(users);
    }
}
```


### Service是与业务有关的
```

```

* 注意
 ```<name></name> 标签中的名称是用作插件名称的。可以去掉```


 ## 下载不同版本的maven插件
[maven不同版本](https://archive.apache.org/dist/maven/maven-3/)
[maven版本下载步骤](https://blog.csdn.net/dwfyzf/article/details/78981223)

* 注意：
```
bin.tar.gz是适用于linux、MacOsX系统的二进制文件

bin.zip是适用于windows的二进制文件

src.tar.gz是linux下的源码

src.zip是windows的源码
```


## LifeCycle 和 下载的plugins
1. 区别：
   1. lifecycle是完全依赖于maven自身的命令
   2. plugin 完全依赖于项目中配置的pom插件


## Tomcat插件的使用
1. 第一种方式
   1. 在子项目中配置tomcat插件需要对所有的聚合工程进行安装
2. 第二种方式
   1. 在父项目中配置tomcat插件不要求所有的工程，必须要安装。


### 实现用户添加业务
1. 创建业务层
```
接口：
public interface IUsersService {
    void addUsers(Users users);
}

接口实现类：
@Service
public class UsersServiceImpl implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public void addUsers(Users users){
        this.usersMapper.insertUser(users);
    }
}

```

2. 创建Controller
```
@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return  page;
    }
}

@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @RequestMapping("/addUsers")
    public String addUser(Users users){
        this.usersService.addUsers(users);
        return "ok";
    }
}
```

3. 创建JSP
```
<body>
    <form action="/user/addUser" method="post">
        姓名：<input type="text" name="username"> <br>
        年龄：<input type="text" name="userage"><br>
        <input type="submit" value="okok">
    </form>
</body>
```


## IDEA中的项目打包
1. maven打包
   1. 通过Maven的命令package，可以打包到manager-web文件夹下的xxx.war包
   2. 在打包过程中，会默认生成target目录。
2. 打包非maven
   1. 如java包
  * 在工程结构中修改(project structure)
  * artifacts → 改名 → module → ok apply


## IDEA中其他常用功能
1. IDEA中SVN使用
   1. 在上传Subvision时，我们可以通过 在version control中的ignored files来进行忽略一些目录，如target等。
   2. 设置上传路径 VCS -> share target -> repository location -> 输入地址。
   3. 注意：在version control 中的subversion 使用 use command line client 去掉勾 √ 
   4. 右击工程文件，点击subversion -> commit directory 提交，默认提交所有的文件，不包括ignored files的文件。
   5. 从远程仓库检出到本地：subversion -> checkout -> 
   6. 更新代码：subversion -> update directory
   7. 恢复原有版本：revert
   8. compare with the same repository version / compare with latest repository version 比较相同版本和最新版本。
   9. show history 显示当前文件的历史记录


2. 使用git管理代码
   1. 首先，要脱离svn版本控制的管理。
      1. 找到manager文件下的隐藏文件.svn，删除它。
      2. 在manager中的.idea文件中的，vsc.xml文件中，将``<component>``删除。
   2. vcs中，选择create git repository 创建本地git仓库。
      1. 在settings ->git -> path to git executable -> 选择当前git.exe的路径。
      2. 右击项目manager，选择git -> add(添加到临时区域)
      3. git -> commit repository
      4. 将代码上传到github中，git -> repository -> push ， 填入远程仓库的名称和地址
      5. 代码下载下来，即pull


## IDEA 的Debug功能


## IDEA 的REST CLIENT


## IDEA 的远程LINUX管理工具


