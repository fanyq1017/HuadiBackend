/*
 Navicat Premium Data Transfer

 Source Server         : vivion
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : huadiupdate

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 17/07/2022 13:40:01
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
  `publish_date` datetime(0) NULL DEFAULT NULL COMMENT '第一次发布时间',
  `edit_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '文章编辑时间\"类似最后一次修改的时间\"',
  `md_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '管理员发布的markdown文件的源码',
  `html_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT 'html源码',
  `state` int(0) NULL DEFAULT NULL COMMENT '0代表草稿箱，1代表已发表，2代表已删除',
  `type` int(0) NULL DEFAULT NULL COMMENT '0志愿活动1新闻2专题活动之类的',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布文件的标题',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for help
-- ----------------------------
DROP TABLE IF EXISTS `help`;
CREATE TABLE `help`  (
  `h_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '帮扶表中help的唯一标识',
  `h_helper` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '帮助其他人的人',
  `h_publishDate` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '项目发布日期',
  `h_helpertel` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '帮助者的电话号码',
  `h_helpedtel` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '被帮助者的电话号码',
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表，主要设计用户。用户：0，管理员：1，超级管理员：2' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '123456', 1, 0, '123');
INSERT INTO `user` VALUES (2, 'aaa', '123', 1, 0, '123');
INSERT INTO `user` VALUES (3, 'aaa', '123', 1, 0, '123');
INSERT INTO `user` VALUES (4, 'aaa', '123', 1, 0, '123');
INSERT INTO `user` VALUES (5, 'aaa', '123', 1, 0, '123');
INSERT INTO `user` VALUES (6, 'aaa', '123', 1, 0, '123');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `v_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `v_title` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '视频标题',
  `v_type` int(0) NOT NULL COMMENT '多媒体类型，类似0视频1图片2文本3网页',
  `v_publishDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '项目发布日期',
  `v_location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件路径',
  `v_intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '多媒体的介绍',
  `v_image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '可以代表多媒体的图片',
  PRIMARY KEY (`v_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '多媒体资源库video表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for voluntary_project
-- ----------------------------
DROP TABLE IF EXISTS `voluntary_project`;
CREATE TABLE `voluntary_project`  (
  `p_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `p_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `p_type` int(0) NULL DEFAULT NULL COMMENT '项目服务类别0是疫情防控1是卫生健康2是社区服务3是环境保护',
  `p_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目地点',
  `p_publishDate` date NULL DEFAULT NULL COMMENT '项目发布日期',
  `p_editTime` date NULL DEFAULT NULL COMMENT '招募结束时间',
  `p_projectStart` date NULL DEFAULT NULL COMMENT '项目开始时间',
  `p_projectEnd` date NULL DEFAULT NULL COMMENT '项目结束时间',
  `p_recruitStart` date NULL DEFAULT NULL COMMENT '招募开始时间',
  `p_recruitEnd` date NULL DEFAULT NULL COMMENT '招募结束时间',
  `p_serveclient` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务对象信息',
  `p_Info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目信息',
  `p_people` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目负责人，为了方便不与用户做外键',
  `p_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '负责人联系方式',
  `p_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '能展示项目信息图片的位置',
  `p_provinceregioncode` int(0) NULL DEFAULT NULL COMMENT '省编号（四川省遂宁市船山区）（北京市东城区）',
  `p_cityregioncode` int(0) NULL DEFAULT NULL COMMENT '市编号',
  `p_districtregioncode` int(0) NULL DEFAULT NULL COMMENT '区编号',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of voluntary_project
-- ----------------------------
INSERT INTO `voluntary_project` VALUES (1, '全员核酸', 0, '合肥市巢湖市烔炀镇人民政府', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-17', '2022-07-16', '2022-07-17', '	社会公众', '现场秩序维护及信息录入', '聂汉明', '13586573384', 'image/vonlunteerImage1.png', 340000, 340100, 340181);
INSERT INTO `voluntary_project` VALUES (2, '疫情防控', 1, '遂宁市船山区凯丽滨江-一期', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-24', '2022-07-16', '2022-07-24', '	城镇居民,其他', '在辖区开展疫情防控，排查风险区返遂人员', '章立春', '18114356724', 'image/vonlunteerImage2.png', 510000, 510900, 510903);
INSERT INTO `voluntary_project` VALUES (3, '健康教育知识讲座', 1, '遂宁市船山区平寨村', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-16', '社会公众', '2022-7-16上午09:30-10:30开展健康讲座', '利栏', '18932069760', 'image/vonlunteerImage2.png', 510000, 510900, 510903);
INSERT INTO `voluntary_project` VALUES (4, '城区道路交通劝导员 ', 2, '遂宁市船山区太和大道北段', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-17', '2022-07-16', '2022-07-16', '残障人士,妇女,老年人,儿童', '对射洪市城区部分街道交通不文明行为进行劝阻', '邓韬', '15828935360', 'image/vonlunteerImage3.png', 510000, 510900, 510903);
INSERT INTO `voluntary_project` VALUES (5, '	\r\n人居环境整治行动', 3, '遂宁市船山区X195', '2022-07-16', '2022-07-16', '2022-07-16', '2022-07-25', '2022-07-16', '2022-07-24', '	农村居民,城镇居民,社会公众', '为进一步加强人居环境整治，建设生态宜居美丽乡村，7月17日，云山社区开展辖区人居环境整治行动。', '段桓村', '18758425243', 'image/vonlunteerImage4.png', 510000, 510900, 510903);
INSERT INTO `voluntary_project` VALUES (6, '征集生物多样性科普作品', 3, '北京市昌平区北京王府学校', '2022-03-22', '2022-07-16', '2022-03-22', '2022-09-22', '2022-03-22', '2022-09-22', '社会公众,儿童', '长期征集具有科普性的生物多样性作品如漫画、幽默感人小故事、自拍呼吁保护野生动物视频、野生动物保护创意策划书等；形式不限，要求原创（无版权纠纷） 符合条件的作品可获得志愿服务证书，公益活动时长', '大东', '13370142146', 'image/vonlunteerImage4.png', 110000, 110100, 110101);
INSERT INTO `voluntary_project` VALUES (7, '暖心365流动儿童关爱207202期', 2, '	东城区崇文门东大街24号', '2021-07-20', '2022-07-16', '2021-07-20', '2022-07-19', '2021-07-20', '2022-07-19', '	残障人士,优抚对象,其他,儿童', '空闲时间，居家制作支教小视频，在线进行支教服务', '暖暖', '13564326786', 'image/vonlunteerImage3.png', 110000, 110100, 110101);
INSERT INTO `voluntary_project` VALUES (8, '周末大扫除', 2, '东城区南门仓胡同5号解放军总医院第七医学中心综合服务楼西侧', '2021-07-20', '2022-07-16', '2022-07-21', '2022-07-25', '2022-07-21', '2022-07-24', '	其他', '参与志愿者2021年7月24日上午9:00前于综合服务楼西侧集合，着力清理社区垃圾及擦拭所有宣传栏。请志愿者准时到达集合地点，开展活动。', '王柜赋', '13520862875', 'image/vonlunteerImage3.png', 110000, 110100, 110101);

SET FOREIGN_KEY_CHECKS = 1;
