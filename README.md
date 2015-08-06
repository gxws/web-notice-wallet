# web-notice-wallet
电视钱包异步通知临时解决方案


## 版本变更说明

### 1.0.0
去除原数据库里的no和noid字段。<br>
去除通知类型字段。<br>
去除发送记录表。<br>
去除app_key字段。<br>
<br>
修改发送状态，由char类型改为tinyint类型。<br>
修改数据读取方式为从数据库读取。<br>
<br>
添加了全局变量的静态化定义。<br>
添加了简单的容错能力。<br>

## 使用说明
### 发送通知
写入mysql数据库`web_notice_wallet`的`queue_tb`表，将字段status的值设置为"1"。<br>
需要发送的数据字段为data，以key=value形式，格式为key1=value1,key2=value2的字符串。<br>
需要发送到的地址字段为url。<br>

## 实现
### 读取需要发送的通知
	com.gxws.web.notice.wallet.bo.NoticeScanBO#scanning()
	
### 通知发送
	com.gxws.web.notice.wallet.bo.NoticeSendBO#sending8()

## 依赖
JDK 8<br>
Tomcat 8<br>
