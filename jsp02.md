## jsp自定义标签
1. 获取客户端 IP 

    String ip = request.getRemoteAddr();
    out.println("ip="+ip);

    * 结果是ip=0:0:0:0:0:0:1
    (该IP默认是localhost的)

    * 如果输入的http://127.0.0.1:8080

    输出结果是ip=127.0.0.1

    * 如果输入的http://192.168.1.9:8080(ipv4的地址)

    输出结果是ip=192.168.1.9
 
2. 自定义标签

    * javax.servlet.jsp.tagext 包下有 SimpleTag 接口。

    1. doTag():核心方法。

    * 注意：**一般setxxx 方法都是服务器方法**，getxxx是客户端方法。
    
    2. getParent()
    3. setJspBody(JspFragment jspBody)
    4. setJspContext(JspContext pc), JspContext 的子类是pageContext
    5. setParent(JspTag parent)

    * SimpleTag 接口有个子类：SimpleTagSupport。
    增加了方法：
        1. getjspBody()
        2. getJspContext()

**super.doTag();** 值得注意的是super 后面可以直接调用内部的方法。

    * JspContext 类的子类JspContext 中有getRequest()方法。
        1. 调用该方法。

    * jspFragment 类中是对标签体进行操作的。


## 复制其他工程，需要改动根目录索引
* 当复制了其他工程，重新创建后，需要在新创建的工程文件右击properties → myeclipse → web → web content-root → /xxxx ，将新建的工程名写入

## 带属性(meta)的自定义标签


## 如何下载最新的jstl 的jar 包

* 进入apache.org 网站 → 向下找到tomcat → 左边的taglibs点击 → 点击download → 点击下载需要的jar包和源码


## JSTL发展过程，即系统开发模型
* 开发模型的出现是为了降低系统模块之间的耦合度。
1. 纯JSP

    数据显示和业务处理都在JSP页面完成。

    问题：代码结构混乱，数据显示和业务处理没有划分，导致代码维护相当麻烦。

2. JSP + JavaBean(Model1)
   
    业务处理交给了Javabean。

3. MVC(Model2)

    * model(javabean或者说pojo):数据承载(实体类student)和业务处理(service和dao对象专门用于处理用户请求的)
    * view(jsp)
    * controller(servlet):获取用户请求和向用户传出响应

4. ![MVC+三层架构](E:\home学习笔记\19-9-2)
   
   * 三层架构：
     * view，显示层或web层(jsp,servlet)
     * service，业务层或逻辑层(业务处理)
     * dao(或者说mapper)，持久层或数据访问层(直接操作数据库)

**为了更好的降低耦合度，在三层架构间，应采用面向抽象编程。即上层对下层的调用是通过接口实现的。下层对上层的真正服务者是下层接口的实现类。**


## 认识javabean
    1. 广义javabean，用于数据承载(student)和业务处理(例如jdbc)
    2. 狭义javabean，符合Javabean规范的java类。
       1. 该类必须是公共都，即public的。
       2. 该类必须实现Serializable接口，
       3. 该类必须具备无参构造器，不论是默认的，还是显示定义的。
       4. 该类的成员变量，必须是私有都，且都需要对其set 和 get。
    * 一般广义都数据承载的javabean都需要符合规范，即是狭义bean。

### 实现简单的学生登录和注册功能

* 完成该项目的方向有以下两种：
    1. 自上而下：(正规使用方法)
    2. 自下而上：

* 完成该项目的步骤大体如下：

1. 首先找名词：学生，构建实体类javabean，实现Serializable接口，即实现对象序列化
    
    1. 什么是对象序列化？

        object state info对象的状态信息 。也就是说，其实序列化，它是完整的保存了某一状态下的对象信息，是一个整体，而不是零散的！
        序列化的过程，就是一个“freeze”的过程，它将一个对象freeze住，然后进行存储，等到再次需要的时候，再将这个对象de-freeze就可以立即使用。
    
    2. 为什么需要序列化？

        1. 存储对象在存储介质中，以便在下次使用的时候，可以很快捷的重建一个副本。也就是When the resulting series of bits is reread according to the serialization format, it can be used to create a semantically identical clone of the original object.
        2. 便于数据传输，尤其是在远程调用的时候！

    3. 什么时候实现序列化？

        首先，序列化的目的有两个，第一个是便于存储，第二个是便于传输。我们一般的实体类不需要程序员再次实现序列化的时候，请想两个问题：第一：存储媒体里面，是否是有其相对应的数据结构？第二：这个实体类，是否需要远程传输（或者两个不同系统甚至是分布式模块之间的调用）？
        像其他int、long、boolean类型等，都是基本数据类型，数据库里面有与之对应的数据结构。既然实体类的变量都已经帮助我们实现了序列化，为什么我们仍然要显示的让类实现serializable接口呢？
        当我们在实体类声明实现Serializable接口时，再次进行观察，会发现这些类是需要被远程调用的。也就是说需要或者可能需要被远程调用，这就是序列化便于传输的用途。
    
    4. 是否一定要实现Serializable接口序列化

    

2. 再找动词，登录和注册，在servlet 中构建登录和注册功能。

    * 步骤：
        1. 接收请求参数：request
            1. 请求转发 request.getRequestDispatcher(xxx).forward(req,res);
            2. 重定向 response.sendRedirect(request.getContextPath()+xxx);
                * 两者区别：
                    请求转发是一个请求一次响应，而重定向是两次请求两次响应。
                    请求转发地址不变化，而重定向会显示后一个请求的地址
                    请求转发只能转发到本项目其它Servlet，而重定向不只能重定向到本项目的其它Servlet，还能定向到其它项目
                    请求转发是服务端行为，只需给出转发的Servlet路径，而重定向需要给出requestURI，既包含项目名！

        2. 创建Service对象，在service层中，构建校验方法checkUser()
        
        3. 调用Service对象的checkUser()，方法对用户进行验证。返回一个Student对象。可以通过该对象获取全部信息。
        4. 验证通过，则跳转到系统主页index.jsp
        5. 验证未通过，则跳转到登录页面，让用户再次输入登录信息。

3. 在Dao层，定义工具类，并且实现数据库的连接。



### 涨姿势啦~~~~

* 报异常： com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException:  No operation test.student not found.

* 已解决： 在test的库中将sms的名称改为student.

### post和get 的使用关系和不同

* GET在浏览器回退时是无害的，而POST会再次提交请求。
* GET产生的URL地址可以被Bookmark，而POST不可以。
* GET请求会被浏览器主动cache，而POST不会，除非手动设置。
* GET请求只能进行url编码，而POST支持多种编码方式。
* GET请求参数会被完整保留在浏览器历史记录里，而POST中的参数不会被保留。
* GET请求在URL中传送的参数是有长度限制的，而POST么有。
* 对参数的数据类型，GET只接受ASCII字符，而POST没有限制。
* GET比POST更不安全，因为参数直接暴露在URL上，所以不能用来传递敏感信息。
* GET参数通过URL传递，POST放在Request body中。
```
    实质上，get 和 post 是http 的两种发送请求的方法，其底层仍然是TCP/IP。所以，get和post的本质是tcp。
    大多数浏览器的url是限制在2k以内，大多数的服务器最多处理64k的url。
    get 和 post 实际上的另一大区别：
    两者产生的TCP包数量不同，
    对于get方法，浏览器会将http header 和 data 一起发出去；
    而post，会分两次发出。(注意，并不是所有的浏览器都会发送两次，firefox就是发送一次)
```  

**get提交后格式：连接地址/资源?属性名=属性值&属性名=属性值&属性名=属性值...**

**post一般应用于 form表单提交，或者ajax.**

