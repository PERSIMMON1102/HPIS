/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80036
Source Host           : localhost:3306
Source Database       : mybatis2

Target Server Type    : MYSQL
Target Server Version : 80036
File Encoding         : 65001

Date: 2025-01-15 11:53:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `doctors`
-- ----------------------------
DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `specialty` varchar(15) NOT NULL,
  `contact_number` varchar(100) DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of doctors
-- ----------------------------
INSERT INTO `doctors` VALUES ('1', '小明', '脑科', '12123', '13356@qq.com', 'm');
INSERT INTO `doctors` VALUES ('2', '小红', '外科', '1111', '43423@163.com', 'f');
INSERT INTO `doctors` VALUES ('3', '小李', '皮肤科', '111567', '214143@google.com', 'f');
INSERT INTO `doctors` VALUES ('4', '小亮', '骨科', '32432', '33322@qq.com', 'm');

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `date` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `patient_id` FOREIGN KEY (`patient_id`) REFERENCES `t_patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of registration
-- ----------------------------
INSERT INTO `registration` VALUES ('3', '7', '1', '2024-12-09');
INSERT INTO `registration` VALUES ('4', '7', '2', '2024-12-17');
INSERT INTO `registration` VALUES ('5', '7', '3', '2024-12-18');
INSERT INTO `registration` VALUES ('6', '7', '4', '2024-12-30');

-- ----------------------------
-- Table structure for `t_patient`
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` tinyint NOT NULL,
  `sex` char(1) NOT NULL,
  `account` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_patient_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES ('1', '张三', '18', 'f', 'zhangsan', '123', '1');
INSERT INTO `t_patient` VALUES ('2', '李四', '19', 'm', 'lisi', '123', '1');
INSERT INTO `t_patient` VALUES ('7', 'Danny', '20', 'f', 'DD', '111', '2');
INSERT INTO `t_patient` VALUES ('8', 'Danny', '19', 'm', 'DDSS', '111', '2');

-- ----------------------------
-- Table structure for `t_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('1', '管理员');
INSERT INTO `t_type` VALUES ('2', '用户');
