## AJAX--李南江

## Web服务器搭建

1. WAMPServer软件
   1. W：Windows操作系统
   2. A：Apache，世界第一服务器软件，简单速度快，性能稳定
   3. M：Mysql 开源免费都数据库软件，体积小，速度快，使用成本低
   4. P：PHP 超文本预处理器，直接将代码嵌入HTML文档中执行，简单易学
   
2. 安装WAMPServer [安装包下载](https://blog.csdn.net/weixin_41736188/article/details/87924875)
   1. 安装完成后，打开等带右下角标志变成绿色，即可(红色 → 黄色 → 绿色)
   
3. 安装PHPStorm [下载地址](https://www.0daydown.com/04/862061.html)，然后关注微信公众号搜索破解激活码
   1. ctrl+alt+insert → 新建php
      1. php基本结构：<?php ...... ?>
   
      2. php两种注释
         1. //
         2. /**/
   
      3. 定义变量
         1. JS中的定义变量：var num = 10;(变量名字母下划线开头，数字)
         2. php中定义变量：$num = 10;(字母下划线开头，数字)

      4. 打印内容
         1. JS中：console.log();
         2. echo $num;
         * 注意点：后端编写都代码不能直接运行，只能放到服务器对应的文件夹下，通过服务器运行，如何通过服务器运行：通过IP地址找到服务器对应的文件夹，然后再找到对应的文件运行 

      5. 定义集合，数组，字典(对象)
         1. JS中：var arr = [1,3,5];
         2. $arr = array(1,3,5);
         3. print_r($arr); 可以输出数组
         4. echo $arr[i]; 可以输出数组元素

         5. $dict = array("name"=>"xiaoming","age"=>"18");
         6. print_r($dict);
         7. echo $dict["name"];

      6. 分支循环语句 if/switch/三目/for/while
         1. 注意：for循环没有length，用的是count($arr)，可以获取数组长度


## get

**get提交后格式：连接地址/资源?属性名=属性值&属性名=属性值&属性名=属性值...**

* 超全局变量的简单应用：
  * $_GET
1. 表单发送get
2. get请求将数据提交到远程默认服务器www中。
3. 通过$_GET获取数据。(获取方式类似字典)

## post

* $_POST

* 注意：如果是get请求会将提交的数据拼接到URL后面，?属性名=属性值&属性名=属性值...
* 如果是post请求会将提交的数据放到请求头中。

## GET请求和POST请求的异同
1. 相同点：
   1. 都是将数据提交到远程服务器
2. 不同点：
   1. 提交数据存储位置不同(URL后面，数据请求头中)
   2. 提交数据大小限制不同
      1. GET请求对数据有大小限制
      2. POST请求对数据没有大小限制
3. GET和POST请求应用场景
   1. GET请求用于提交非敏感数据和小数据
   2. POST请求用于提交敏感数据和大数据


## 文件上传post
1. 注意：上传文件，需要通过post方法，
2. 后端获取前端上传文件：需要遵循以下几步：
   1. 获取文件对应的字典
   2. 获取文件对应字典的上传属性的名称
   3. 获取上传文件保存的临时路径(PHP中文件默认会上传到一个临时目录，接收完毕之后会自动删除)
   4. 保存文件

## 上传大文件
* 默认请客下服务器对上传文件的大小是有限制都，如果想修改上传文件的限制可以修改php.ini文件
    
        file_uploads = 0n               ;是否允许上传文件0n/off 默认是0n
        upload_max_filesize = 2048M     ;上传文件的最大限制
        post_max_size = 2048M           ;通过post提交的最多数据

        max_execution_time = 30000  ;脚本最长的执行时间 单位为秒
        max_input_time = 30000      ;接收提交的数据的时间限制 单位为秒
        memory_limit = 2048M        ;最大的内存消耗

* 路径为 → D:\wamp64\bin\apache\apache2.4.39\bin 找到php.ini 对其修改上述信息
* 文件保存的名称不能使用中文，需要改为英文。


## ajax
1. 什么是AJAX
   1. AJAX是与服务器交换数据并更新部分网页的艺术，在不重新加载整个页面都情况下使用AJAX。
2. AJAX的创建步骤
   1. 创建异步对象
      1. variable = new XMLHttpRequest();
   2. 设置请求方式和请求地址，调用open方法
      1. method:请求的类型：get或post
      2. url:文件在服务器上的位置
      3. async:true(异步)，false(同步)
   3. 发送请求
      1. 调用异步对象的send方法
   4. 监听状态的变化
      1. 调用对象的onreadystatechange来监听状态变化
      2. 存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。

         状态变化有如下几种情况：
         1. 0：请求未初始化
         2. 1：服务器连接已建立
         3. 2：请求已接收
         4. 3：请求处理中
         5. 4：请求已完成，且相应就绪

         1. http状态码：[http状态码连接](https://baike.baidu.com/item/HTTP%E7%8A%B6%E6%80%81%E7%A0%81/5053660?fr=aladdin)
         
   5. 处理返回结果


### IE浏览器问题
* XMLHttpRequest对象不能在IE几种中使用：
```
      var xmlhttp;
      if(window.XMLHttpRequest){
         // code for IE7+, Firefox, Chrome, Opera, Safari
         xmlhttp = new XMLHttpRequest();
      }else{
         // code for IE6, IE5
         xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
      }
```
1. 在IE浏览器中，如果通过AJAX发送GET请求，那么IE浏览器认为同一个URL只有一个缓存结果

* 解决上述问题可以利用以下两种地址添加唯一的ID： "请求地址?t="+
  1. Math.random()
  2. new Date.getTime()




## 涨姿势啦！
   1. 快速打出console.log("请求中断");
      1. "请求中断".log 就可以出来了
   2. phpstorm快捷输入：div.abc → tab键 → 可以快速出现```<div class="abc"></div>```
   3. 快速复制整行内容：ctrl+D





