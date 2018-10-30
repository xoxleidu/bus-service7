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

 Date: 30/10/2018 14:41:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_health
-- ----------------------------
DROP TABLE IF EXISTS `driver_health`;
CREATE TABLE `driver_health`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` int(20) NOT NULL COMMENT '员工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `record_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档案编号',
  `height` int(11) NOT NULL COMMENT '身高',
  `left_vision` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '左眼视力',
  `right_vision` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '右眼视力',
  `color_blindness` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否色盲',
  `left_cisualcorrection` bit(1) NOT NULL DEFAULT b'0' COMMENT '左眼是否矫正',
  `right_cisualcorrection` bit(1) NOT NULL DEFAULT b'0' COMMENT '右眼是否矫正',
  `dyskinesia` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否运动功能障碍',
  `left_earhearing` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '左耳听力',
  `right_earhearing` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '右耳听力',
  `upperlimb_condition` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上肢状况',
  `lowerlimb_condition` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '下肢状态',
  `independy_sit` bit(1) NOT NULL DEFAULT b'0' COMMENT '双下肢缺失或者丧失运动功能障碍是否能够自主坐立',
  `disease_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病备注',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE,
  CONSTRAINT `driver_health_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `driver_info` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '驾驶员体检信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for driver_info
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` int(20) NOT NULL COMMENT '员工号',
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
  `modified_time` timestamp NULL DEFAULT '2018-10-30 08:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `grade` tinyint(4) NULL DEFAULT NULL COMMENT '评级分数',
  `complaint_count` tinyint(4) NULL DEFAULT NULL COMMENT '受到投诉次数',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '驾驶员状态,1表示被禁用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '驾驶员信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for driver_license
-- ----------------------------
DROP TABLE IF EXISTS `driver_license`;
CREATE TABLE `driver_license`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` int(11) NOT NULL COMMENT '员工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `license_age` tinyint(4) NOT NULL COMMENT '驾龄',
  `license_type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证类型',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `license_expirydate` datetime NOT NULL COMMENT '驾驶证到期时间',
  `license_point` tinyint(4) NOT NULL COMMENT '驾驶证分数',
  `license_id` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证档案编号',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '车辆状态,0表示车辆正常1表示车辆被删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE,
  CONSTRAINT `driver_license_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `driver_info` (`employee_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '司机驾驶证信息表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
