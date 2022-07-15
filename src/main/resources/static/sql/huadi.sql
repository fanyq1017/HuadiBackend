/*
 Navicat Premium Data Transfer

 Source Server         : vivion
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : huadi

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 14/07/2022 15:11:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '发布信息的唯一标识',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布文件的标题',
  `u_id` int(0) NULL DEFAULT NULL COMMENT '发布作者的id',
  `publishdate` datetime(0) NULL DEFAULT NULL COMMENT '第一次发布时间',
  `edittime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '文章编辑时间\"类似最后一次修改的时间\"',
  `mdContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '管理员发布的markdown文件的源码',
  `htmlContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT 'html源码',
  `state` int(0) NULL DEFAULT NULL COMMENT '0代表草稿箱，1代表已发表，2代表已删除',
  `type` int(0) NULL DEFAULT NULL COMMENT '0志愿活动1新闻2专题活动之类的',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for help
-- ----------------------------
DROP TABLE IF EXISTS `help`;
CREATE TABLE `help`  (
  `h_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '帮扶表中help的唯一标识',
  `h_help` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '帮助其他人的人',
  `h_helped` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '被帮扶的人，就是发布求助需求的人',
  `h_type` int(0) NOT NULL COMMENT '0是帮扶关系未形成，1是帮扶关系已形成',
  `h_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '帮扶信息',
  PRIMARY KEY (`h_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '雷锋热线中的帮扶表，只需打开列表查询帮扶相关信息即可' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit`  (
  `r_ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `r_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '参加者名字',
  `r_want` int(0) NOT NULL COMMENT '希望参与的志愿活动类型,如0代表关爱老人1代表呵护儿童等',
  `r_intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '参加招募的志愿者的自我介绍',
  PRIMARY KEY (`r_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'xx志愿者的招募(recruit表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识组',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `type` int(0) NOT NULL COMMENT '0是用户，1是管理员，2是超级管理员',
  `valid` int(0) NOT NULL COMMENT '0是无效，1是有效',
  `telephone` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户电话',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表，主要设计用户。用户：0，管理员：1，超级管理员：2' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `v_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `v_type` int(0) NOT NULL COMMENT '多媒体类型，类似0视频1图片2文本3网页',
  `v_location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件路径',
  `v_intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '多媒体的介绍',
  `v_image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '可以代表多媒体的图片',
  PRIMARY KEY (`v_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '多媒体资源库video表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for voluntaryproject
-- ----------------------------
DROP TABLE IF EXISTS `voluntaryproject`;
CREATE TABLE `voluntaryproject`  (
  `p_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `p_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `p_type` int(0) NULL DEFAULT NULL COMMENT '项目服务类别0应急救援之类的',
  `p_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目地点',
  `p_publishDate` datetime(0) NULL DEFAULT NULL COMMENT '项目发布日期',
  `p_projectStart` datetime(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `p_projectEnd` datetime(0) NULL DEFAULT NULL COMMENT '项目结束时间',
  `recruitStart` datetime(0) NULL DEFAULT NULL COMMENT '招募开始时间',
  `recruitEnd` datetime(0) NULL DEFAULT NULL COMMENT '招募结束时间',
  `serveclient` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务对象信息',
  `p_Info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目信息',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
