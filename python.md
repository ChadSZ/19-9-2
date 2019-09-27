## 安装python
1. 记得勾选add path to ... 加入环境变量中
2. pip升级及设置网络连接的默认源
``` 
    python -m pip install --upgrade pip：升级pip
    pip install pip -U
    pip config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
```
3. you-get 
  1. 安装you-get：pip install you-get
  2. you-get下载
     1. 下载单个视频或音频：you-get -o 本地存储路径 bilibili视频在线网址
     2. 下载整套视频或音频：you-get --playlist -o 本地存储路径 bilibili视频在线网址 
     3. 下载不了了，需要更新 you-get ： pip install --upgrade you-get
  3. 下载谷歌助手
     1. 这个软件不好，因为该软件会修改主页