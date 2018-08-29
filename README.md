# MyPass

## 简介
商户投放系统（merchants）、用户应用系统（passbook）实现普通线上卡包应用
 
## 特点
Hbase分布式处理、Kafka消息队列服务、卡包优惠卷功能

## 功能

    投放卡包
    用户、商户注册
    卡包使用
    卡包库存
    用户反馈

## 项目思路

对于卡包系统（类优惠券服务），这样的业务完全可以抽成一个独立的服务来做，
本文也是对一个小卡包项目的总结，并无应用到上线产品中，但是其中的设计实现与部分上线产品一致，这里做个整理。

对于框架的技术产品选型：后台快速开发框架SpringBoot，这个项目涉及两个子系统，一个商户投放卡包系统，
一个用户应用系统，所以两个系统之间的通信使用了Kafka，缓存层依旧使用Redis，对于数据库本次使用了HBase与MySQL。

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/pass/clipboard1.png)

对于卡包应用，大家可以看看微信卡包与小米卡包，其是针对于两种用户群体，即可以给想要入驻的商户进行卡包投放，还有就是给平台的所有用户去消费使用卡包。

那么针对商户投放平台，我们需要提供两个服务，一个是注册商户接口，第二个是投放优惠券接口

而用户应用系统则比较多，也是重点。要有用户卡包的显示接口、过期优惠券的显示接口、优惠券库存接口、用户反馈接口等

对于商户投放系统，首先商户注册生成对应的Merchants实体，他们可以投放自己商家的卡包PassTemplate，且卡包有自己的Token存放于Redis中，投放的卡包信息将由Kafka给用户应用系统发送。这里仅需要将商户信息存储在MySQL中，而投放的卡包并不需要MySQL进行存储。

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/pass/clipboard2.png)

对于用户应用系统，其核心主体是用户User，而卡包主体Pass则会去kafka中消费商户系统中投放的卡包信息，并存储到HBase中，用户的反馈Feedback也是存放在Hbase中，之后应用的去生成Service服务，当用户使用卡包时，去做一些业务逻辑判断（时间有效、卡包库存等）

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/pass/clipboard3.png)

当然还有传统项目中需要的日志处理设计、异常处理设计，对于表结构而言，HBase的主副关系对于卡包应用业务是恰当好处的支持到了。

## 配置

    application.yml 数据库配置

## 下载地址

下载地址：https://github.com/UncleCatMySelf/MyPass/releases

## 交流与提问

提问与Bug上报：https://github.com/UncleCatMySelf/MyPass/issues

QQ群：628793702（仅供交流，不提供问题解答）

## 关于作者

博客园：https://www.cnblogs.com/UncleCatMySelf/

个人公众号：UncleCatMySelf

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/%E5%85%AC%E4%BC%97%E5%8F%B7.png)

个人开发，感谢支持！

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/%E4%BB%98%E6%AC%BE.png)
