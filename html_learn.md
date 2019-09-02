## request & response
* request: 是浏览器向服务区发送；
* response: 是服务器向浏览器发送。

1. 超链接的作用：
    1. request 即请求，浏览器向服务器发送请求。
    2. response 即响应，服务器向浏览器响应请求。

2. B/S系统，每一个请求对应一个相应。

    B --请求-→ S

    S --响应-→ B

3. 用户点击超链接(href)和用户在浏览器地址栏上直接输入URL，有什么区别？

    本质上是没有区别的，都是浏览器向服务器发生请求。

    从操作上讲，超链接更方便。

* 注意：**超链接也可以提交数据给服务器，但是提交的数据是固定不变的。超链接是get请求。不是post请求。**


## form 表单
    1. 表单的作用：
        收集用户信息，表单展现后，用户填写表单，点击提交按钮提交数据给服务器。

    2. 如何绘制表单？
        form标签。

    3. 一个网页可以有多个表单form。

    4，表单最终是需要提交给服务器的，
        action属性用来指定数据提交给哪个服务器。
        action属性和超链接中的href属性一样，都可以向服务器发生请求(request)
        如：<form action="http://192.168.120:8080/oa/save">
        http://192.168.120:8080/oa/save 这是请求路径，最终提交到该路径的8080端口号上的/oa/save内。

    5. form的两个特有标签：
        
        1. submit标签
            注意，input内部的数据，必须包含name属性，才可以提交到对应请求位置。
            (value 可以不写，当没有value时，value默认值是空字符串""，会将空字符串提交给服务器。java代码得到的是 ： String username = "";)

            <input type="submit" name="username" value="jackson" />
             <input type="submit" name="userpwd" value="111" />
            提交到前面的路径位置中。

            显示：http://192.168.120:8080/oa/save?username=jackson&userpwd=111&...

* HTTP协议规定的，必须以下面的格式提交给服务器。

**格式：action?name=value&name=value&...**
    
        2. reset标签

    6. form表单method属性：
        1. get
        采用get方法提交的时候，用户提交的信息会显示在浏览器的地址栏上。

        2. post
        用post提交数据，其信息不回显示在浏览器地址栏上。

        当用户提交有敏感信息，例如，密码，建议使用post方式提交。

        method 属性不指定时，或者指定的是get时，这种情况下都是get。
        只有当method属性指定为Post时，才是post请求。

* **注意：任何的未指定post提交方式，默认都是get方式。**


## 标签

### id 属性
* id ：在html文档中，任何元素(节点)都有id属性，id属性是该节点的唯一标识，所以在同一个html文档中，id不能重复。

* 注意：表单提交数据中，只和name有关，而与id无关。

* id属性的作用：

        javascript 语言：可以对html文档中的任意节点进行增删改查，那么在增删改之前，要拿到该节点，通过id获取节点对象。
        id的存在让我们获取元素更加方便。

* html 与 id 是节点和树的关系。

        javascript 主要就是对这棵DOM(document)树上的节点进行增删改。


### div 和 span 

* div 和 span 都可以称为"图层"，图层就是一个一个盒子，div就是盒子嵌套盒子。

* 图层的作用是为了保证页面灵活的布局，最早采用的是table进行布局，但是table布局太过死板。现代的网页开发中div布局使用最多，几乎很少使用table来进行布局。

* div 和 span 是可以定位的，只要定下div的左上角的x轴和y轴即可。

* div和span的区别？
        div独自占用一行(默认)
        span不会独占一行。



* radio ：单选框，对于两个同样属性的值，即name相同，可以实现二选一，多选一的功能。

* checkbox

* label ：对label 元素点击文本标签，会触发内部控件。实现关联功能。
```
    label标签的两种使用方式：
    1. <label for="txt">姓名：</label><input type="text" id="txt" />
    2. <label>姓名：<input type="text" /></label>
```

* textarea : 文本域没有value属性，填入的即是value。

* select 下拉列表 

    内部属性：multiple 可以设置多选:multiple="multiple"
    size="2"，可以设置显示条数。

    内部标签：option :列出列表 

* file 控件 ：文件上传专用

* hidden 隐藏域 ：网页上看不到，但是表单提交会自动提交到服务器。
```
    如，<input type="hidden" id="userid" value="userid"/>
```

* readonly ：只读，使用该属性，可以提交数据给服务器；

* disabled ：只读，使用该属性，并且不能提交给服务器(即使有name)。

* maxlength ：控制输入框中的字符长度。

* aria-label : 当 input 组件获得焦点时，屏幕阅读器会读出相应的label文本。

* aria-labelledby ： 当想要的标签文本已在其他元素中存在时，可以使用aria-labelledby，并将其值为所有读取的元素的id。

* background-attachment: scoll,fixed

* type = "email" ：该类型是email类型，即必须加@。

* required :必填项

* autofocus :自动光标定位到该处

* form-control ：bootstrap 自定义的文本框类型设置。

* onblur : 当用户离开输入字段时对其进行验证。

* text-decoration : 下划线

* list-style-type: none; 可以去掉列表的前面的黑点


## class 和 id 的清晰的区别：

1. class(类)在同一个html网页页面可以无数次的调用相同的class类;ID是表示着标签的身份,所以ID在页面里也只能出现一次，并且是唯一性。
2. class是以小写句号"."开头命名，而ID是以"#"开头定义。
3. id 和 class 命名最好以英文开头。

## class = "sr-only",screen reader only
* 说明：用于为视觉残疾人员，可以"读出"屏幕图片。



## margin 的默认顺序：
* 上右下左：顺时针。

1. 如果没有left值，则使用right代替；

2. 如果没有bottom值，则使用top代替；

3. 如果没有right值，则使用top值代替。


## CSS 
    * CSS：Cascading Style Sheet 层叠样式表

    * CSS的作用：设置HTML页面中的某些元素的样式。(CSS好比化妆品)

    * 在HTML中使用CSS的三种方式：

        1. 在标签内部使用style属性来设置元素的CSS样式，这种方式即为内联定义方式(Inline Styles)
            语法格式：
            <标签 style="样式名:样式值;样式名:样式值;样式名:样式值;..."></标签>

        2. 在head标签中使用style块，这种方式称为样式块方式。
            语法格式：
            <head>
                <style type="text/css">
                    选择器{
                        样式名 : 样式值;
                        样式名 : 样式值;
                        ...
                    }
                    选择器{
                        样式名 : 样式值;
                        样式名 : 样式值;
                        ...
                    }
                </style>
            </head>

        3. 链入外部样式表文件，这种方式最常用。(将样式写到一个独立的xxx.css文件当中，在需要的网页上直接引入css文件，样式就引入了)
            语法格式：
                <link type="text/css" rel="stylesheet" href="css文件的路径"/>

        这种方式易维护，维护成本较低。
            xxx.css文件
                1. html中引入了
                2. html中引入了
                3. html中引入了
                4. html中引入了

    * 选择器：
        1. id选择器
            #id名{}
        2. 类选择器 
            .类名{}
        3. 标签选择器
            标签名{}


## list 的ul 和 li

    * list-style-type: none; 去掉列表前的黑点

    

## 边框的宽和高的计算

* div的类wrapper如下的css样式：

1. 情况：
   
        .wrapper{
            
            width:100px;
            height:100px;
            background:pink;
            padding:10px;
            border:1px solid black;
            margin:10px;
        } 
    ![通过图片来观察](https://pic2.zhimg.com/80/v2-6b3b1b4bcb52ed168ed8884834385be9_hd.jpg)

    height = 100 + 10 * 2 + 1 * 2 = 122

2. 情况：
   
        *{
        margin:0;
        padding:0;
        box-sizing:border-box;
        }
        body{
        border:1px solid blue;
        margin:10px;
        }
        .wrapper{
        width:100px;
        height:100px;
        background:pink;
        margin:10px;
        padding:10px;
        border:1px solid black;
        }

    ![通过图片来观察](https://pic2.zhimg.com/80/v2-8bb899801a91038e642a2d3eb9bb132d_hd.jpg)

    * 注意： 此时 div.wrapper 元素的宽高还是 100*100，但实际内容区的宽高变成 78*78，元素的宽高包括实际内容的宽高加上 border 和 padding 的值

3. 情况：

         *{
        margin:0;
        padding:0;
        box-sizing:content-box;
        }

    此时 div.wrapper 元素的宽高为 122*122 ，内容的宽高还是100*100

    ![通过图片来观察](https://pic1.zhimg.com/80/v2-8a30fe5465a6ef528980852ba37f5730_hd.jpg)

* 需要注意： box-sizing:

        -moz-box-sizing:border-box; /* Firefox */
        -webkit-box-sizing:border-box; /* Safari */


## position 文档流及位置属性

[具体图解请看](https://zhuanlan.zhihu.com/p/29116007)

* 文档流(普通流)：相对于窗体自上而下分成一行一行，并在每行按照自左往右的顺序排放元素，即为文档流。每个非浮动块级元素都独占一行，每个浮动元素按照规定的浮动方式浮动在行的一端，都不会独占一行，当一行无法放下该元素，则会从下一行继续按浮动方式排序。


* 包括任意的元素(块级、内联、列表元素)都可以生成子元素，在其内，形成文档流。

* 默认static ：没有定位，忽略top,bottom,left,right 以及z-index。符合文档流的排序。

* absolute : 脱离文档流，相对于一个非static 的父元素进行定位(其父元素是position:relative/fixed/absolution)。生成绝对定位的元素，仍然是相对于文档进行排列的。如果它的父级元素和爷爷级上级元素都是非position:static 属性，则会选择最近的父元素进行定位。

* relative : 没有脱离文档流，相对于它本身在文档流中的位置，进行定位的。

* fixed : 脱离文档流，相对于整个浏览器窗体而定位的，原来文档流中不存在其位置。
  




## 堆叠高度

* z-index: 设置该内容在页面的相对高度

    1. 在当前元素位置创建堆叠上下文，即告诉浏览器这里出现了堆叠，需要考虑分层。
    2. 告诉浏览器在这个堆叠上下文中，这个元素所处的分层位置。

    * 默认z-index = auto; 按照先后次序进行堆叠。
    * 子元素要服从父元素的堆叠高度。


## 矩形圆角

* 

* 题目： [有些复杂图形不能利用border-radius,我们该如何做呢？](https://zhuanlan.zhihu.com/p/34507909)


## 按钮组

1. button:

    * btn 样式

      1. btn-block(width=100%)
      2. btn-default
      3. btn-primary
      4. btn-danger
      5. btn-success
      6. btn-info
      7. btn-link
     

## form 表单

* 当点击form内部的submit按钮时，可以提交表单数据到action指定的位置。

* form表单的method="get/post" ，分别对应了http 上的get 和 post 方法。

    1. get :

        是form的默认方式。

        用于从服务器上获取数据，

        将表单中的数据按照variable = value 的形式，添加到action后的url后面，并用? 连接，而各个变量之间用"&"连接。

        get 是不安全的，因为在传输过程中，数据被放在了url中，而如今很多服务器，代理服务器或者用户代理都会将url记录到日志文件中，导致数据会被第三方看到。另外，用户可以直接看到提交的数据，一些系统的内部消息同样会出现在用户面前。

        get 传输的数据量小，因为受到url的长度限制

    2. post :
   
        向服务器传输数据，

        post是将数据放在form 的数据体中，按照变量和值对应的方式，传递到action所指向的url。

        post的所有操作对客户都是不可见的。

        post 可以传输大量数据，所以上传文件只能通过post。


## 属性及样式获取

* 如，获取<input type="text" id="btn" style="background-color: red"> 的属性和样式：

1. 获取type属性可以用： document.getElementById("btn").getAttribute("text"); //注意要获取的属性有双引号
2. 获取元素样式可以用： document.getElementById("btn").style.backgroundColor;


## jsp中写java代码有如下三种方式：

<%！ %>，这里面可以申明变量或方法，注意：这里面申明的变量是全局的

<% %>，与上面的方法相比，这个方法的局部的

<%= %>，用于输出表达式到浏览器，注意：这里面的表达式不能跟分号

## 关于page指令，我们平时见得最多的就是这样的：

1. page指令
    
    <%@page contentType="text/html;charset=gb2312" import="java.util.Date"%>

    主要用于：设置编码，导入jar包


2. include指令
   
    关于include指令，他用于引入其他jsp页面，jsp引擎会将两个jsp翻译成一个servlet，所以也称为静态引入


3. taglib指令
   
    关于taglib指令，是定义一个标签库以及其自定义标签的前缀。
    
    比如我们常用的c:foreach的使用。先导入jstl的包，然后在jsp中加入这个标签：<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>就可以使用c:foreach了


## form 表单
```java
1. action :
   1. <form action="registerServlet" method="POST">
   
        action的路径为相对路径，如果有"/"的话，说明是在web服务器的根目录。
        不带"/"，是当前访问路径的资源路径。

    2. <form action="${pageContext.request.contextPath }/registerServlet" method="POST">

        获取当前web应用的根，pageContext内置对象。对于pageContext应用最多的。
   
```


### 
