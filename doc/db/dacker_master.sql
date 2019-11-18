/*
Navicat MySQL Data Transfer

Source Server         : 本机MySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : dacker_master

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2019-11-18 19:25:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增长唯一标识',
  `user_id` bigint(20) default NULL COMMENT '用户id',
  `username` varchar(50) default NULL COMMENT '用户名',
  `operation` varchar(50) default NULL COMMENT '用户操作',
  `time` int(11) default NULL COMMENT '响应时间',
  `method` varchar(200) default NULL COMMENT '请求方法',
  `params` varchar(5000) default NULL COMMENT '请求参数',
  `ip` varchar(64) default NULL COMMENT 'IP地址',
  `gmt_create` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', null, 'admin', '用户注册', '1094', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@7c7f6da8', '192.168.0.55', '2019-11-07 15:45:59');
INSERT INTO `sys_log` VALUES ('2', null, 'admin', '用户注册', '21570', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@7c7f6da8', '192.168.0.55', '2019-11-07 15:49:44');
INSERT INTO `sys_log` VALUES ('3', null, 'admin', '用户注册', '10134', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@4a9d77fb', '192.168.0.55', '2019-11-07 15:54:44');
INSERT INTO `sys_log` VALUES ('4', null, 'admin', '用户注册', '7022', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@4b36b594', '192.168.0.55', '2019-11-07 15:56:11');
INSERT INTO `sys_log` VALUES ('5', null, 'admin', '用户注册', '8768', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@339849da', '192.168.0.55', '2019-11-07 15:57:07');
INSERT INTO `sys_log` VALUES ('6', null, 'admin', '用户注册', '24122', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@3da247ae', '192.168.0.55', '2019-11-07 15:58:09');
INSERT INTO `sys_log` VALUES ('7', null, 'admin', '用户注册', '7517', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@123a6b66', '192.168.0.55', '2019-11-07 15:59:42');
INSERT INTO `sys_log` VALUES ('8', null, 'admin', '用户注册', '5597', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@21179f17', '192.168.0.55', '2019-11-07 16:00:54');
INSERT INTO `sys_log` VALUES ('9', null, 'admin', '用户注册', '13891', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@64e24269', '192.168.0.55', '2019-11-07 16:10:11');
INSERT INTO `sys_log` VALUES ('10', null, 'admin', '用户注册', '7192', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@142565c', '192.168.0.55', '2019-11-07 16:11:59');
INSERT INTO `sys_log` VALUES ('11', null, 'admin', '用户注册', '7278', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@5633ba24', '192.168.0.55', '2019-11-07 16:14:01');
INSERT INTO `sys_log` VALUES ('12', null, 'admin', '用户注册', '26539', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@2e5c12d0', '192.168.0.55', '2019-11-07 16:16:34');
INSERT INTO `sys_log` VALUES ('13', null, 'admin', '用户注册', '7920', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@617494e6', '192.168.0.55', '2019-11-07 16:19:39');
INSERT INTO `sys_log` VALUES ('14', null, 'admin', '用户注册', '5191', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@617494e6', '192.168.0.55', '2019-11-07 16:20:38');
INSERT INTO `sys_log` VALUES ('15', null, 'admin', '用户注册', '9308', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@617494e6', '192.168.0.55', '2019-11-07 16:21:36');
INSERT INTO `sys_log` VALUES ('16', null, 'admin', '用户注册', '7486', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@617494e6', '192.168.0.55', '2019-11-07 16:21:49');
INSERT INTO `sys_log` VALUES ('17', null, 'admin', '用户注册', '11396', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@2e212bb', '192.168.0.55', '2019-11-07 16:27:03');
INSERT INTO `sys_log` VALUES ('18', null, 'admin', '用户注册', '8696', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@29574aaa', '192.168.0.55', '2019-11-07 16:29:49');
INSERT INTO `sys_log` VALUES ('19', null, 'admin', '用户注册', '5601', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@29574aaa', '192.168.0.55', '2019-11-07 16:29:57');
INSERT INTO `sys_log` VALUES ('20', null, 'admin', '用户注册', '17271', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@50fd3c16', '192.168.0.55', '2019-11-07 16:39:41');
INSERT INTO `sys_log` VALUES ('21', null, 'admin', '用户注册', '11175', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@6a7bb879', '192.168.0.55', '2019-11-07 16:41:47');
INSERT INTO `sys_log` VALUES ('22', null, 'admin', '用户注册', '774', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@31ac53f7', '192.168.0.55', '2019-11-07 16:44:53');
INSERT INTO `sys_log` VALUES ('23', '2', 'admin', '用户注册', '1471', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@581ba40b', '192.168.0.55', '2019-11-07 17:37:32');
INSERT INTO `sys_log` VALUES ('24', '3', 'admin', '用户注册', '15', 'com.scott.ds.controller.RegistUserController.registUser()', 'request: org.apache.catalina.connector.RequestFacade@554ec66a', '192.168.0.55', '2019-11-07 17:37:53');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键唯一标识用户',
  `age` int(11) default NULL COMMENT '年龄',
  `userName` varchar(50) default NULL COMMENT '用户名-昵称',
  `sex` int(2) default NULL COMMENT '性别',
  `birthday` datetime default NULL COMMENT '生日',
  `country` varchar(50) default NULL COMMENT '国家',
  `province` varchar(50) default NULL COMMENT '省份',
  `area` varchar(50) default NULL COMMENT '地区',
  `address` varchar(500) default NULL COMMENT '详细地址',
  `language` varchar(200) default NULL COMMENT '浏览器语言',
  `tel` varchar(50) default NULL COMMENT '电话',
  `email` varchar(80) default NULL COMMENT '邮件',
  `company` varchar(100) default NULL COMMENT '公司',
  `status` int(2) default NULL COMMENT '用户状态 0:禁用 1:启用 2:冻结',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '25', 'scott1', '1', '2009-06-16 09:56:56', 'China-中国', '广东省', '深圳市', '南山区深南大道9966-XXXX', 'zh-cn', null, null, null, '1');
INSERT INTO `sys_user` VALUES ('2', '25', 'scott2', '1', '2008-06-16 08:56:56', 'China-中国', '广东省', '深圳市', '南山区深南大道9966-XXXX', 'zh-cn', null, null, null, '1');
INSERT INTO `sys_user` VALUES ('3', '25', 'scott3', '1', '2001-06-16 01:56:56', 'China-中国', '广东省', '深圳市', '南山区深南大道9966-XXXX', 'zh-cn', null, null, null, '1');

-- ----------------------------
-- Table structure for sys_user_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增长唯一标识',
  `user_id` bigint(20) default NULL COMMENT '用户唯一标识',
  `login_ip` varchar(100) default NULL COMMENT '登陆IP地址',
  `login_start_time` datetime default NULL COMMENT '登陆开始时间',
  `login_end_time` datetime default NULL COMMENT '登陆结束时间 - 也可以作为最后一次登陆时间',
  `login_error_times` int(2) default NULL COMMENT '连续登陆失败次数，连续登陆失败3次，冻结账户',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登入记录表';

-- ----------------------------
-- Records of sys_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_screct
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_screct`;
CREATE TABLE `sys_user_screct` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '自增唯一标识',
  `user_id` bigint(20) NOT NULL COMMENT '主键唯一标识用户',
  `account` varchar(50) default NULL COMMENT '用户账户',
  `password` varchar(200) default NULL COMMENT '用户密码',
  `salt` varchar(200) default NULL COMMENT '盐',
  PRIMARY KEY  (`id`,`user_id`),
  CONSTRAINT `账户加密` FOREIGN KEY (`id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户的账户及加密信息';

-- ----------------------------
-- Records of sys_user_screct
-- ----------------------------
INSERT INTO `sys_user_screct` VALUES ('1', '1', 'admin1', 'FBA6F3605EBC657A7FFDF25B085646224A9263EA', 'J9mJ5av6s4BovHVEqQuDvsEijn6yIya5TLeA6rliWvCYQE1FDD7f38oaYF8TbmaW');
INSERT INTO `sys_user_screct` VALUES ('2', '2', 'admin2', '79E3D74D3018542ED1FE86ED0BE1BDC10BAF551A', 'ftLM60ZYEFl4i6P3tSdagCJiBAj3dlNPX9NGX7aYlyPINomXJyJZ5Lpw0BUhddzu');
INSERT INTO `sys_user_screct` VALUES ('3', '3', 'admin3', '48FA96D8784283AA8ACD937606CEE77158E220CA', 'N81jwdcmk1OsdXTCgyPyeKMnpJFqwf6fNuhWAHuO7m7AQPeT15UZFHOhAdzHH24R');
