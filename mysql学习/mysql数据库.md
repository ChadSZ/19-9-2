## mysql操作
1. 创建一个数据库并指定编码：
   1. create datebase 数据库名 default character set utf8;
2. 使用数据库
   1. use 数据库名;
3. 创建表
```
create table 表名{
    列名    类型    约束    备注(comment)''
    xid int(字符数) primary key auto_increment comment '编号',
    xname varchar(字符数) not null comment 'x名称',
    xprice float/double(字符数) not null comment 'x价格',
    ...
};
```
    * 注意：comment的使用

4. CURD
   1. insert into 表名 values(a,b,c,d); 注意：各个数据之间需要用逗号,隔开。
   2. 