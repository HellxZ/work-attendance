/*
Navicat MySQL Data Transfer

Source Server         : 我的数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : work-attendance

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-15 23:58:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attend`
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `attend_date` date NOT NULL COMMENT '考勤日期',
  `attend_week` tinyint(2) NOT NULL COMMENT '星期',
  `attend_morning` time DEFAULT NULL COMMENT '早打卡时间',
  `attend_evening` time DEFAULT NULL COMMENT '晚打卡时间',
  `absence` int(10) DEFAULT NULL COMMENT '缺勤时长',
  `attend_status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '考勤状态 1 正常  2异常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attend
-- ----------------------------
INSERT INTO `attend` VALUES ('1', '1', '2017-05-01', '1', '09:00:02', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('2', '1', '2017-05-02', '2', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('3', '1', '2017-05-03', '3', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('4', '1', '2017-05-04', '4', '09:00:00', '19:02:03', null, '1');
INSERT INTO `attend` VALUES ('5', '1', '2017-05-05', '5', '10:02:00', '19:23:00', '58', '2');
INSERT INTO `attend` VALUES ('6', '1', '2017-05-06', '6', null, null, null, '1');
INSERT INTO `attend` VALUES ('7', '1', '2017-05-07', '7', null, null, null, '1');
INSERT INTO `attend` VALUES ('8', '1', '2017-05-08', '1', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('9', '1', '2017-05-09', '2', '10:00:00', '18:23:00', '38', '2');
INSERT INTO `attend` VALUES ('10', '1', '2017-05-10', '3', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('11', '1', '2017-05-11', '4', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('12', '1', '2017-05-12', '5', '09:02:00', '19:23:00', '52', '2');
INSERT INTO `attend` VALUES ('13', '1', '2017-05-13', '6', null, null, null, '1');
INSERT INTO `attend` VALUES ('14', '1', '2017-05-14', '7', null, null, null, '1');
INSERT INTO `attend` VALUES ('15', '1', '2017-05-15', '1', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('16', '1', '2017-05-16', '2', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('17', '1', '2017-05-17', '3', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('18', '1', '2017-05-18', '4', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('19', '1', '2017-05-19', '5', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('20', '1', '2017-05-20', '6', null, null, null, '1');
INSERT INTO `attend` VALUES ('21', '1', '2017-05-21', '7', null, null, null, '1');
INSERT INTO `attend` VALUES ('22', '1', '2017-05-22', '1', '09:00:00', '16:02:00', '114', '2');
INSERT INTO `attend` VALUES ('23', '1', '2017-05-23', '2', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('24', '1', '2017-05-24', '3', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('25', '1', '2017-05-25', '4', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('26', '1', '2017-05-26', '5', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('27', '1', '2017-05-27', '6', null, null, null, '1');
INSERT INTO `attend` VALUES ('28', '1', '2017-05-28', '7', null, null, null, '1');
INSERT INTO `attend` VALUES ('29', '1', '2017-05-29', '1', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('30', '1', '2017-05-30', '2', '09:00:00', '19:02:00', null, '1');
INSERT INTO `attend` VALUES ('31', '1', '2017-08-10', '4', '09:00:00', null, '480', '2');
INSERT INTO `attend` VALUES ('33', '1', '2017-06-27', '2', '09:00:16', null, '480', '2');
INSERT INTO `attend` VALUES ('34', '1', '2017-08-11', '5', null, null, '480', '2');
INSERT INTO `attend` VALUES ('35', '1', '2017-08-12', '6', null, null, '480', '2');
