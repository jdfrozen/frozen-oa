-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `icon_cls` varchar(64) DEFAULT NULL,
  `keep_alive` tinyint(1) DEFAULT NULL,
  `require_auth` tinyint(1) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) DEFAULT NULL,
  `r_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `m_id` bigint(20) DEFAULT NULL,
  `r_id` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '系统管理员', '18568887789', '029-82881234', '深圳南山', '1', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', null,now(),now());
INSERT INTO `user` VALUES ('5', '李白', '18568123489', '029-82123434', '海口美兰', '1', 'libai', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg', null,now(),now());
INSERT INTO `user` VALUES ('10', '韩愈', '18568123666', '029-82111555', '广州番禺', '1', 'hanyu', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1406745149,1563524794&fm=27&gp=0.jpg', null,now(),now());
INSERT INTO `user` VALUES ('11', '柳宗元', '18568123377', '029-82111333', '广州天河', '1', 'liuzongyuan', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg', null,now(),now());
INSERT INTO `user` VALUES ('12', '曾巩', '18568128888', '029-82111222', '广州越秀', '1', 'zenggong', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg', null,now(),now());

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_manager', '部门经理',now(),now());
INSERT INTO `role` VALUES ('2', 'ROLE_personnel', '人事专员',now(),now());
INSERT INTO `role` VALUES ('3', 'ROLE_recruiter', '招聘主管',now(),now());
INSERT INTO `role` VALUES ('4', 'ROLE_train', '培训主管',now(),now());
INSERT INTO `role` VALUES ('5', 'ROLE_performance', '薪酬绩效主管',now(),now());
INSERT INTO `role` VALUES ('6', 'ROLE_admin', '系统管理员',now(),now());
INSERT INTO `role` VALUES ('13', 'ROLE_test2', '测试角色2',now(),now());
INSERT INTO `role` VALUES ('14', 'ROLE_test1', '测试角色1',now(),now());-- ----------------------------
-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/', null, null, '所有', null, null, null, null, '1',now(),now());
INSERT INTO `menu` VALUES ('2', '/', '/home', 'Home', '员工资料', 'fa fa-user-circle-o', null, '1', '1', '1',now(),now());
INSERT INTO `menu` VALUES ('3', '/', '/home', 'Home', '人事管理', 'fa fa-address-card-o', null, '1', '1', '1',now(),now());
INSERT INTO `menu` VALUES ('4', '/', '/home', 'Home', '薪资管理', 'fa fa-money', null, '1', '1', '1',now(),now());
INSERT INTO `menu` VALUES ('5', '/', '/home', 'Home', '统计管理', 'fa fa-bar-chart', null, '1', '1', '1',now(),now());
INSERT INTO `menu` VALUES ('6', '/', '/home', 'Home', '系统管理', 'fa fa-windows', null, '1', '1', '1',now(),now());
INSERT INTO `menu` VALUES ('7', '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', null, null, '1', '2', '1',now(),now());
INSERT INTO `menu` VALUES ('8', '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', null, null, '1', '2', '0',now(),now());
INSERT INTO `menu` VALUES ('9', '/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', null, null, '1', '3', '0',now(),now());
INSERT INTO `menu` VALUES ('10', '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', null, null, '1', '3', '1',now(),now());
INSERT INTO `menu` VALUES ('11', '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', null, null, '1', '3', '1',now(),now());
INSERT INTO `menu` VALUES ('12', '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', null, null, '1', '3', '1',now(),now());
INSERT INTO `menu` VALUES ('13', '/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', null, null, '1', '3', '1',now(),now());
INSERT INTO `menu` VALUES ('14', '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', null, null, '1', '4', '1',now(),now());
INSERT INTO `menu` VALUES ('15', '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', null, null, '1', '4', '1',now(),now());
INSERT INTO `menu` VALUES ('16', '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', null, null, '1', '4', '1',now(),now());
INSERT INTO `menu` VALUES ('17', '/salary/month/**', '/sal/month', 'SalMonth', '月末处理', null, null, '1', '4', '1',now(),now());
INSERT INTO `menu` VALUES ('18', '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', null, null, '1', '4', '1',now(),now());
INSERT INTO `menu` VALUES ('19', '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', null, null, '1', '5', '1',now(),now());
INSERT INTO `menu` VALUES ('20', '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', null, null, '1', '5', '1',now(),now());
INSERT INTO `menu` VALUES ('21', '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', null, null, '1', '5', '1',now(),now());
INSERT INTO `menu` VALUES ('22', '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', null, null, '1', '5', '1',now(),now());
INSERT INTO `menu` VALUES ('23', '/system/basic/**', '/sys/basic', 'SysBasic', '基础信息设置', null, null, '1', '6', '1',now(),now());
INSERT INTO `menu` VALUES ('24', '/system/cfg/**', '/sys/cfg', 'SysCfg', '系统管理', null, null, '1', '6', '1',now(),now());
INSERT INTO `menu` VALUES ('25', '/system/log/**', '/sys/log', 'SysLog', '操作日志管理', null, null, '1', '6', '1',now(),now());
INSERT INTO `menu` VALUES ('26', '/system/hr/**', '/sys/hr', 'SysHr', '操作员管理', null, null, '1', '6', '1',now(),now());
INSERT INTO `menu` VALUES ('27', '/system/data/**', '/sys/data', 'SysData', '备份恢复数据库', null, null, '1', '6', '1',now(),now());
INSERT INTO `menu` VALUES ('28', '/system/init/**', '/sys/init', 'SysInit', '初始化数据库', null, null, '1', '6', '1',now(),now());
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '3', '6',now(),now());
INSERT INTO `user_role` VALUES ('9', '5', '1',now(),now());
INSERT INTO `user_role` VALUES ('10', '5', '4',now(),now());
INSERT INTO `user_role` VALUES ('35', '12', '4',now(),now());
INSERT INTO `user_role` VALUES ('36', '12', '3',now(),now());
INSERT INTO `user_role` VALUES ('37', '12', '2',now(),now());
INSERT INTO `user_role` VALUES ('43', '11', '3',now(),now());
INSERT INTO `user_role` VALUES ('44', '11', '2',now(),now());
INSERT INTO `user_role` VALUES ('45', '11', '4',now(),now());
INSERT INTO `user_role` VALUES ('46', '11', '5',now(),now());
INSERT INTO `user_role` VALUES ('48', '10', '3',now(),now());
INSERT INTO `user_role` VALUES ('49', '10', '4',now(),now());
-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('161', '7', '3',now(),now());
INSERT INTO `menu_role` VALUES ('162', '7', '6',now(),now());
INSERT INTO `menu_role` VALUES ('163', '9', '6',now(),now());
INSERT INTO `menu_role` VALUES ('164', '10', '6',now(),now());
INSERT INTO `menu_role` VALUES ('165', '11', '6',now(),now());
INSERT INTO `menu_role` VALUES ('166', '12', '6',now(),now());
INSERT INTO `menu_role` VALUES ('167', '13', '6',now(),now());
INSERT INTO `menu_role` VALUES ('168', '14', '6',now(),now());
INSERT INTO `menu_role` VALUES ('169', '15', '6',now(),now());
INSERT INTO `menu_role` VALUES ('170', '16', '6',now(),now());
INSERT INTO `menu_role` VALUES ('171', '17', '6',now(),now());
INSERT INTO `menu_role` VALUES ('172', '18', '6',now(),now());
INSERT INTO `menu_role` VALUES ('173', '19', '6',now(),now());
INSERT INTO `menu_role` VALUES ('174', '20', '6',now(),now());
INSERT INTO `menu_role` VALUES ('175', '21', '6',now(),now());
INSERT INTO `menu_role` VALUES ('176', '22', '6',now(),now());
INSERT INTO `menu_role` VALUES ('177', '23', '6',now(),now());
INSERT INTO `menu_role` VALUES ('178', '25', '6',now(),now());
INSERT INTO `menu_role` VALUES ('179', '26', '6',now(),now());
INSERT INTO `menu_role` VALUES ('180', '27', '6',now(),now());
INSERT INTO `menu_role` VALUES ('181', '28', '6',now(),now());
INSERT INTO `menu_role` VALUES ('182', '24', '6',now(),now());
INSERT INTO `menu_role` VALUES ('247', '7', '4',now(),now());
INSERT INTO `menu_role` VALUES ('248', '8', '4',now(),now());
INSERT INTO `menu_role` VALUES ('249', '11', '4',now(),now());
INSERT INTO `menu_role` VALUES ('250', '7', '2',now(),now());
INSERT INTO `menu_role` VALUES ('251', '8', '2',now(),now());
INSERT INTO `menu_role` VALUES ('252', '9', '2',now(),now());
INSERT INTO `menu_role` VALUES ('253', '10', '2',now(),now());
INSERT INTO `menu_role` VALUES ('254', '12', '2',now(),now());
INSERT INTO `menu_role` VALUES ('255', '13', '2',now(),now());
INSERT INTO `menu_role` VALUES ('256', '7', '1',now(),now());
INSERT INTO `menu_role` VALUES ('257', '8', '1',now(),now());
INSERT INTO `menu_role` VALUES ('258', '9', '1',now(),now());
INSERT INTO `menu_role` VALUES ('259', '10', '1',now(),now());
INSERT INTO `menu_role` VALUES ('260', '11', '1',now(),now());
INSERT INTO `menu_role` VALUES ('261', '12', '1',now(),now());
INSERT INTO `menu_role` VALUES ('262', '13', '1',now(),now());
INSERT INTO `menu_role` VALUES ('263', '14', '1',now(),now());
INSERT INTO `menu_role` VALUES ('264', '15', '1',now(),now());
INSERT INTO `menu_role` VALUES ('265', '16', '1',now(),now());
INSERT INTO `menu_role` VALUES ('266', '17', '1',now(),now());
INSERT INTO `menu_role` VALUES ('267', '18', '1',now(),now());
INSERT INTO `menu_role` VALUES ('268', '19', '1',now(),now());
INSERT INTO `menu_role` VALUES ('269', '20', '1',now(),now());
INSERT INTO `menu_role` VALUES ('270', '21', '1',now(),now());
INSERT INTO `menu_role` VALUES ('271', '22', '1',now(),now());
INSERT INTO `menu_role` VALUES ('272', '23', '1',now(),now());
INSERT INTO `menu_role` VALUES ('273', '24', '1',now(),now());
INSERT INTO `menu_role` VALUES ('274', '25', '1',now(),now());
INSERT INTO `menu_role` VALUES ('275', '26', '1',now(),now());
INSERT INTO `menu_role` VALUES ('276', '27', '1',now(),now());
INSERT INTO `menu_role` VALUES ('277', '28', '1',now(),now());
