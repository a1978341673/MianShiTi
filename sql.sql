/*
 Navicat Premium Data Transfer

 Source Server         : Mybatis
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : mianshi

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 19/05/2023 01:54:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `rid` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '交易记录id',
  `uid` int UNSIGNED NOT NULL COMMENT '用户id',
  `wid` int UNSIGNED NOT NULL COMMENT '钱包id',
  `money` double UNSIGNED NOT NULL COMMENT '交易金额',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消费类型（1消费，2退款）',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '交易时间',
  `version` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本号',
  PRIMARY KEY (`rid`) USING BTREE,
  INDEX `wid`(`wid` ASC) USING BTREE,
  CONSTRAINT `wid` FOREIGN KEY (`wid`) REFERENCES `wallet` (`wid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of record
-- ----------------------------
BEGIN;
INSERT INTO `record` (`rid`, `uid`, `wid`, `money`, `type`, `time`, `version`) VALUES (1, 1, 2, 10, '1', '2023-05-18 21:33:12', 0), (2, 2, 2, 20, '1', '2023-05-18 21:33:12', 0), (3, 3, 3, 30, '2', '2023-05-18 21:33:12', 0), (4, 1, 1, 20, '1', '2023-05-19 01:13:09', 0), (5, 1, 1, 20, '2', '2023-05-19 01:13:39', 0);
COMMIT;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `wid` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '钱包id',
  `uid` int UNSIGNED NOT NULL COMMENT '用户id',
  `balance` double NOT NULL COMMENT '余额',
  `encoding` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编码',
  `version` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本号',
  PRIMARY KEY (`wid`) USING BTREE,
  UNIQUE INDEX `uid`(`uid` ASC) USING BTREE COMMENT '唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of wallet
-- ----------------------------
BEGIN;
INSERT INTO `wallet` (`wid`, `uid`, `balance`, `encoding`, `version`) VALUES (1, 1, 200, 'a1', 0), (2, 2, 400, 'a2', 0), (3, 3, 600, 'b2', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
