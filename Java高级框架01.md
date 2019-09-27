## 框架认识第一步，命名
1. 项目名称：没有要求，中文不用
2. package：域名+组织+层
3. 层命名：
   1. 持久层：dao,persist,mapper
   2. 实体：entity,model,bean,javabean,pojo
   3. 业务逻辑：service,biz
   4. 控制器：controller,servlet,action,web
   5. 过滤器：filter
   6. 异常：exception
   7. 监听器：listener
4. 注释：
   1. 类上和方法上使用文档注释 /** */
   2. 在方法里面使用 /* */ 或//
5. 类命名：
   1. 大驼峰
6. 方法命名，属性命名：
   1. 小驼峰


## MVC开发模式
1. MVC(又称jsp model2；而model1就是全部的数据承载和业务处理都在同一个jsp中)
2. Controller(控制器，servlet)作用：
   1. 视图和逻辑分离
   2. 用于大型业务中



## JDK 1.7 & 1.8区别
1. 1

```
/**
     *是否 Lazy 初始化：否
     *是否多线程安全：是
     *实现难度：易
     *描述：这种方式比较常用，但容易产生垃圾对象。
     *优点：没有加锁，执行效率会提高。
     *缺点：类加载时就初始化，浪费内存。
     *它基于 classloder 机制避免了多线程的同步问题，
     * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
    * 在单例模式中大多数都是调用 getInstance 方法，
     * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
     * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
     */
饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了。

而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。

1、线程安全：

饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，

懒汉式本身是非线程安全的，为了实现线程安全有几种写法。

2、资源加载和性能：

饿汉式在类创建的同时就实例化一个静态对象出来，不管之后会不会使用这个单例，都会占据一定的内存，但是相应的，在第一次调用时速度也会更快，因为其资源已经初始化完成。

而懒汉式顾名思义，会延迟加载，在第一次使用该单例的时候才会实例化对象出来，第一次调用时要做初始化，如果要做的工作比较多，性能上会有些延迟，之后就和饿汉式一样了。

```


## Java注解
1. Annotation是从jdk5.0开始引入的新技术
2. Annotation的认识
   1. Annotation不是程序本身，是对程序作出的解释。(从这点可以知道注解和注释类似)
   2. 可以**被其他程序读取**(如，编译器等)：hibernate
   3. 注解信息的处理流程，是注释和注解的最大区别。
3. Annotation的格式：
   1. @注释名
   2. 可以添加参数值：@SuppressWarnings(value="unchecked")
4. 使用范围
   1. 可以在package,class,method,field等上面附加。相当于给它们添加了额外的辅助信息，可以通过反射机制编程实现对这些元数据的访问。
5. 初识@Override
   1. Indicates that a method declaration is intended to override a
method declaration in a superclass.  If a method is annotated with
this annotation type but does not override a superclass method,
compilers are required to generate an error message.
   2. 定义在java.lang.Override中，此注释只适用于修辞方法，标识一个方法声明打算重写超类中的另一个方法声明。
6. @Deprecated(强烈反对的意思)
   1. 表示这个方法，属性，类不建议使用，已废弃等。
7. @SuppressWarnings(压制警告)
   1. 定义在java.lang.SuppressWarnings中，用来抑制编译时的警告信息。
   2. 与前面的@Override和@Deprecated不同的是：我们需要添加参数才能使用SuppressWarnings。
   3. 参数如下：
      1. deprecation：使用了过时的类或方法的警告
      2. unchecked：执行了未检查的转换时的警告，如使用集合时，为指定泛型
      3. fallthrough：当在switch语句使用时，发生case穿透
      4. path：在类路径、源文件路径等中有不存在路径的警告
      5. serial：当在可序列化的类上缺少serialVersionUID定义时的警告
      6. finally：任何finally子句不能完成时的警告
      7. all：关于以上所有情况的警告
8. 自定义注解
   1. @interface，自动继承了java.lang.annotation.Annotation接口
   2. 格式：public @interface 注解名{定义体}
   3. 在注解自定义时，需要使用元注解，元注解是负责注解其他注解的。Java定义了4个meta-annotation类型，
     这些类型和他们所支持的类在java.lang.annotation包中可以找到--
      1. @Target 修饰范围及取值ElementType：
      
         1. package包，PACKAGE
         2. 类、接口、枚举、Annotation类型，TYPE
         3. 类型成员(方法、构造方法、成员变量、枚举值)，CONSTRUCTOR:用于描述构造器，FIELD：用于描述域，METHOD：于与描述方法
         4. 方法参数和本地变量，LOCAL_VARIABLE：用于描述局部变量，PARAMETER：用于描述参数
         5.  关于target的定义：
         ```
         public @interface Target {
            ElementType[] value();
        }
        public enum ElementType {...}

         ```
        即，定义的是一个返回为数组类型，名称为value的一个方法。而ElementType又是一个枚举类。

       2. @Retention取值RetentionPolicy(保留策略)和作用，表示为在什么级别保存该注释信息，用于描述注解的生命周期
   
            1. SOURCE：在源文件中有效(源文件中保留)
   
            2. CLASS：在class文件中有效(即class保留)
          
            3. RUNTIME：在运行时有效(即运行时保留)，Runtime可以被反射机制读取，即souce和class级别都可以用 
        
      2. @Documented

      3. Inherited

   4. 注解元素必须有值。我们在定义注解元素时。经常使用空字符串、0作为默认值。也经常使用负数(-1)表示不存在的含义
   5. 注解小知识点：
    ```
    //	@SxtAnnotation02(value="aaaa")
	// 注解中仅有一个值，可以不用加value
	@SxtAnnotation02("aaaa")
    ```

9. 什么是ORM？(Object relational Mapping)，将数据库和Java相对应 
   1.  类与表结构对应
   2.  属性和字段对应
   3.  对象和记录对应

   4.  使用注解完成类和表结构的映射关系


## Java动态性之反射机制：
1. 动态语言：典型的如：Python、ruby、javascript等。
2. Java称之为“准动态语言”。

3. 反射机制：
   1. 指的是**在程序运行时期加载、探知、使用编译期间完全未知的类**。

   2. 在运行状态中，可以动态加载一个只有名称的类，对于任意一已加载的类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；

   3. 加载完类之后，在堆内存中，JVM会创建一个对应该类的就产生了一个Class类型的对象(一个类只有一个Class对象)，整个对象就像一面镜子，透过这个镜子看到类的结构及全部信息，所以，我们形象的称之为：反射。

   4. 对同一个类，创建的Class对象，仅有一个。
 
   5. 
      1. Instances of the class Class represent classes and interfaces in a running Java application. An enum is a kind of class and an annotation is a kind of interface. Every array also belongs to a class that is reflected as a Class object that is shared by all arrays with the same element type and number of dimensions. The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects. 

    Class has no public constructor. Instead Class objects are constructed automatically by the Java Virtual Machine as classes are loaded and by calls to the defineClass method in the class loader. 

       2. Class 类的实例表示正在运行的 Java 应用程序中的类和接口。枚举是一种类，注释是一种接口。每个数组属于被映射为 Class 对象的一个类，所有具有相同元素类型和维数的数组都共享该 Class 对象。基本的 Java 类型（boolean、byte、char、short、int、long、float 和 double）和关键字 void 也表示为 Class 对象。
      
   6. 测试各种类型(class,interface,enum,annotation,primitive type,void)对应的java.lang.Class对象的获取方式。
      1. .getClass()，和.class **返回Class类型的对象**

      2. .hasCode 获取类的哈希值

      3. .getName() 获取clazz的反射的类的类名
 
      4. 通过反射获取类中的各个属性
         1. .getDeclaredFields()
         2. .getDeclaredField("属性name")

      5. 通过反射获取类的方法
         1. .getDeclaredMethods()
         2. .getDeclaredMethod("方法name",parameterType1,parameterType2,...)
         3. 如： paramterType = String.class;

      6. 通过反射获取类的构造器
         1. .getDeclaredConstructors()
         2. .getDeclaredConstructor(parameterType1,parameterType2,parameterType3,...)
  
   7. 通过反射API调用构造方法，构造对象
      1. .newInstance() 构造对象 **注意：其本质是调用User的无参构造方法。故必须要有无参方法。**、
      2. 通过反射API调用构造器方法
      3. 通过反射API调用普通方法
      4. 通过反射API操作属性
         1. 属性.set(对象，赋属性值)
         2. 对于私有属性，需要通过setAccessible方法来启用和禁用访问安全检查的开关。
            1. 设置为false，会降低速度
            2. 设置为true，速度会有所提高，接近4倍
     
   8. 反射操作泛型(Generic)
      1. Java采用**泛型擦除的机制**来引入泛型。Java中的泛型仅仅是给编译器javac来使用的，确保数据的安全性和免去强制类型转换的麻烦，但是，一旦编译完成，所有和泛型有关的类型全部擦除。

      2. 为了通过反射操作这些类型以迎合实际开发的需要，java新增了parameterizedType，GenericArrayType，TypeVariable和WildcardType几种类型来代表不能被归一到Class类中的类型但是又和原始类型齐名的类型。

         1. ParameterizedType：标识一种参数化的类型，比如```Collection<String>```
            1. 通过getGenericParameterTypes()：获取泛型参数类型
            2. 通过getActualTypeArguments()：获取泛型中的实际参数类型
            3. 通过getGenericReturnType()：获取泛型的返回类型

         2. GenericArrayType：表示一种元素类型是参数化类型或者类型变量的数组类型
         3. TypeVariable：是各种类型变量的公共父接口
         4. WildcardType：代表一种通配符类型表达式，比如?,?extends Number,?super Integer
            1. Wildcard：通配符
   9. 反射操作注解
      1.  通过.getAnnotations()：获取所有有效注解
      2.  通过.getAnnotation(注解名.class)：获取类的指定注解


## 动态编译
1. 动态编译的应用场景：
   1. 可以做一个浏览器端编写java代码，上传服务器编译和运行的在线评测系统。
   2. 服务器动态加载某些类文件进行编译。
2. 动态编译的两种做法：
   1. 通过Runtime调用javac，启动新的进程去操作
      ```
      Runtime run = Runtime.getRuntime();
      Process process = run.exec("javac -cp d:/aaa/ helloworld.java");
      ```
   2. 通过javaCompiler动态编译
      1. 通过ToolProvider.getSystemJavaCompiler()过得编译对象
      2. 通过编译对象的.run方法运行
         1. run中的参数如下：
         2. param1：为java编译器提供参数
         3. param2：得到Java编译器的输出信息
         4. param3：接收编译器的错误信息
         5. param4：可变参数(String数组)，能传入一个或多个Java源文件
         6. 返回值：0，成功；其他，失败



## 脚本引擎执行javascript代码
1. java脚本引擎是从JDK6.0之后添加的新功能。
2. java应用程序可以通过**一套固定的接口**与各种脚本引擎交互，达到在Java平台上调用各种脚本语言的目的。
3. 可以将一些复杂异变的业务逻辑交给脚本语言处理，提交开发效率。
4. 接口。java可以使用各种不同的实现，从而通用的调用js,groovy,python等脚本。
5. JS使用了Rhino。


## 脚本使用步骤
1. 调用ScriptEngineManager类。创建该类对象



## 字节码操作
1. Java动态性的两种常见实现方式：
   1. 字节码操作
   2. 反射
2. 字节码实现功能
   1. 动态生成新的类
   2. 动态改变某个类的结构(添加/删除/修改 新的属性/方法)
3. 优势
   1. 比反射开销小，性能搞
   2. JAVAasist性能高于反射，低于ASM
4. 常见字节码操作类库
   1. BCEL，基于JVM
   2. ASM，基于JVM
   3. CGLIB，基于ASM
   4. Javassist，
      1. 通过ClassPool类，调用静态方法.getDefault()，创建类池对象pool
      2. 通过类池的makeClass方法创建CtClass类型对象，该对象用于创建自定义的类，添加到cc类中
      3. CtField类的.make()用于创建属性，添加到cc类中
      4. CtMethod类的.make用于创建方法，添加到cc类中
      5. 通过创建对象的方法调用CtConstructor类的构造器方法。
         1. 创建constructor对象
         2. 设置构造器内容
         3. 添加到cc类中
      
      6. 以下在类中声明方法
         1. 以下在类中声明方法1
            ```
            CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
            ```

         2. 以下在类中声明方法2
            ```
            CtMethod m = new CtMethod(CtClass.intType,"add",
               new CtClass[]{CtClass.intType,CtClass.intType}, cc);
               m.setModifiers(Modifier.PUBLIC);
               m.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");
            ```
         3. 上述代码返回值，需要通过 $0,$1,$2...来分别代表方法参数1，2，3...
         4. ```$$```相当于所有方法参数的简写。
         5. $cflow：一个方法调用的深度
         6. $r ：方法返回值的类型
         7. $_：方法返回值的类型
         8. addCatch()：方法中加入try catch快
         9. $e：代表异常对象
         10. $class：this的类型(class)
         11. $sig：方法参数的类型(class)数组
      7. 通过反射调用新生成的方法
         1. cc.toClass()：生成反射对象clazz
         2. 反射调用.getDeclaredMethod方法
         3. 通过对象method.invoke，来调用方法
      8. Javassist的API局限性
         1. JDK不支持(包括泛型、枚举)，不支持注解修改，但可以通过底层的javassist类来解决。具体参考网上文档。
         2. 不支持数组的初始化，如String[]{1,2,3}，除非只有数组的容量为1
         3. 不支持内部类的匿名类
         4. 不支持continue和break表达式
         5. 对于继承关系，有些不支持。


## 类加载全过程

### 类加载机制
1. 加载
   1. 将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区中的运行时数据结构，在堆中生成一个代表这个类的java.lang.Class对象，作为方法区类数据的访问入口。
2. 链接
   1. 将Java类的二进制代码合并到jvm的运行状态之中的过程
      1. 验证：确保加载的类信息符合JVM规范，没有安全方面的问题，
      2. 准备：正式为类变量(static变量)分配内存并设置类变量初始化值的阶段，这些内存都将在方法区中进行分配
      3. 解析：虚拟机常量池内的**符号引用**替换为**直接引用**的过程
3. 初始化
   1. 初始化阶段是执行类构造器``<clinit>()``方法的过程。类构造器``<clinit>()``方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块(static块)中的语句合并产生的。
   2. 当初始化一个类的时候，如果发现其父类还没有进行过初始化、则需要先出发其父类的初始化。
   3. 虚拟机会保证一个类的``<clinit>()``方法在多线程环节中被正确加锁和同步。
   4. 当访问一个java类的静态域(静态变量，field)时，只有真正声明这个域才会被初始化。 
4. 类的主动引用
   1. new一个类的对象
   2. 调用类的静态成员(除了final常量)和静态方法
   3. 使用java.lang.reflect包的方法对类进行反射调用
   4. 当虚拟机记启动，java Hello ，则一定会初始化Hello类。说白了，就是先启动main方法所在的类
   5. 当初始化一个类，如果其父类没有被初始化，则先会初始化其父类
5. 类的被动引用(不会发生类的初始化)
   1. 当访问一个静态域(静态变量)时，只有真正声明这个域的类才会被初始化
      1. 通过子类引用父类的静态变量，不会导致子类初始化
   2. 通过数组定义类引用，不会触发此类的初始化
   3. 引用常量不会触发此类的初始化(常量在编译阶段就存入调用类的常量池中了)


## 类加载器
1. 类加载器的作用：
2. 类缓存
   1. 一旦某个类被加载到类加载器中，它将维持加载(缓存)一段时间。遵循JVM垃圾回收机制。
3. 类加载器类型：
   1. 引导类加载器(通过C完成代码编写)
      1. 它用来加载java的核心库(JAVA_HOME/JRE/lib/rt.jar，或sun.boot.class.path路径下的内容)，是用原生代码来实现的，并不继承自java.lang.ClassLoader。
      2. 加载扩展类和应用程序类加载器。并制定他们的父类加载器。
   2. 扩展类加载器(通过JAVA完成代码编写，继承自java.lang.ClassLoader)
      1. 用来加载java的扩展库(JAVA_HOME/jre/ext/*.jar，或java.ext.dirs路径下的内容)。Java虚拟机的实现会提供一个扩展库目录。该类加载器在此目录里面查找并加载java类。
      2. 由sun.misc.Launcher$ExtClassLoader实现。
   3. 应用程序类加载器(通过JAVA完成代码编写，继承自java.lang.ClassLoader)
      1. 它根据Java应用的类路径(classpath，java.class.path路径)类。一般来说，Java应用的类都是由它来完成加载的。
      2. 由sun.misc.Launcher$AppClassLoader实现
   4. 自定义类加载器(通过JAVA完成代码编写，继承自java.lang.ClassLoader)
      1. 开发人员可以通过继承java.lang.ClassLoeader类的方式实现自己的类加载器，以满足一些特殊的需求。
   5. 注意：加载器之间不是继承关系，而是组合关系
4. java.lang.ClassLoader作用
   1. 根据一个指定的类的名称，找到或者生成其对应的字节代码，然后从这些字节代码中定义出一个java类，即java.lang.Class的实例。
   2. 还负责加载java应用所需的资源，如图像文件和配置文件等。

5. 类加载器的代理模式
   1. 代理模式
      1. 交给其他加载器来加载指定的类


## 快捷键快速查询类的树状结构
**ctrl+T**




## 框架搭建01
1. 创建pojo
2. 创建mapper对数据库操作
3. 创建service对数据进行访问
4. 创建servlet
   1. servlet最大的基类：GenericServlet
   2. 关于web.xml中的注解
      1. servlet标签：
         1. servlet-name标签
         2. servlet-class类路径
      2. servlet-mapping：servlet的映射设置
         1. servlet-name
         2. url-pattern：映射路径
      3. 提出疑问：servlet中都name和servlet-mapping的name需要保持一致吗？
   3. 但是，目前很少配置注解，一般都是注入的方式。**servlet3.0以后。tomcat7以上。都是注入。**
   4. 对于线程安全的理解：
      1. 对于变量创建后，是否有全局变量。全局变量创建后会对线程安全造成影响。
         1. 对于我们创建的flowerService变量，其创建后，有全局变量FlowerDao，但仅是一个dao，该对象创建后，内部并没有全局对象。所以不会对线程造成影响。
   5. 