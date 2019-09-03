## HttpSession
* Session，即会话，是Web开发中的一种会话状态跟踪技术。Cookie也是一种会话跟踪技术。不同的是Cookie是将会话状态保存在客户端，而Session是将会话状态保存在了服务器端。

* 什么是会话？
    
    当用户打开浏览器，从发出第一次请求开始，一直到最终关闭浏览器，表示一次会话完成。

* Session 是所有Web开发中所使用的技术。在Java中是以Javax.servlet.http.HttpSession的接口对象的形式出现的。

    * 通过以下的两种方法获取会话对象：
    1. HttpSession getSession(boolean create)
    2. HttpSession getSession()

* 对Session域属性空间的操作
    * Session是一个专门用于存放数据的集合，这个存放数据的空间成为Session域属性空间。即域。
    * HttpSession中的三个方法：
        1. public void setAttribute(String name,Object value)
           1. 该方法用于向Session域属性空间中放入指定名称、指定值的域属性。
        2. public Object getAttribute(String name)
           1. 该方法用于从Session域属性空间中读取指定名称的域属性值。
        3. public void removeAttribute(String name)
           1. 该方法用于从Session的域属性空间中删除指定名称的域属性。


## 涨姿势啦！
* 出现问题：为什么建立servlet没有web.xml？

* 用的是servlet3.0的话，在servlet类里面有配置url的，不用原始的web.xml配置了。在servlet文件中出现@WebServlet("/someServlet")

* ctrl + k ：查找下一项对应字符串。


## Session的工作原理

    在服务器中系统会为每个会话维护一个Session。不同的会话对应不同的Session。那么，系统是如何识别各个Session对象的？如何在同一会话过程中，一直使用同一个会话对象呢？

1. 写入Session列表
   1. 服务器对当前应用中的Session是以map的形式进行管理的，这个Map称为Session列表。该Map的key为一个32位长度的随机串，这个随机串称为JSessionID，value则为Session对象的引用。  
   2. 当用户第一次提交请求时，服务端Servlet中执行到request.getSession()方法后，会自动生成一个Map.entry对象，key为一个根据某种算法新生成的JSessionID，value则为新创建的HttpSession对象。
   
2. 服务器生成并发生Cookie
   1. 在将Session信息写入Session列表后，系统还会自动将"JSessionID"作为name，这个32位随机串作为value。以Cookie形式存放到相应报头中，并随着相应，将Cookie发送到客户端。

3. 客户端接收并发送Cookie
   1. 客户端接收到这个Cookie后会将其存放到浏览器的缓存中。即，只要客户浏览器不关闭，浏览器缓存中的Cookie就不会消失。
   2. 当用户提交第二次请求时，会将缓存中的这个Cookie，伴随着请求的头部信息，一块发送到服务端。

4. 从Session列表中查找