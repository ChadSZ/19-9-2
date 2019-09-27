## null NaN undefined
1. 区别：
    1. 类型不同
        null 是Object
        NaN 是Number
        undefined 是undefined

    2. null 与 undefined 可以等同
        alert(null == NaN); //false
  		alert(null == undefined); //true
  		alert(NaN == undefined); //false
    
    3. 在JS当中有两个比较特殊的运算符
    
        1. ==(等同运算符)
            只判断值是否相等

        2. ===(全等运算符)
            既判断值是否相等，又判断数据类型是否相等
            alert(null === NaN); //false
            alert(null === undefined); //false
            alert(NaN === undefined); //false


## JS 的常用事件
1.
        blur
        focus
2. 
        click
        dbclick
3. 
        keydown
        keyup
4. 
        mousedown
        mouseover
        mousemove
        mouseout
        mouseup
5. 
        reset
        submit
6.
        change：下拉列表项改变，或文本框中内容改变
        select：文本被选定
        load：页面加载完毕，(整个HTML页面全部加载完毕之后发生)

### 事件句柄
* 任何一个事件都会对应一个事件句柄，事件句柄是在事件前加on。即 onxxx。

    onxxx 这个事件句柄出现在一个标签的属性位置上。(事件句柄以属性的形式存在)

### 回调函数(callback)
* 对于程序来说，sayHello函数被称为回调函数(callback函数)
* 回调函数的特点：自己把这个函数代码写出来了，但是这个函数不是自己负责调用的，由其他程序调用该函数。

* 注意：**正向调用(调用函数者的动作) && 回调函数(相对于函数本身，仅由本身注册)**

即为注册事件的第一种方式。

### 注册事件第二种方式
* 使用纯JS代码完成事件的注册

1. window.alert(); window 指的是整个页面窗口
2. document.getElementById(); document 指的是文档 通过该命令获取操作id的对象。

**注意：加载过程，是先进行页面的加载注册事件，然后在点击过程，触发事件过程。**

```
window.onload = function(){
    document.getElementById("incident").onclick = function(){
        alert("事件执行顺序");
    };
}
页面加载过程中，将匿名函数注册给了load事件。
页面加载完毕后，load事件才发生，此时执行回调函数。

```

3. 通过事件，来改变属性，**一个节点对象中只要有的属性都可以"."**
```
window.onload = function(){
    document.getElementById("mybtn").onclick = function(){
        
        // 一个节点对象只要有的属性都可以通过"."来操作
        document.getElementById("mytxt").type = "checkbox";
    }
}
如type属性，click属性，key,style 等等都是input 的属性。都可以通过"."来操作。
```


## 涨姿势啦！
* JVM Java 内存结构
* JMM Java 内存模型(java memory model)
* SQL 优化


## void 运算符

* void 运算符的语法：void(表达式)

    运算原理： 执行表达式，但不返回任何结果。

* 注意： 
```
<a href="">超链接</a>
    当超链接href中为空时，则跳转到当前页面。
```

* javascript:void(0) 

    其中javascript:是告诉浏览器后面是一段js代码，
    javascript是不能省略的。


## JS 控制语句：
* if, switch, for, while, do while for...in, with

  		var arr = [false,0,1,true,"aabbc",'w'];
/*     	for(var i=0;i<arr.length;i++){
    		alert(arr[i]);
    	} */
    	
    // for...in
    //	for(var i in arr){
    		// alert(i);
    //		alert(arr[i]);
    //	}
    // for...in 可以遍历对象的属性
    	User = function(username,userpwd){
    		this.username = username;
    		this.userpwd = userpwd;
    	}
    	
    	var u = new User("张三","李四");
    	//alert(u.username+","+u.userpwd);
    	//alert(u["username"]+","+u["userpwd"]);
    	
    	for(var attr in u){
    		alert(attr);
    		alert(u[attr]);
    	}
    	alert(u.username);
    	alert(u.userpwd);
    	with(u){
    		alert(username+","+userpwd);
    	}


## JavaScript 包括以下三块：ECMAScript,DOM,BOM

* ECMAScript:ECMA 国际制定的标准化的脚本程序语言(ES规范/ECMA-262标准)，JS的核心语法，Javascript和JScript都遵循。

* DOM:文档对象模型(Document Object Model) 对文档中的节点进行增删改的操作，HTML文档被当做一棵DOM树，DOM是有规范的，W3C制定。

    var domObj = document.getElementById("id");

* BOM:浏览器对象模型(Broswer Object Model) 关闭浏览器、打开一个新的浏览器窗口、后退、前进、浏览器地址栏上的地址等，都是BOM编程。

* DOM 和 BOM 的区别和联系？

    1. BOM 的顶级对象是: window
    2. DOM 的顶级对象是: document
    3. 实际上BOM包括DOM

* **this应用**

    **this是当前节点对象(document.getElementById("id"))**

```
  	<!-- 以下代码中的this代表的是当前input节点对象，this.value就是这个节点对象的属性 -->
  	<!-- <input type="text" onblur="alert('失去焦点')"/> -->
  	<input type="text" onblur="alert(this.value)"/>
```

## innerHTML & innerText

* 两者有什么区别？

    1. 两者都是设置元素内部内容。
    2. innerHTML 是将设置的内容视作HTML代码来解释并执行；而innerText会将设置的内容作为普通文本来处理。


## 正则表达式(Regular Expression)

1. 正则表达式主要用在字符串格式匹配方面。

2. 正则表达式实际上是一门独立的学科，在Java语言中支持，C语言也支持，Javascript中也支持。大部分变成语言都支持正则表达式，正则表达式最初使用在医学方面，用来表示神经符号等，目前使用最多的是计算机编程领域，用作字符串格式匹配，包括搜索方面等。

3. 正则表达式，需要掌握哪些内容？
```   
    符号认识，
    编写，
    理解。
    在Javascript中怎么创建正则表达式对象。
    在Javascript中，正则表达式对象有哪些方法？
    从网上找到自己需要的正则表达式，并测试有效性。
```

4. 常用的正则表达式有哪些？

        . 匹配除换行符以外的任意字符
        \w 匹配字母或数字或下划线或汉字
        \s 匹配任意的空白符
        \d 匹配数字
        \b 匹配单词的开始或结束位置
        ^ 匹配字符串的开始
        & 匹配字符串的结束

        * 重复零次或更多次
        + 重复一次或更多次
        ? 重复零次或一次
        {n} 重复n次
        {n,} 重复n次或更多次
        {n,m} 重复n到m次

        \W 匹配不是字母、下划线、汉字的任意字符
        \S 匹配不是空白符的任意字符
        \D 匹配任意非数字
        \B 匹配不是单词的开始或结束的位置
        [^x] 匹配除了x意外的任意字符
        [^aeiou] 匹配除了aeiou这几个字母意外的任意字符

5. 正则表达式中的小括号() 优先级较高
 
6. 正则表达式认识

        [1-9] 表示1-9任意数字
        [A-Za-z0-9] 表示A-Z、a-z、0-9 中的任意字符
        [A-Za-z0-9-] 表示A-Z、a-z、0-9、- 中的任意字符

7. 怎么创建正则表达式对象，怎么调用正则表达式对象的方法？

    1. 创建方式1
        var regExp = /正则表达式/flags;
    2. 创建方式2
        var regExp = new RegExp("正则表达式","flags");

    * 关于flags:
            g: 全局匹配
            i: 忽略大小写
            m: 多行搜索(ES制定之后出现)
            当//中是正则表达式时，不能使用m；当其中是普通字符串时，才可以使用过m。
        ss11_.@13a.-.aa.


## JS的trim() 

* 去除文本前后空白

* 注意：低版本不能使用trim()

        // 低版本的IE浏览器不包括去除空白的trim
        // 可以对String类扩展一个全新的trim函数


## 强大的 prototype
**通过prototype 可以重写方法。**

```
String.prototype.trim = function(){
    // 低版本的IE浏览器不包括去除空白的trim
    // 可以对String类扩展一个全新的trim函数
    return this.replace(/^\s+/,"").replace(/\s+$/,"");
}
```


## String类型

1. 在JS中字符串使用单引号还是双引号都是没有问题的。

    var s1 = 'abcdef';
    var s2 = "abcd";

2. 在JS当中，怎么创建字符串对象呢？

    1. var s = "abc";
    2. 使用JS内置的支持类String：var s2 = new String("abc");

    需要注意的是：String是一个内置的类，可以直接用，String 的父类是Object.

3. 无论是小string 还是 大 String，他们的属性和函数都是通用的。

4. 关于String类型的常用属性和函数
* 常用属性：
   
    length 获取字符串长度

* 常用函数：

        indexof：获取字符串在当前字符串第一次出现的索引。
        lastIndexOf：获取字符串在当前字符串最后一次出现的索引。
        replace：替换，可以使用全局替换，g，i，m
        substr：截取子字符串
        substring：截取子字符串，不包括endIndex
        toLowerCase：变小写
        toUpperCase：变大写
        split：拆分字符串


## Object 类型
1. Object类型是所有类型的超类，自定义的任何类型，默认继承Object。
2. Object类包括哪些属性？

    1. prototype属性(常用的，主要是这个)：作用是**给类动态的扩展属性和函数。**
    2. constructor属性

3. Object类包括哪些函数？

    toString()
    valueOf()
    toLocaleString()

4. 在JS当中定义的类默认继承Object，会继承Object类中所有的属性以及函数。即，自己定义的类同样具有prototype等属性。

5. 在JS中怎样定义类？怎样new对象？


## JS中内置的支持类：Date
// 关于JS中内置的支持类：Date，可以用来获取时间/日期
    	var nowTime = new Date();


## 涨姿势啦~

**在JS中声明全局变量，前面不需要加var 即可。**

* HTML 和 XML 有一个父亲：SGML (标准通用标记语言)


## JS中内置支持类：Array


## 总结：有哪些方法可以通过浏览器向服务器发送请求？

    1. 表单form的提交
    2. 超链接
    3. document.location
    4. window.location
    5. window.open("url")
    6. 直接在浏览器地址栏上输入URL，然后可以访问服务器。(同样可以手动提交数据，name=value&name=value&...，动态提交)

    以上的所有方式都可以携带数据给服务器，只有通过表单提交数据才是动态的(第六种也是可以的)。



## JSON 


