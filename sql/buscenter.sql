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

 Date: 31/10/2018 15:29:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for driver_info
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别',
  `age` tinyint(11) NOT NULL COMMENT '年龄',
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `telephone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号',
  `Company_id` tinyint(4) NOT NULL COMMENT '所属公司',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `photo_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片路径',
  `license_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '驾驶证路径',
  `health_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '体检信息路径',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `incharge_line` tinyint(4) NOT NULL COMMENT '所属路线',
  `created_time` datetime NOT NULL COMMENT '登记日期',
  `modified_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `grade` tinyint(4) NULL DEFAULT NULL COMMENT '评级分数',
  `complaint_count` tinyint(4) NULL DEFAULT NULL COMMENT '受到投诉次数',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '驾驶员状态,1表示被禁用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '驾驶员信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of driver_info
-- ----------------------------
INSERT INTO `driver_info` VALUES (13, '1002', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:39', '2018-10-26 10:41:39', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (14, '1003', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:43', '2018-10-26 10:41:43', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (15, '1004', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:45', '2018-10-26 10:41:45', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (16, '1005', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:49', '2018-10-26 10:41:49', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (17, '1006', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:52', '2018-10-26 10:41:52', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (18, '1007', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:55', '2018-10-26 10:41:55', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (19, '1008', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:41:58', '2018-10-26 10:41:58', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (20, '1009', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:42:01', '2018-10-26 10:42:01', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (21, '10010', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:42:05', '2018-10-26 13:30:43', 9, 2, b'1');
INSERT INTO `driver_info` VALUES (23, '10012', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:42:11', '2018-10-26 13:30:43', 9, 2, b'1');
INSERT INTO `driver_info` VALUES (24, '10013', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', 24, '2018-10-26 10:42:11', '2018-10-26 10:44:09', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (25, '1001', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', 24, '2018-10-31 08:18:18', '2018-10-31 10:44:56', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (26, '1001', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', 24, '2018-10-31 10:01:37', '2018-10-31 10:44:56', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (27, '1001', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', 24, '2018-10-31 10:02:18', '2018-10-31 10:44:56', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (28, '1001', '张三', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', 24, '2018-10-31 10:41:30', '2018-10-31 10:41:30', 9, 2, b'0');
INSERT INTO `driver_info` VALUES (29, '1001', '李四', b'0', 28, '131002199408204046', '13185471256', 0, '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', 24, '2018-10-31 15:17:39', '2018-10-31 15:18:20', 9, 2, b'0');

SET FOREIGN_KEY_CHECKS = 1;
