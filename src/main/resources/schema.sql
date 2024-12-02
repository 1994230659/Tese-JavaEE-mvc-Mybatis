-- 检查数据库是否存在
CREATE DATABASE IF NOT EXISTS test_spring_mvc_mybatis;

USE test_spring_mvc_mybatis;
DROP TABLE IF EXISTS t_user;

-- 学生表
DROP TABLE IF EXISTS t_student;
CREATE TABLE t_student (
                           id INT(11) NOT NULL AUTO_INCREMENT,
                           student_name VARCHAR(32) NOT NULL COMMENT '学生姓名',
                           student_no VARCHAR(20) NOT NULL COMMENT '学号',
                           gender TINYINT(1) DEFAULT 1 COMMENT '性别：1-男，2-女',
                           grade VARCHAR(20) DEFAULT NULL COMMENT '年级',
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                           update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (id),
                           UNIQUE KEY uk_student_no (student_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';

-- 教师表
DROP TABLE IF EXISTS t_teacher;
CREATE TABLE t_teacher (
                           id INT(11) NOT NULL AUTO_INCREMENT,
                           teacher_name VARCHAR(32) NOT NULL COMMENT '教师姓名',
                           teacher_no VARCHAR(20) NOT NULL COMMENT '教师编号',
                           title VARCHAR(20) DEFAULT NULL COMMENT '职称',
                           create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                           update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (id),
                           UNIQUE KEY uk_teacher_no (teacher_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师表';

-- 课程表
DROP TABLE IF EXISTS t_course;
CREATE TABLE t_course (
                          id INT(11) NOT NULL AUTO_INCREMENT,
                          course_name VARCHAR(50) NOT NULL COMMENT '课程名称',
                          course_code VARCHAR(20) NOT NULL COMMENT '课程代码',
                          credit INT(2) DEFAULT 0 COMMENT '学分',
                          teacher_id INT(11) NOT NULL COMMENT '授课教师ID',
                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
                          update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (id),
                          UNIQUE KEY uk_course_code (course_code),
                          CONSTRAINT fk_course_teacher FOREIGN KEY (teacher_id) REFERENCES t_teacher (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

-- 选课记录表（学生与课程的多对多关系）
DROP TABLE IF EXISTS t_student_course;
CREATE TABLE t_student_course (
                                  id INT(11) NOT NULL AUTO_INCREMENT,
                                  student_id INT(11) NOT NULL COMMENT '学生ID',
                                  course_id INT(11) NOT NULL COMMENT '课程ID',
                                  score DECIMAL(5,2) DEFAULT NULL COMMENT '成绩',
                                  select_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '选课时间',
                                  PRIMARY KEY (id),
                                  UNIQUE KEY uk_student_course (student_id, course_id),
                                  CONSTRAINT fk_sc_student FOREIGN KEY (student_id) REFERENCES t_student (id),
                                  CONSTRAINT fk_sc_course FOREIGN KEY (course_id) REFERENCES t_course (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='选课记录表';

-- 插入测试数据
INSERT INTO t_student (student_name, student_no, gender, grade) VALUES
                                                                    ('张三', '2021001', 1, '大二'),
                                                                    ('李四', '2021002', 2, '大一'),
                                                                    ('王五', '2021003', 1, '大三');

INSERT INTO t_teacher (teacher_name, teacher_no, title) VALUES
                                                            ('王教授', 'T2021001', '教授'),
                                                            ('李讲师', 'T2021002', '讲师'),
                                                            ('赵副教授', 'T2021003', '副教授');

INSERT INTO t_course (course_name, course_code, credit, teacher_id) VALUES
                                                                        ('Java程序设计', 'C001', 4, 1),
                                                                        ('数据库原理', 'C002', 3, 2),
                                                                        ('操作系统', 'C003', 4, 3);

INSERT INTO t_student_course (student_id, course_id, score) VALUES
                                                                (1, 1, 85.5),
                                                                (1, 2, 90.0),
                                                                (2, 1, 78.5),
                                                                (3, 3, 92.0);