/*
 Navicat Premium Data Transfer

 Source Server         : 本机数据库
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : buscenter

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 25/10/2018 13:42:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_info
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别',
  `age` tinyint(11) NOT NULL COMMENT '年龄',
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `telephone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号',
  `Company_id` tinyint(4) NOT NULL COMMENT '所属公司',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `photo_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片路径',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `incharge_line` tinyint(4) NOT NULL COMMENT '所属路线',
  `created_time` datetime NOT NULL COMMENT '登记日期',
  `modified_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `grade` tinyint(4) NULL DEFAULT NULL COMMENT '评级分数',
  `complaint_count` tinyint(4) NULL DEFAULT NULL COMMENT '受到投诉次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '驾驶员信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for driver_license
-- ----------------------------
DROP TABLE IF EXISTS `driver_license`;
CREATE TABLE `driver_license`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` int(11) NOT NULL COMMENT '员工号',
  `license_age` tinyint(4) NOT NULL COMMENT '驾龄',
  `license_type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证类型',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `license_expirydate` datetime NOT NULL COMMENT '驾驶证到期时间',
  `license_point` tinyint(4) NOT NULL COMMENT '驾驶证分数',
  `license_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证档案编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '司机驾驶证信息表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
