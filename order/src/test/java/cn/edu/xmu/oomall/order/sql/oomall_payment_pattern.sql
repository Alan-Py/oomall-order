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

 Date: 16/12/2021 20:53:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oomall_payment_pattern
-- ----------------------------
DROP TABLE IF EXISTS `oomall_payment_pattern`;
CREATE TABLE `oomall_payment_pattern`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` tinyint(0) NULL DEFAULT NULL,
  `begin_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `class_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creator_id` bigint(0) NULL DEFAULT NULL,
  `creator_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modifier_id` bigint(0) NULL DEFAULT NULL,
  `modifier_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oomall_payment_pattern
-- ----------------------------
INSERT INTO `oomall_payment_pattern` VALUES (1, 'wechat', 0, '2021-12-16 14:17:24', '2022-10-01 14:17:30', 'wechat', 1, 'admin', 2, 'xxdd', '2021-12-16 14:23:29', '2021-12-16 14:23:25');

SET FOREIGN_KEY_CHECKS = 1;
