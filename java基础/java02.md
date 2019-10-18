## 前景回顾
1. 自定义标签(client端访问,标签属性,标签体,if,foreach)

2. 自定义标签库打包发行

## JSTL 

JSTL 定义了5个标签库：

1. 核心标签库：主要用于完成基本的逻辑运算。
2. 格式化标签库：主要用于完成日期、数字的格式化显示。
3. EL 函数标签库：定义了若干EL 函数。
4. SQL 操作标签库：完成SQL 操作。不使用了。对于SQL操作，已经完全由Java代码完成。
5. XML 操作标签库：完成XML 操作。不用了，理由同上。

* 使用核心标签库，需要在页面通过taglib 命令导入标签库。



## java实现小程序
### 设计一个飞行类游戏
1. 使用到的库：
   1. javax.swing
   2. java.awt



## IO流
### IO流核心
1. 五类三接口
   1. File
   2. InputStream
   3. OutputStream
   4. Reader
   5. Writer
   6. Closeable
   7. Flushable
   8. Serializable
2. **一切以程序为中心**
   1. 数据源到程序，读进来，即InputStream，和Reader
   2. 程序到目的地，写出去，即OutputStream，和Writer
3. 流分类
   1. 节点流
      1. 可以直接从数据源或目的地直接读写数据
   2. 处理流(包装流)
      1. 不直接连接数据源或目的地，是其他流的封装
      2. 主要是为了简化操作和提高性能
   3. 节点流和处理流的关系
      1. 节点流位于IO操作的一线，所有操作都需要通过节点流
      2. 处理流可以对其他流进行处理，提高效率和灵活性
   4. 按方向分：输入流和输出流
   5. 按功能分：节点流和处理流
   6. 按数据分：字节流和字符流
      1. 字节流：按照字节读取数据(InputStream,OutputStream)
      2. 字符流：按照字符读取数据，因为文件编码的不同，从而有了对字符进行高效操作的字符流对象。
      3. 原理：底层仍是字节流。只不过字符流通过了字符集这些类似字典的东西来形成的。
      4. 字符集的认识
         1. GBK
         2. UTF-8
         3. Unicode
         4. ...


## API学习
1. 继承体系
2. 构造器有无
3. 方法名，形参，返回值类型，是否静态


### File
1. File，其本质是java通过虚拟机对硬件构建的。

2. 自带的文件分隔符：File.separator为 "\"，
   1. 所以我们在java中使用"\"，需要转义，即 "d:\\abc\\cde\\xxx"。
   2. 我们一般直接通过"d:/abc/cde/xxx"。
   3. 或者通过拼接："d:"+File.separator+"abc"+File.separator+"cde"+File.separator+"xxx"
   4. 相对路径的字符串为："src/xxx/xxxa/xxxb"

3. 构建File对象
   1. new File(path);
   2. new File("parent path","child path");
   3. new File(new File(path)对象,"child path");

4. 路径 path
   1. 绝对路径：指对于整个盘符来说，getAbsolutePath()
   2. 路径获取，getPath()，关键是看File(path)内构建的是绝对路径还是相对路径，输出是输入的路径
      1. 了解：**System.getProperty("user.dir");**用于获取工程文件路径
   3. 构建一个不存在的路径，其实质是JVM对硬件构建的，并不存在

5. File文件的其他信息
   1. 文件信息：length()，getName()，getParent() ，getParentFile()
   2. 判断：exists(),isFile(),isDirectory()
   3. 创建文件：createNewFile()：不存在，则创建新文件；存在，则返回false
   4. 删除文件：delete()
   5. 创建文件夹注意点：对于**名称为con,com3...的文件夹不允许创建**，报错：系统找不到指定的文件
   6. **4096？**
   7. **包装类不能自增自减！**

6. Dir的创建及其信息
   1. 创建文件
      1. mkdir()：文件夹不存在，则创建文件夹；存在返回值false
      2. mkdirs()：不论是否存在文件夹，创建文件夹
   2. 文件的list
      1. list()：列出所有文件夹下的文件
      2. listFiles()：列出所有该文件夹下的绝对路径的文件
      3. listRoots()：列出所有盘符

## 涨姿势：递归
1. 递归：方法自己调用自己
2. 递归头：何时结束递归
3. 递归体：重复调用


## 文件编码
1. java字符使用16位的双字节存储，但是在实际文件存储的数据有各种字符集。乱码的产生源于此。
2. 编码与解码
   1. 字符 -> 字节 ：编码 encoding
   2. 字节 -> 字符 ：解码 decoding
3. 字符集
   1. US-ASCII：英文ASCII
   2. ISO-8859-1：拉丁字符，包括中文等
   3. UTF-8：变长Unicode(1-6字节)
   4. UTF-16BE：定长，高字节低地址，大端
   5. UTF-16LE：低字节低地址，小端
   6. UTF-16：文件开头指定大端还是低端，如FF FE 即小端；FE FF即大端
   7. ANSI
      1. 是普遍的字符集，其中包括了多个国家的编码集，如GB2312，GBK(中文：2个字节表示一个字符)，日文的Shift_JIS等
   8. Unicode：常用两个字节表示一个字符
      1. 那么会产生资源浪费，如每一个英文单词作文一个字符，会浪费一个字节的空间。所以产生了变长的UTF-8等。
   9. 联通字符的问题，联通字符会被自动转为utf-8格式

4. 乱码
   1. 字节数不够
   2. 字符集不对应


## myeclipse设置编码方式：
general -> workspace -> text file encoding


## 流的注意点
1. **以程序为中心**，判断输入流输出流，reader和write。
2. 可以通过字符流的，必然可以通过字节流。
3. OutputStream 相对于 InputStream，多实现了接口Flushable，可以通过其减少缓存。

## IO流使用步骤
1. 创建源
   1. File src = new File("abc.txt");
   2. 注意：在输入流，读取时，不会创建文件；在输出流，写入数据时，文件不存在，则自动创建。

2. 选择流

3. 操作流
   1. 通过流读取数据：
      1. read()：通过流读取单个byte，读取数据
      2. read(byte[] b)：读取最多b.length长度字节的数据，并存入数组b中

   2. 通过流写入数据：
      1. write()：通过流写入单个数据
      2. write(byte[] b)：每次写入b长度的数据
      3. write(byte[] b,begin,end)：通过流在指定的文件begin位置，写入指定偏移量的数据
      4. 将io流对象进行flush()
   
   3. 注意：在写数据的时候，使用OutputStream，有文件，则使用该文件；没有，则创建新的文件。OutputStream(File dest,append)：**当append为true时，在文件最后加入数据。**
4. 读取字符串，
   1. 创建为字节数组，通过使用getBytes()，方法，转为字节数组
   2. 通过字节数组流读取字符串，toByteArray()方法，转为字节数组
   3. 创建为字符数组，通过toCharArray()，方法，转为字符数组
5. 数组转为字符串，
   1. 创建String对象，new String(flush,0,len)


## 字符流
1. FileReader：通过字符的方式读取文件，仅适合字符文件
2. FileWriter：通过字节的方式写出或追加数据到文件中，仅适合字符文件
3. 操作
   1. 类似于字节流
   2. 注意：在字符输出流中，有三种写入方法：
      1. 通过.toCharArray()，获取字符数组，然后在写入
      2. 直接写入，字符串内容。
      3. 通过.append(String str).apend(String str2) ... ，不断加入字符串，较于第二种更加灵活。
4. 实现字符的复制功能。


## 字节数组流
* 注意：不需要释放资源，由JVM的gc释放。
1. 源头换成字节数组
2. 字节数组不需要关闭，close无效的
3. **任何数据都可以转为字节数组**
4. 字节数组不要太大

5. 字节数组输出流
   1. 创建源：内部维护
   2. 选择流：不关联源
   3. 操作(写出内容)
   4. 释放资源：不需要


## java---可变参数
1. 适用于参数个数不确定，类型确定的情况，java把可变参数当做数组处理

2. 可变参数只能位于最后位置

3. 调用使用了可变参数的方法时：
   1. 可以不写参数，即传入空参；
   2. 可以直接在里边写入参数，参数间用逗号隔开；
   3. 可以传入一个数组；

4. 拥有可变参数的方法可以被重载，在被调用时，如果能匹配到参数定长的方法则优先调用参数定长的方法。
5. 可变参数可以兼容数组参数，但数组参数无法兼容可变参数，所以试图使用数组作为参数去实现重载时，会报错，说明可变参数与数组冲突


## 通过可变参数法，释放资源
1. closeable... ios --> try catch 关闭ios的各个元素


## try ...with ...finally
1. 实现AutoCloseable接口，可硬通过ARM(Auto Resource Management 自动资源管理)，**关闭任何可关闭资源，包括流。**
2. 数据流会在try语句执行完毕后，自动关闭。
3. 简洁，清晰，优雅。解决try catch 并释放资源工作。
4. 注意：在之后的jdk版本，必须单独申明变量，因为编译器会自动将其转为try catch finally形式。


## 语法糖的理解
1. 语法糖，仅仅是代码的局部优化，使代码更加简洁易懂，且实现的功能并未发生改变。
2. 语义自然流畅，效率高，自然和吃了糖一样。
3. 还有一类叫做"语法盐"，优点，即避免代码书写错误；但是效率降低，且标准高。


## 涨姿势
1. 出错：change project  compliance and jre  to  1.7
2. 将版本降低到1.7，错误改过来后，然后再切换到高版本



## 对接流
1. 步骤：
   1. 将文件读取到程序中，
   2. 将文件写入到字节数组中
   3. 将字节数组读取到程序中
   4. 将程序中的数据写入到另一文件中


## 装饰器模式
1. 了解装饰器模式的具体构成
   1. 抽象组件：包含需要装饰的抽象对象(接口或抽象父类)
   2. 具体组件：包含需要装饰的对象
   3. 抽象装饰类：包含对抽象组件的引用及装饰着共同方法
   4. 具体装饰类：被装饰的对象
 
2. 在IO流中：
   1. 抽象组件：InputStream
   2. 具体组件：FileInputStream,ByteArrayInputStream
   3. 抽象装饰类：FilterInputStream
   4. 具体装饰类：BufferedInputStream,DataInputStream,ObjectInputStream

3. 字节缓冲流
   1. 提升性能(如BufferedInputStream将创建一个内部缓冲区数组)
   2. 最底层仍是节点流
   3. 释放原则：从里到外，依次释放
   4. 通过BufferedInputStream,BufferedOutputStream来装饰

4. 字符缓冲流
   1. 使用BufferedReader，和BufferedWriter
   2. 使用新方法readLine()，可以读取一行文字
   3. 新方法newLine()，用于创建新行
   4. **注意：BufferedWriter/BufferedReader 仅处理纯文本内容**
* **注意：只要用到新增的方法，不要用到多态！！！**
  

## IO转换流
1. InputStreamReader/OutputStreamWriter：是字节流和字符流之间的桥梁。能将字节流转换为字符流。并且能为字节流指定字符集，用于处理一个个的字符。



* **注意：只要用到新增的方法，不要用到多态！！！**


## IO数据流 
1. 用于操作基本数据类型和字符串
2. DataInputStream & DataOutputStream
3. 注意，需要对数据流进行刷新
4. **必须遵循先写出，后读取**
5. **读取的顺序必须和写出时的顺序保持一致**


## 将数据与内存交互的内存流
### 字节内存流 ByteArrayInputStream、ByteArrayOutputStream
1. 当遇到，将xxx转为字节数组时，使用toByteArray
2. 当获取xxx占用的字节数，使用toByteArray

### 字符内存流 CharArrayWriter、CharArrayReader



## IO对象流
1. 处理范围：包括基本数据类型和字符串，并且包括各种对象
2. 序列化：Serialization
3. 反序列化：Deserialization
4. **必须遵循先写出，后读取**
5. **读取的顺序必须和写出时的顺序保持一致**
6. 不是所有的对象都可以序列化：java.io.NotSerializableException，如果没有实现序列化接口，报错
7. 新：writeObject ； readeObject
8. 不需要序列化的属性，我们可以通过添加transient修饰符修饰
9. 序列化又称为持久化
10. 注意：**包装类，我们获取时需要手动转型**
11. 报错：java.io.OptionalDataException
    1.  解决：使用相同的输入File对象，不一样，会导致并发(即多个线程在操作该对象)。


## PrintStream 打印流


## 涨姿势啦！！
* alt + shift + r ：快速重构选中的变量名称。


## IO 文件分割
### RandomAccessFile
1. RandomAccessFile 支持读和写随机访问文件。
2. 构造器中传文件。
3. seek方法。
4. **OOP思想**


## Sequence序列流



## 引入 commons-io
* commons-io-2.6-sources.jar 和 commons-io-2.6.jar
1. listFiles 列出文件和文件夹，可以过滤 EmptyFileFilter
   1. 返回Collection 集合对象，
2. DirectoryFileFilter.INSTANCE 获取文件夹以及子文件夹内所有文件
3. new SuffixFileFilter("java")，可以滤除不含java结尾的文件
4. FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY)
   1. 可以过滤仅带有java和class结尾文件

5. 通过工具FileUtils类的copyURLToFile，可以下载网上文件到文件中 --> 引申到线程，请看线程java03




