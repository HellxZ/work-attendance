/*
Navicat MySQL Data Transfer

Source Server         : 我的数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : work-attendance

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-15 23:57:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `re_attend`
-- ----------------------------
DROP TABLE IF EXISTS `re_attend`;
CREATE TABLE `re_attend` (
  `id` bigint(20) NOT NULL,
  `attend_id` bigint(20) NOT NULL COMMENT '打卡数据ID 关联考勤表',
  `attend_date` date NOT NULL COMMENT '补签日期',
  `re_attend_starter` varchar(50) NOT NULL COMMENT '补签发起人名字',
  `re_attend_eve` time NOT NULL COMMENT '补签晚打卡时间',
  `re_attend_mor` time NOT NULL COMMENT '补签早打卡时间',
  `current_handler` varchar(50) DEFAULT NULL COMMENT '当前处理人',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态1 处理中 2 通过  3 不通过 ',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注 补签原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of re_attend
-- ----------------------------
INSERT INTO `re_attend` VALUES ('1', '22', '2017-07-01', 'laowang', '18:30:00', '09:00:00', 'laowang666', '2', '忘记打卡');
