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

 Date: 16/12/2021 20:53:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oomall_refund
-- ----------------------------
DROP TABLE IF EXISTS `oomall_refund`;
CREATE TABLE `oomall_refund`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `trade_sn` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pattern_id` bigint(0) NULL DEFAULT NULL,
  `payment_id` bigint(0) NULL DEFAULT NULL,
  `amount` bigint(0) NULL DEFAULT NULL,
  `document_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `document_type` tinyint(0) NULL DEFAULT NULL,
  `refund_time` datetime(0) NULL DEFAULT NULL,
  `state` tinyint(0) NULL DEFAULT NULL,
  `descr` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adjust_id` bigint(0) NULL DEFAULT NULL,
  `adjust_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adjust_time` datetime(0) NULL DEFAULT NULL,
  `creator_id` bigint(0) NULL DEFAULT NULL,
  `creator_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modifier_id` bigint(0) NULL DEFAULT NULL,
  `modifier_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oomall_refund
-- ----------------------------
INSERT INTO `oomall_refund` VALUES (1, '岛市老八', 1, 1, 10000, 'dds', 0, '2021-12-16 14:44:36', 1, '无', 1, 'admin', '2021-12-16 14:47:45', 1, 'admin', 1, 'admin', '2021-12-16 14:48:14', '2021-12-16 14:48:10');
INSERT INTO `oomall_refund` VALUES (2, '岛市老八', 1, 1, 10000, '2402', 0, '2021-12-16 14:44:36', 1, '无', 1, 'admin', '2021-12-16 14:47:45', 1, 'admin', 1, 'admin', '2021-12-16 14:48:14', '2021-12-16 14:48:10');

SET FOREIGN_KEY_CHECKS = 1;
