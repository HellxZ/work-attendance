/*
Navicat MySQL Data Transfer

Source Server         : 我的数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : work-attendance

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-15 23:57:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `real_name` varchar(20) NOT NULL COMMENT '真实姓名',
  `head_image` varchar(100) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'laowang', 'ICy5YqxZB1uWSwcVLSNLcA==', null, 'laowang', '/static/image/avatar.png');
INSERT INTO `user` VALUES ('2', 'laowang666', 'ICy5YqxZB1uWSwcVLSNLcA==', '754456', '老王666', '/static/image/avatar.png');
