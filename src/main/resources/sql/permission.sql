/*
Navicat MySQL Data Transfer

Source Server         : 我的数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : work-attendance

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-15 23:57:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionid` bigint(20) NOT NULL,
  `permission` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`permissionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'attend:attendList', '考勤数据页面');
INSERT INTO `permission` VALUES ('3', 'reAttend:approve', '补签批准操作');
INSERT INTO `permission` VALUES ('5', 'reAttend:start', '补签发起');
INSERT INTO `permission` VALUES ('6', 'reAttend:list', '补签任务页面');
