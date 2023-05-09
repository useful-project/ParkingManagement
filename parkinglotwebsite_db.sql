/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : parkinglotwebsite_db

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2023-03-02 14:04:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carport`
-- ----------------------------
DROP TABLE IF EXISTS `carport`;
CREATE TABLE `carport` (
  `id` int(11) NOT NULL auto_increment,
  `categoryid` int(11) default NULL COMMENT '区域ID',
  `name` varchar(255) default NULL COMMENT '车位号',
  `status` varchar(255) default NULL COMMENT '状态',
  `content` text COMMENT '备注',
  PRIMARY KEY  (`id`),
  KEY `fk_carport_category` (`categoryid`),
  CONSTRAINT `fk_carport_category` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carport
-- ----------------------------
INSERT INTO `carport` VALUES ('3634', '30', '001', '空', null);
INSERT INTO `carport` VALUES ('3635', '30', '002', '空', null);
INSERT INTO `carport` VALUES ('3636', '30', '003', '空', null);
INSERT INTO `carport` VALUES ('3637', '30', '004', '空', null);
INSERT INTO `carport` VALUES ('3638', '30', '005', '空', null);
INSERT INTO `carport` VALUES ('3639', '30', '006', '空', null);
INSERT INTO `carport` VALUES ('3640', '30', '007', '空', null);
INSERT INTO `carport` VALUES ('3641', '30', '008', '空', null);
INSERT INTO `carport` VALUES ('3642', '30', '009', '空', '');
INSERT INTO `carport` VALUES ('3643', '30', '010', '空', null);
INSERT INTO `carport` VALUES ('3644', '31', '001', '空', null);
INSERT INTO `carport` VALUES ('3645', '31', '002', '空', null);
INSERT INTO `carport` VALUES ('3646', '31', '003', '空', null);
INSERT INTO `carport` VALUES ('3647', '31', '004', '空', null);
INSERT INTO `carport` VALUES ('3648', '31', '005', '空', null);
INSERT INTO `carport` VALUES ('3649', '31', '006', '空', null);
INSERT INTO `carport` VALUES ('3650', '31', '007', '空', null);
INSERT INTO `carport` VALUES ('3651', '31', '008', '空', null);
INSERT INTO `carport` VALUES ('3652', '31', '009', '空', null);
INSERT INTO `carport` VALUES ('3653', '31', '010', '满', '<div><ul><li><span>车牌号:鄂A UX558</span></li><li><span>进场时间:2023-02-14 13:09:02</span></li><li><span>车主:闫慧</span></li><li><span>联系电话:13856769122</span></li></ul></div>');
INSERT INTO `carport` VALUES ('3654', '31', '011', '空', '');
INSERT INTO `carport` VALUES ('3655', '31', '012', '满', '<div><ul><li><span>车牌号:鄂A UX557</span></li><li><span>进场时间:2023-02-14 13:08:57</span></li><li><span>车主:闫慧</span></li><li><span>联系电话:13856769122</span></li></ul></div>');
INSERT INTO `carport` VALUES ('3656', '31', '013', '空', null);
INSERT INTO `carport` VALUES ('3657', '31', '014', '空', null);
INSERT INTO `carport` VALUES ('3658', '31', '015', '空', null);
INSERT INTO `carport` VALUES ('3659', '31', '016', '空', null);
INSERT INTO `carport` VALUES ('3660', '31', '017', '空', '');
INSERT INTO `carport` VALUES ('3661', '31', '018', '空', null);
INSERT INTO `carport` VALUES ('3662', '31', '019', '空', null);
INSERT INTO `carport` VALUES ('3663', '31', '020', '空', null);
INSERT INTO `carport` VALUES ('3684', '32', '001', '空', null);
INSERT INTO `carport` VALUES ('3685', '32', '002', '空', null);
INSERT INTO `carport` VALUES ('3686', '32', '003', '空', null);
INSERT INTO `carport` VALUES ('3687', '32', '004', '空', null);
INSERT INTO `carport` VALUES ('3688', '32', '005', '空', null);
INSERT INTO `carport` VALUES ('3689', '32', '006', '空', null);
INSERT INTO `carport` VALUES ('3690', '32', '007', '空', '');
INSERT INTO `carport` VALUES ('3691', '32', '008', '空', null);
INSERT INTO `carport` VALUES ('3692', '32', '009', '空', null);
INSERT INTO `carport` VALUES ('3693', '32', '010', '空', null);

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment COMMENT '名称',
  `name` varchar(255) default NULL COMMENT '类别名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('30', 'A区');
INSERT INTO `category` VALUES ('31', 'B区');
INSERT INTO `category` VALUES ('32', 'C区');

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `id` int(11) NOT NULL auto_increment COMMENT '价格',
  `price` decimal(10,2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES ('1', '3.50');

-- ----------------------------
-- Table structure for `imgadv`
-- ----------------------------
DROP TABLE IF EXISTS `imgadv`;
CREATE TABLE `imgadv` (
  `id` int(11) NOT NULL auto_increment,
  `filename` varchar(255) default NULL COMMENT '图片文件名',
  `url` varchar(255) default NULL COMMENT '链接地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imgadv
-- ----------------------------
INSERT INTO `imgadv` VALUES ('6', '60950cc6-9fcf-40f9-9c12-3ec87054b452.jpg', 'aa');

-- ----------------------------
-- Table structure for `loginip`
-- ----------------------------
DROP TABLE IF EXISTS `loginip`;
CREATE TABLE `loginip` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '操作员',
  `addr` varchar(255) default NULL COMMENT 'IP地址',
  `content` text COMMENT '内容',
  `savetime` varchar(255) default NULL COMMENT '时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginip
-- ----------------------------
INSERT INTO `loginip` VALUES ('988', 'admin', '127.0.0.1', '用户【admin】于2023-02-14 14:02:30退出系统！', '2023-02-14 14:02:30');
INSERT INTO `loginip` VALUES ('989', '周娜', '127.0.0.1', '用户【周娜】于2023-02-14 14:03:12登录系统！', '2023-02-14 14:03:12');
INSERT INTO `loginip` VALUES ('990', 'admin', '127.0.0.1', '用户【admin】于2023-02-14 14:08:21登录系统！', '2023-02-14 14:08:21');
INSERT INTO `loginip` VALUES ('991', '杨刚', '127.0.0.1', '用户【杨刚】于2023-02-14 14:09:41登录系统！', '2023-02-14 14:09:41');
INSERT INTO `loginip` VALUES ('992', 'admin', '127.0.0.1', '用户【admin】于2023-02-14 14:14:40退出系统！', '2023-02-14 14:14:40');
INSERT INTO `loginip` VALUES ('993', '杨刚', '127.0.0.1', '用户【杨刚】于2023-02-14 14:14:43登录系统！', '2023-02-14 14:14:43');
INSERT INTO `loginip` VALUES ('994', 'admin', '127.0.0.1', '用户【admin】于2023-03-02 13:06:47登录系统！', '2023-03-02 13:06:47');
INSERT INTO `loginip` VALUES ('995', 'admin', '127.0.0.1', '用户【admin】于2023-03-02 13:07:03登录系统！', '2023-03-02 13:07:03');
INSERT INTO `loginip` VALUES ('996', '闫慧', '127.0.0.1', '用户【闫慧】于2023-03-02 14:01:00登录系统！', '2023-03-02 14:01:00');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(255) default NULL COMMENT '用户名',
  `upass` varchar(255) default NULL COMMENT '密码',
  `tname` varchar(255) default NULL COMMENT '姓名',
  `filename` varchar(255) default NULL COMMENT '图片文件名',
  `tel` varchar(255) default NULL COMMENT '电话',
  `audit` varchar(255) default NULL COMMENT '审核状态',
  `status` varchar(255) default NULL COMMENT '冻结状态',
  `wallet` decimal(10,2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'H001', '123', '闫慧', '0286836f-4c74-4cef-81fa-20843849cb95.png', '13856769122', '已通过', '正常', '3000.00');
INSERT INTO `member` VALUES ('2', 'H002', '123', '周娜', '70d27f94-3157-49dd-9049-9d8e4be08a93.png', '13895554311', '已通过', '正常', '6.50');
INSERT INTO `member` VALUES ('3', 'H003', '123', '周芳', '19f307f4-87b9-445f-861c-c9e6f4536ed1.jpg', '13734419914', '已通过', '正常', '0.00');
INSERT INTO `member` VALUES ('4', 'H004', '123', '杨刚', 'cee4c971-9add-42ac-952a-d4d85ce25d94.jpg', '13890766759', '已通过', '正常', '13.00');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL auto_increment,
  `memberid` int(11) default NULL COMMENT '注册用户ID',
  `content` text COMMENT '留言内容',
  `savetime` varchar(255) default NULL COMMENT '留言时间',
  `hfcontent` text COMMENT '回复内容',
  PRIMARY KEY  (`id`),
  KEY `memberid` (`memberid`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`memberid`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('24', '4', '这里不满30分钟不计费', '2023-02-14 14:10:29', 'ok');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL COMMENT '标题',
  `filename` varchar(255) default NULL COMMENT '图片文件名',
  `content` text COMMENT '内容',
  `savetime` varchar(255) default NULL COMMENT '时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('3', '关于对外开放停车场的公告', '33463bf0-b890-481a-a613-e5847dfbdbb9.jpg', '<p style=\"text-indent:2em;\">北关停车场（绿化文化广场边，开放车位43个）、东台停车场（东台路二手家具城对面，开放车位98个）、翼龙路丁字停车场（原老电影院处，开放车位185个）、桃儿沟路南侧停车场（盘旋路处，开放车位87个）、安广茗苑C区地下停车场（开放车位99个）、金鹰小区地下停车场（开放车位25个），环江花园E区地下停车场（开放车位57个），城上城地下停车场（开放车位126个），南苑北区地下停车场（开放车位63个），南苑南区地下停车场（开放车位96个），雍城世家地下停车场（开放车位180个），富润小康家园地下停车场（开放车位477个），惠农公寓地下停车场（开放车位69个）。</p>', '2023-02-13 23:13:36');
INSERT INTO `news` VALUES ('4', '事关城区智慧停车场', '97a25d89-ee49-463a-80f5-cb3b30c7c932.jpg', '近年来，随着我市经济高速发展，市民总体经济水平普遍提高，市区机动车保有量显著增加，市区停车矛盾突显。根据宣城市智慧城市建设和数字政府转型有关精神要求，为健全新型城市智慧停车，市城市运营公司加速推进智慧停车平台、市区公共停车场、路侧停车泊位的智慧化升级改造和运营管理工作。', '2023-02-13 23:14:12');

-- ----------------------------
-- Table structure for `site`
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `id` int(11) NOT NULL auto_increment,
  `filename` varchar(255) default NULL COMMENT '网站商标',
  `name` varchar(255) default NULL COMMENT '站点名称',
  `copyright` varchar(255) default NULL COMMENT '站点版权',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site
-- ----------------------------
INSERT INTO `site` VALUES ('1', '5eb3fc50-575a-4379-923a-18e81ec9187a.jpg', '停车库管理系统', '停车库管理系统');

-- ----------------------------
-- Table structure for `stoprecord`
-- ----------------------------
DROP TABLE IF EXISTS `stoprecord`;
CREATE TABLE `stoprecord` (
  `id` int(11) NOT NULL auto_increment,
  `ddno` varchar(255) default NULL COMMENT '订单号',
  `memberid` int(11) default NULL COMMENT '注册用户ID',
  `carportid` int(11) default NULL COMMENT '车位ID',
  `carno` varchar(255) default NULL COMMENT '车牌号',
  `stime` varchar(255) default NULL COMMENT '进场时间',
  `etime` varchar(255) default NULL COMMENT '离场时间',
  `longtime` bigint(11) default NULL COMMENT '时长',
  `total` decimal(10,2) default NULL COMMENT '停车费',
  `status` varchar(255) default NULL COMMENT '状态',
  `categoryid` int(11) default NULL COMMENT '区域',
  PRIMARY KEY  (`id`),
  KEY `fk_stoprecord_member` (`memberid`),
  KEY `fk_stoprecord_carport` (`carportid`),
  KEY `categoryid` (`categoryid`),
  CONSTRAINT `stoprecord_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stoprecord_carport` FOREIGN KEY (`carportid`) REFERENCES `carport` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stoprecord_member` FOREIGN KEY (`memberid`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stoprecord
-- ----------------------------
INSERT INTO `stoprecord` VALUES ('1', 'T869729', '1', '3690', '鄂N 66666', '2023-03-02 14:01:10', '2023-03-02 14:01:11', '0', '0.00', '交易完成', '32');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(255) default NULL COMMENT '登录名',
  `upass` varchar(255) default NULL COMMENT '密码',
  `tname` varchar(255) default NULL COMMENT '姓名',
  `filename` varchar(255) default NULL COMMENT '图片文件名',
  `tel` varchar(255) default NULL COMMENT '电话',
  `email` varchar(255) default NULL,
  `role` varchar(255) default NULL COMMENT '角色',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', 'admin', '624bae15-2765-4f0d-bfa3-8021f0f1aaa3.jpg', '13789071124', '138907600151@126.com', '管理员');
