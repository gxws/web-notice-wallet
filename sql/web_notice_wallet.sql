/*
Navicat MariaDB Data Transfer

Source Server         : zhuweiliang@192.168.100.44
Source Server Version : 100017
Source Host           : 192.168.100.44:3306
Source Database       : web_notice_wallet

Target Server Type    : MariaDB
Target Server Version : 100017
File Encoding         : 65001

Date: 2015-08-05 14:46:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for queue_tb
-- ----------------------------
DROP TABLE IF EXISTS `queue_tb`;
CREATE TABLE `queue_tb` (
  `id` char(32) NOT NULL,
  `status` tinyint(1) DEFAULT '1' COMMENT '通知状态[0:对方已收到][1:需要发送][2:发送暂停]',
  `data` varchar(1000) NOT NULL COMMENT '发送数据key=value形式，格式为key1=value1,key2=value2',
  `url` varchar(500) NOT NULL COMMENT '通知发送url',
  `time_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '生成时间',
  `time_sent` datetime DEFAULT NULL COMMENT '最后发送时间',
  `app_key` varchar(500) NOT NULL COMMENT '用于签名的appkey',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
