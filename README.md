# 概要
本分支为spring cloud netflix的学习代码，下载后可分别使用idea打开。

## 模块
- [diana-netflix](#diana-netflix)
  - server
  - user
  - order
- [eureka-cluster](#eureka-cluster)
  - eureka-1
  - eureka-2
  - eureka-3

## diana-netflix
此目录为单机版的eureka服务实现，内包含eureka、riibon、openfeign、hystrix、zuul如何使用的代码，使用user、order模块作为例子进行学习说明。

## eureka-cluster
此目录为eureka集群是如何实现的，以及相互之间的用户名密码认证，除此之外没有其它代码，可使用diana-netflix中user、order模块进行注册验证，修改application.yml文件中的eureka服务地址即可，已在文件中给出路径模版，可将注释标记进行切换即可。
