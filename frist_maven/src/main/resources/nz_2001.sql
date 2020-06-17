/*
Navicat MySQL Data Transfer

Source Server         : chelin
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : nz_2001

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-17 19:06:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `location` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '营销部', '深圳宝安区');
INSERT INTO `t_department` VALUES ('2', '研发部', '深圳龙华区');

-- ----------------------------
-- Table structure for `t_employees`
-- ----------------------------
DROP TABLE IF EXISTS `t_employees`;
CREATE TABLE `t_employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employees
-- ----------------------------
INSERT INTO `t_employees` VALUES ('1', '张三', '23', '1');
INSERT INTO `t_employees` VALUES ('2', '李四', '24', '1');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(64) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('190e9ad8b05811eaaae1b025aa35f190', 'xiaomi4');

-- ----------------------------
-- Table structure for `t_passengers`
-- ----------------------------
DROP TABLE IF EXISTS `t_passengers`;
CREATE TABLE `t_passengers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_passengers
-- ----------------------------
INSERT INTO `t_passengers` VALUES ('1001', 'eric', 'M', '2020-06-09 16:21:40');
INSERT INTO `t_passengers` VALUES ('1002', 'jack', 'N', '2020-06-08 16:22:22');

-- ----------------------------
-- Table structure for `t_passports`
-- ----------------------------
DROP TABLE IF EXISTS `t_passports`;
CREATE TABLE `t_passports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nationality` varchar(255) DEFAULT NULL,
  `expire` datetime DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_passports
-- ----------------------------
INSERT INTO `t_passports` VALUES ('1001', 'china', '2020-06-17 16:19:43', '1001');
INSERT INTO `t_passports` VALUES ('1002', 'america', '2020-06-17 16:20:33', '1002');

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', 'xiaomi8');
INSERT INTO `t_product` VALUES ('2', 'xiaomi6');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1001', 'tem', 'M');
INSERT INTO `t_student` VALUES ('1002', 'jack', 'M');
INSERT INTO `t_student` VALUES ('1003', 'marry', 'F');

-- ----------------------------
-- Table structure for `t_student_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_student_subject`;
CREATE TABLE `t_student_subject` (
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`subject_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_subject
-- ----------------------------
INSERT INTO `t_student_subject` VALUES ('10', '1001');
INSERT INTO `t_student_subject` VALUES ('10', '1002');
INSERT INTO `t_student_subject` VALUES ('10', '1003');

-- ----------------------------
-- Table structure for `t_subject`
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `grade` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('10', 'javaSE', '1');
INSERT INTO `t_subject` VALUES ('11', 'javaWeb', '2');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'lisi', '123456', '男', '2020-06-17 11:51:26', '2020-06-17 11:51:26');
INSERT INTO `t_users` VALUES ('2', 'chen', '123456', '男', '2020-06-17 11:51:49', '2020-06-17 11:51:49');
