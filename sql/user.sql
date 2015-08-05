CREATE USER 'web_notice_wallet'@'%' IDENTIFIED BY 'web_notice_wallet';

GRANT SELECT, INSERT, UPDATE, DELETE, TRIGGER, SHOW VIEW ON `web\_notice\_wallet`.* TO 'web_notice_wallet'@'%';

