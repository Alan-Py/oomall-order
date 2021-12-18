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

 Date: 16/12/2021 20:52:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oomall_payment
-- ----------------------------
DROP TABLE IF EXISTS `oomall_payment`;
CREATE TABLE `oomall_payment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `trade_sn` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pattern_id` bigint(0) NULL DEFAULT NULL,
  `amount` bigint(0) NULL DEFAULT NULL,
  `actual_amount` bigint(0) NULL DEFAULT NULL,
  `document_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `document_type` tinyint(0) NULL DEFAULT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
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
-- Records of oomall_payment
-- ----------------------------
INSERT INTO `oomall_payment` VALUES (1, '马报国', 1, 10000, 9000, 'dsdd', 0, '2021-12-16 14:28:57', '2021-12-15 14:29:00', '2021-12-17 14:29:06', 1, '无', 1, 'admin', '2021-12-16 14:30:47', 1, '无', NULL, NULL, '2021-12-16 14:24:54', '2021-12-16 14:31:05');

SET FOREIGN_KEY_CHECKS = 1;
