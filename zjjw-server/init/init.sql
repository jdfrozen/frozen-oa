-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐加密',
  `userface` varchar(128) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称中文',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL COMMENT 'url',
  `component` varchar(64) DEFAULT NULL COMMENT '菜单内容',
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '图标',
  `keep_alive` tinyint(1) DEFAULT NULL COMMENT '保活',
  `require_auth` tinyint(1) DEFAULT NULL COMMENT '要求',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role`;
CREATE TABLE `sys_menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_company_dynamic`;
CREATE TABLE `sys_company_dynamic` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`type` int(4) DEFAULT '0' COMMENT '动态类型',
	`dynamic_info` varchar(128) DEFAULT NULL COMMENT '动态信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业动态表';

DROP TABLE IF EXISTS `sys_company_evaluate`;
CREATE TABLE `sys_company_evaluate` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`evaluate_info` varchar(500) DEFAULT NULL COMMENT '评价信息',
	`recommend` int(8) DEFAULT '0' COMMENT '推荐数量',
	`recommend_reason` varchar(500) DEFAULT NULL COMMENT '推荐原因',
	`commonly` int(8) DEFAULT '0' COMMENT '一般数量',
	`commonly_reason` varchar(500) NOT NULL COMMENT '一般原因',
	`not_recommend` int(8) DEFAULT '0' COMMENT '不推荐数量',
	`not_recommend_reason` varchar(500) DEFAULT NULL COMMENT '不推荐原因',
	`acclaim_probability` varchar(16) DEFAULT NULL COMMENT '好评率',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业评价表';

DROP TABLE IF EXISTS `sys_company_info`;
CREATE TABLE `sys_company_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_name` varchar(32) COMMENT '企业名称',
	`is_list` int(2) DEFAULT '0' COMMENT '是否上市',
	`base_info` varchar(500)  COMMENT '基本信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业信息表';

DROP TABLE IF EXISTS `sys_company_product`;
CREATE TABLE `sys_company_product` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`product_name` varchar(128)  COMMENT '产品名称',
	`product_info` varchar(128) COMMENT '产品信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业产品表';

DROP TABLE IF EXISTS `sys_company_recruit`;
CREATE TABLE `sys_company_recruit` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`recruit_name` varchar(128) COMMENT '职位名称',
	`recruit_info` varchar(128) COMMENT '职位信息',
	`is_listed` int(2) DEFAULT '0' COMMENT '是否上市',
	`minimum salary` int(8) DEFAULT '0' COMMENT '最低薪资',
	`maximum salary` int(8) DEFAULT '0' COMMENT '最高薪资',
	`address` varchar(128) NOT NULL COMMENT '地址',
	`minimum experience` int(8) DEFAULT '0' COMMENT '最低经验',
	`maximum experience` int(8) DEFAULT '0' COMMENT '最高经验',
	`degree` varchar(16) NOT NULL COMMENT '学历',
	`welfare_label` varchar(128) NOT NULL COMMENT '地址',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业产品表';

-- -----------------
-- -----------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`age` int(4) DEFAULT NULL COMMENT '年龄',
	`gender` int(4) DEFAULT NULL COMMENT '性别',
	`degree` varchar(16) NOT NULL COMMENT '学历',
	`birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
	`occupation` varchar(16) NOT NULL COMMENT '职业',
	`hometown` varchar(128) DEFAULT NULL COMMENT '家乡',
	`evaluate_mark` varchar(128) DEFAULT NULL COMMENT '企业评价标记',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

DROP TABLE IF EXISTS `sys_user_dynamic`;
CREATE TABLE `sys_user_dynamic` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`type` int(4) DEFAULT NULL COMMENT '动态类型',
	`dynamic_info` varchar(128) DEFAULT NULL COMMENT '动态信息',
	`evaluate_mark` varchar(128) DEFAULT NULL COMMENT '企业评价标记',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户动态表';
