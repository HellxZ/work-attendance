--创建work_attendance数据库，编码utf8
--用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `real_name` varchar(20) NOT NULL COMMENT '真名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `head_image` varchar(100) DEFAULT NULL COMMENT '头像url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
