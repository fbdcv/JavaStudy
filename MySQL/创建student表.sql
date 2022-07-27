 -- 目标：创建一个school数据库
 -- 创建学生表（列，字段） 使用sql创建
 -- 学号 int 登录密码varchar(20) 姓名，性别varcher(2),出生日期(datatime),家庭住址，email
 -- 字段名和表名尽量使用``括起来
 -- auto_increment 自增
 -- 字符串使用单引号或者双引号（一般使用引号）
CREATE DATABASE `school`
 
USE `school` 
 
CREATE TABLE IF NOT EXISTS `student`(
	
	`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
	`name` VARCHAR(30) NOT NULL DEFAULT'匿名'COMMENT '姓名',
	`pwd` VARCHAR(20) NOT NULL DEFAULT '12345' COMMENT '密码',
	`sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
	`birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
	`address` VARCHAR(10) DEFAULT NULL COMMENT '地址',
	`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY(`id`)
	
)ENGINE= INNODB DEFAULT CHARSET = utf8

DROP DATABASE `school`

SHOW CREATE DATABASE `school`
/*
Database	Create Database
school	CREATE DATABASE `school` /*!40100 DEFAULT CHARACTER SET latin1 */
*/
SHOW CREATE TABLE `student`
/*
Table	Create Table
student	CREATE TABLE `student` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `pwd` varchar(20) NOT NULL DEFAULT '12345' COMMENT '密码',
  `sex` varchar(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `address` varchar(10) DEFAULT NULL COMMENT '地址',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
*/

-- 查看表结构
DESC student