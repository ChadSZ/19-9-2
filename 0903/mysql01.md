```
insert into student(num) values('00006');
select @@identity;

insert into student(num) values('00007');
select last_insert_id();

这两种的查询方法必须紧跟在insert后面。
```

