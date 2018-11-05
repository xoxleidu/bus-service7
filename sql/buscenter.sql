/*
Navicat MySQL Data Transfer

Source Server         : buscenter
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : buscenter

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-11-05 10:59:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_basis
-- ----------------------------
DROP TABLE IF EXISTS `bus_basis`;
CREATE TABLE `bus_basis` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_type` varchar(20) DEFAULT NULL COMMENT '车辆类型',
  `license_number` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `bus_length` double(50,0) DEFAULT NULL COMMENT '车长',
  `bus_wide` double(50,0) DEFAULT NULL COMMENT '车身宽',
  `bus_high` double(50,0) DEFAULT NULL COMMENT '车身高',
  `seating` int(50) unsigned DEFAULT NULL COMMENT '座位',
  `factory_brand` int(50) unsigned DEFAULT NULL COMMENT '厂牌号',
  `path_id` int(10) unsigned DEFAULT NULL COMMENT '路线id',
  `station_id` int(10) unsigned DEFAULT NULL COMMENT '站点id（0：未知）',
  `operation_state` int(2) DEFAULT NULL COMMENT '运营状态（0：运营中  -1：非运营）',
  `station_status` int(1) unsigned DEFAULT NULL COMMENT '进出站状态（0：站外 1：站内）',
  `up_downStream` int(1) unsigned DEFAULT NULL COMMENT '上下行状态（0：上行  1：下行）',
  `GSP_id` int(10) unsigned DEFAULT NULL COMMENT '经纬度id',
  `registration_number` int(10) unsigned DEFAULT NULL COMMENT '车辆登记编号',
  `engine_no` int(10) unsigned DEFAULT NULL COMMENT '发动机号',
  `identification_code` varchar(20) DEFAULT NULL COMMENT '车辆识别码',
  `registration_date` datetime DEFAULT NULL COMMENT '登记日期',
  `maintenanceid` varchar(20) DEFAULT NULL COMMENT '验车信息',
  `affiliation_company` varchar(20) DEFAULT NULL COMMENT '所属公司',
  `fuel_consumption` varchar(20) DEFAULT NULL COMMENT '油耗',
  `air_Conditioned` int(1) unsigned DEFAULT NULL COMMENT '空调车标记（0：默认  1：空调车  2：非空调车）',
  `manufacture_date` datetime DEFAULT NULL COMMENT '出厂日期',
  `faultid` varchar(20) DEFAULT NULL COMMENT '事故信息',
  `driving_km` double(10,0) DEFAULT NULL COMMENT '行驶公里',
  `bus_note` varchar(20) DEFAULT NULL COMMENT '车辆备注',
  PRIMARY KEY (`id`),
  KEY `license_number` (`license_number`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_basis
-- ----------------------------
INSERT INTO `bus_basis` VALUES ('2', '城市公交', '冀R88888', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-10-26 00:00:00', '已检验', '中交天枢', '30L', '0', '2018-10-26 00:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('3', '城市公交', '冀R88888', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-10-26 00:00:00', '已检验', '中交天枢', '30L', '0', '2018-10-26 00:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('21', '城市公交', '冀R88882', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-02 10:27:32', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('22', '城市公交', '冀R88882', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-02 10:28:10', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('23', '城市公交', '冀R88882', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-02 10:39:05', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('24', '城市公交', '冀R88882', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-02 10:39:34', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('25', '城市公交', '冀R88844', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-02 13:33:34', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');

-- ----------------------------
-- Table structure for driver_info
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `employee_id` varchar(30) NOT NULL COMMENT '员工号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL COMMENT '性别',
  `age` tinyint(11) NOT NULL COMMENT '年龄',
  `idcard` char(18) NOT NULL COMMENT '身份证号',
  `telephone` char(11) NOT NULL COMMENT '电话号',
  `Company_id` tinyint(4) NOT NULL COMMENT '所属公司',
  `address` varchar(100) NOT NULL COMMENT '家庭住址',
  `photo_path` varchar(100) NOT NULL COMMENT '照片路径',
  `license_path` varchar(100) NOT NULL COMMENT '驾驶证路径',
  `health_path` varchar(100) NOT NULL COMMENT '体检信息路径',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `incharge_line` tinyint(4) NOT NULL COMMENT '所属路线',
  `created_time` datetime NOT NULL COMMENT '登记日期',
  `modified_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `grade` tinyint(4) DEFAULT NULL COMMENT '评级分数',
  `complaint_count` tinyint(4) DEFAULT NULL COMMENT '受到投诉次数',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '驾驶员状态,1表示被禁用',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `employee_id` (`employee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='驾驶员信息表';

-- ----------------------------
-- Records of driver_info
-- ----------------------------
INSERT INTO `driver_info` VALUES ('13', '1002', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:39', '2018-10-26 10:41:39', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('14', '1003', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:43', '2018-10-26 10:41:43', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('15', '1004', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:45', '2018-10-26 10:41:45', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('16', '1005', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:49', '2018-10-26 10:41:49', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('17', '1006', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:52', '2018-10-26 10:41:52', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('18', '1007', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:55', '2018-10-26 10:41:55', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('19', '1008', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:41:58', '2018-10-26 10:41:58', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('20', '1009', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:42:01', '2018-10-26 10:42:01', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('21', '10010', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:42:05', '2018-10-26 13:30:43', '9', '2', '');
INSERT INTO `driver_info` VALUES ('23', '10012', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:42:11', '2018-10-26 13:30:43', '9', '2', '');
INSERT INTO `driver_info` VALUES ('24', '10013', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '', '', '测试测试123', '24', '2018-10-26 10:42:11', '2018-10-26 10:44:09', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('25', '1001', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', '24', '2018-10-31 08:18:18', '2018-10-31 10:44:56', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('26', '1001', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', '24', '2018-10-31 10:01:37', '2018-10-31 10:44:56', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('27', '1001', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', '24', '2018-10-31 10:02:18', '2018-10-31 10:44:56', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('28', '1001', '张三', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', '24', '2018-10-31 10:41:30', '2018-10-31 10:41:30', '9', '2', '\0');
INSERT INTO `driver_info` VALUES ('29', '1001', '李四', '\0', '28', '131002199408204046', '13185471256', '0', '河北省廊坊市广阳区万达广场', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '201-10-18-wsdassda.jpg', '测试测试123', '24', '2018-10-31 15:17:39', '2018-10-31 15:18:20', '9', '2', '\0');

-- ----------------------------
-- Table structure for fault_info
-- ----------------------------
DROP TABLE IF EXISTS `fault_info`;
CREATE TABLE `fault_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fault_time` datetime DEFAULT NULL COMMENT '故障时间',
  `fault_content` varchar(20) DEFAULT NULL COMMENT '故障内容',
  `solution` varchar(20) DEFAULT NULL COMMENT '解决方案',
  `failure_frequency` int(10) unsigned DEFAULT NULL COMMENT '故障次数',
  `license_number` varchar(20) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`id`),
  KEY `licenseNumber` (`license_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fault_info
-- ----------------------------
INSERT INTO `fault_info` VALUES ('1', '2018-10-22 00:00:00', '爆胎', '等待救援', '1', '冀R88888');
INSERT INTO `fault_info` VALUES ('4', '2018-10-28 08:00:00', '爆胎2', '等待救援', '1', '冀R88884');
INSERT INTO `fault_info` VALUES ('5', '2018-10-28 08:00:00', '爆胎2', '等待救援', '1', '冀R88887');
INSERT INTO `fault_info` VALUES ('6', '2018-10-28 08:00:00', '爆胎', '等待救援', '1', '冀R88882');
INSERT INTO `fault_info` VALUES ('7', '2018-10-28 08:00:00', '爆胎', '等待救援', '1', '冀R88884');

-- ----------------------------
-- Table structure for maintenance_info
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_info`;
CREATE TABLE `maintenance_info` (
  `id` int(10) NOT NULL,
  `maintenance_date` datetime DEFAULT NULL,
  `maintenance_plant` varchar(20) DEFAULT NULL,
  `maintenance_content` varchar(20) DEFAULT NULL,
  `next_maintenance_date` datetime DEFAULT NULL,
  `licenseNumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintenance_info
-- ----------------------------
