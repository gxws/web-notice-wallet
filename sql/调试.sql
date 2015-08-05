
-- 批量添加发送地址和参数
update queue_tb set `data` = 'abc=123&bcd=456', `url` = 'http://localhost:8080/web-notice-wallet/receiveTestController';

-- 查看需要发送的数据
select * from queue_tb where status = '1' and id not in ('');

-- 设置所有记录都需要发送
update queue_tb set status = '1';

-- 清除所有数据
delete from queue_tb;