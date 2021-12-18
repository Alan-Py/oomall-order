/*
 Navicat Premium Data Transfer

 Source Server         : Library_management
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : oomall

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 16/12/2021 20:52:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oomall_order
-- ----------------------------
DROP TABLE IF EXISTS `oomall_order`;
CREATE TABLE `oomall_order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(0) NULL DEFAULT NULL,
  `shop_id` bigint(0) NULL DEFAULT NULL,
  `order_sn` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pid` bigint(0) NULL DEFAULT NULL,
  `consignee` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `region_id` bigint(0) NULL DEFAULT NULL,
  `address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `advancesale_id` bigint(0) NULL DEFAULT NULL,
  `groupon_id` bigint(0) NULL DEFAULT NULL,
  `express_fee` bigint(0) NULL DEFAULT NULL,
  `discount_price` bigint(0) NULL DEFAULT NULL,
  `origin_price` bigint(0) NULL DEFAULT NULL,
  `point` bigint(0) NULL DEFAULT NULL,
  `confirm_time` datetime(0) NULL DEFAULT NULL,
  `shipment_sn` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` int(0) NULL DEFAULT NULL,
  `be_deleted` tinyint(0) NULL DEFAULT NULL,
  `creator_id` bigint(0) NULL DEFAULT NULL,
  `creator_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modifier_id` bigint(0) NULL DEFAULT NULL,
  `modifier_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oomall_order
-- ----------------------------
INSERT INTO `oomall_order` VALUES (2400, 1, 2, 'dds', 2, 'pany', 123, '大司马', '111111111', '大司马哈哈哈', 15155, 15151, 212, 2121, 212, 212, '2021-12-23 16:05:14', '212', 101, 0, 212, '大司马马马马', 212, '冬泳怪鸽', '2021-12-12 16:05:22', '2021-12-12 16:05:26');
INSERT INTO `oomall_order` VALUES (2401, 1, 2, 'dsds', 2, 'pany', 123, '大司马', '111111111', '保国马', 15155, 15151, 212, 2121, 212, 212, '2021-12-23 16:05:14', '212', 500, 0, 212, '大司马马马马', 212, '冬泳怪鸽', '2021-12-12 16:05:22', '2021-12-15 16:19:52');
INSERT INTO `oomall_order` VALUES (2403, 1, 2, 'dsdd', 2, 'pany', 123, '大司马', '111111111', 'string', 15155, 15151, 212, 2121, 212, 212, '2021-12-23 16:05:14', '212', 200, 0, 212, '大司马马马马', 212, '冬泳怪鸽', '2021-12-12 16:05:22', '2021-12-15 15:51:05');

SET FOREIGN_KEY_CHECKS = 1;
