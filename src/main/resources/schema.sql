-- 检查数据库是否存在
CREATE DATABASE IF NOT EXISTS test_spring_mvc_mybatis;

USE test_spring_mvc_mybatis;
DROP TABLE IF EXISTS t_user;

-- 检查表是否存在
CREATE TABLE IF NOT EXISTS t_user (
                                      id int(11) NOT NULL AUTO_INCREMENT,
    user_name varchar(32) NOT NULL COMMENT '用户名称',
    note varchar(256) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入测试数据
INSERT INTO t_user (user_name, note) VALUES
                                         ('张三', '测试用户1'),
                                         ('李四', '测试用户2'),
                                         ('王五', '测试用户3');