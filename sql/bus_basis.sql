/*
Navicat MySQL Data Transfer

Source Server         : Bus
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : bus

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-11-01 16:46:54
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
  KEY `license_number` (`license_number`),
  CONSTRAINT `bus_basis_ibfk_1` FOREIGN KEY (`license_number`) REFERENCES `fault_info` (`license_number`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus_basis
-- ----------------------------
INSERT INTO `bus_basis` VALUES ('1', '城市公交1', '冀R88887', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-10-26 00:00:00', '已检验', '中交天枢', '30L', '0', '2018-10-26 00:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('2', '城市公交', '冀R88888', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-10-29 17:41:49', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
INSERT INTO `bus_basis` VALUES ('3', '城市公交', '冀R88888', '11530', '2500', '3040', '40', '111111', '1', '0', '-1', '1', '0', '0', '22222', '33333', '44444', '2018-11-01 16:14:53', '已检验', '中交天枢', '30L', '0', '2018-10-26 08:00:00', null, '55555', '测试信息66666');
