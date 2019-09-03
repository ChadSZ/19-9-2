## git 拉取远程分支到本地
1. 新建一个空文件，文件名为hhhh

2. 初始化 git init

3. 自己要与origin master建立连接（下划线为远程仓库链接）

    git remote add origin git@github.com:XXXX/nothing2.git

4. 把远程分支拉到本地

    git fetch origin dev（dev为远程仓库的分支名）

5. 在本地创建分支dev并切换到该分支

    git checkout -b dev(本地分支名称) origin/dev(远程分支名称)

6. 把某个分支上的内容都拉取到本地

    git pull origin dev(远程分支名称)   

7. 回到本地，结束~


## 涨姿势啦！
* git clone：
        Cloning into 'mes0816'...
        remote: Invalid username or password.
        fatal: Authentication failed for 'https://github.com/ChadSZ/mes0816.git/'
    未解决


## JS的控制语句

1. if

2. switch

3. while

4. do...while...

5. for 循环

6. break

7. continue

8. for...in 语句(了解)

9. with语句(了解)

