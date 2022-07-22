DROP TABLE IF EXISTS patient;
CREATE TABLE patient(
    p_id INT NOT NULL AUTO_INCREMENT  COMMENT '病人id' ,
    p_name VARCHAR(90)    COMMENT '病人姓名' ,
    p_password VARCHAR(255)    COMMENT '密码' ,
    p_tel VARCHAR(32)    COMMENT '家长电话号码' ,
    p_date DATETIME    COMMENT '创建时间' ,
    p_wechat VARCHAR(255)    COMMENT '家长微信' ,
    p_birthday DATETIME    COMMENT '生日' ,
    p_gender VARCHAR(255)    COMMENT '性别;男 女' ,
    p_weight DECIMAL(24,6)    COMMENT '体重' ,
    p_eat VARCHAR(32)    COMMENT '喂养方式;母乳/奶粉/其他' ,
    PRIMARY KEY (p_id)
)  COMMENT = '患者';

DROP TABLE IF EXISTS doctor;
CREATE TABLE doctor(
       doc_id INT NOT NULL AUTO_INCREMENT  COMMENT '医生id' ,
       doc_name VARCHAR(90)    COMMENT '医生姓名' ,
       doc_password VARCHAR(255)    COMMENT '密码' ,
       doc_tel VARCHAR(255)    COMMENT '医生电话' ,
       doc_date DATETIME    COMMENT '创建时间' ,
       doc_wechat VARCHAR(255)    COMMENT '微信' ,
       doc_reserve INT    COMMENT '预约人数限制' ,
       doc_fee VARCHAR(255)    COMMENT '挂号费用' ,
       doc_dept INT    COMMENT '医生所属科室' ,
       doc_title VARCHAR(255)    COMMENT '医生的职称' ,
       PRIMARY KEY (doc_id)
)  COMMENT = '医生';


DROP TABLE IF EXISTS reserve;
CREATE TABLE reserve(
    r_id INT NOT NULL AUTO_INCREMENT  COMMENT '挂号id' ,
    p_id INT    COMMENT '病人id' ,
    doc_id INT    COMMENT '医生id' ,
    r_date DATETIME    COMMENT '创建时间' ,
    r_meeting_date DATETIME    COMMENT '预约时间' ,
    r_fee DECIMAL(24,6)    COMMENT '挂号费用' ,
    r_state INT    COMMENT '挂号状态;预约失败是0， 预约成功是1，取消预约2，挂号结束3' ,
    PRIMARY KEY (r_id)
)  COMMENT = '挂号';


DROP TABLE IF EXISTS dept;
CREATE TABLE dept(
    dept_id INT NOT NULL AUTO_INCREMENT  COMMENT '科室id' ,
    dept_name VARCHAR(90)    COMMENT '科室名称' ,
    dept_master INT    COMMENT '科室主任' ,
    dept_date DATETIME    COMMENT '科室创建时间' ,
    dept_num INT    COMMENT '科室人数' ,
    PRIMARY KEY (dept_id)
)  COMMENT = '科室';

DROP TABLE IF EXISTS imagelog;
CREATE TABLE imagelog(
 img_id INT NOT NULL AUTO_INCREMENT  COMMENT '图片id' ,
 p_id INT    COMMENT '病人id' ,
 img_date DATETIME    COMMENT '上传时间' ,
 img_dir VARCHAR(900)    COMMENT '图片保存路径' ,
 detect_result VARCHAR(255)    COMMENT '算法识别结果' ,
 doc_result INT    COMMENT '医生判别结果;对机器识别结果进行修正' ,
 doc_id INT    COMMENT '医生id;纠正识别结果的医生id' ,
 img_color VARCHAR(32)    COMMENT '患者自我辨别颜色;患者自我辨别颜色' ,
 PRIMARY KEY (img_id)
)  COMMENT = '上传图片';

DROP TABLE IF EXISTS prescription;
CREATE TABLE prescription(
    pre_id INT NOT NULL AUTO_INCREMENT  COMMENT '处方id' ,
    doc_id INT    COMMENT '医生id' ,
    p_id INT    COMMENT '病人id' ,
    r_id INT    COMMENT '挂号id' ,
    pre_date DATETIME    COMMENT '创建时间' ,
    pre_content VARCHAR(900)    COMMENT '处方内容' ,
    PRIMARY KEY (pre_id)
)  COMMENT = '处方';

DROP TABLE IF EXISTS fee;
CREATE TABLE fee(
    f_id INT NOT NULL AUTO_INCREMENT  COMMENT '付款id' ,
    f_num DECIMAL(24,6)    COMMENT '付款金额' ,
    p_id DECIMAL(24,6)    COMMENT '付款人' ,
    f_date DATETIME    COMMENT '创建时间' ,
    f_pay VARCHAR(255)    COMMENT '付款渠道' ,
    f_pay_account VARCHAR(255)    COMMENT '付款账号' ,
    r_id INT    COMMENT '挂号id' ,
    PRIMARY KEY (f_id)
)  COMMENT = '缴费管理';

DROP TABLE IF EXISTS Admin;
CREATE TABLE Admin(
    admin_id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    admin_name VARCHAR(255)    COMMENT '用户名' ,
    admin_tel VARCHAR(255)    COMMENT '电话号码' ,
    admin_date DATETIME    COMMENT '创建时间' ,
    admin_password VARCHAR(255)    COMMENT '密码' ,
    admin_power VARCHAR(32)    COMMENT '管理员权限' ,
    PRIMARY KEY (admin_id)
)  COMMENT = '管理员';

DROP TABLE IF EXISTS Log;
CREATE TABLE Log(
    log_id INT NOT NULL AUTO_INCREMENT  COMMENT '日志id' ,
    log_url VARCHAR(900)    COMMENT '访问url' ,
    log_ip VARCHAR(255)    COMMENT '访问的IP地址' ,
    log_date DATETIME    COMMENT '访问时间' ,
    p_id INT    COMMENT '患者id' ,
    doc_id INT    COMMENT '医生Id' ,
    admin_id INT    COMMENT '管理员id' ,
    PRIMARY KEY (log_id)
)  COMMENT = '日志管理';

DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment(
    a_id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    doc_id INT    COMMENT '医生id' ,
    num INT    COMMENT '剩余数量' ,
    date DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (a_id)
)  COMMENT = '挂号查询';

/* 插入字典总表[Item-数据字典条目] */
INSERT INTO SYS_DICT(KEY_,LABEL,INTRO,REVISION) VALUES('Item','数据字典条目','',1);
/* 插入字典明细表 */
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','milk_powder','奶粉','1','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','breast_milk','母乳','2','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','gray','灰白色','3','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','light_green','浅绿色','4','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','lgith_yellow','浅黄色','5','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','green','深绿色','6','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','yellow','黄色','7','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','red','红色','8','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','orange','橙色','9','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','admin','普通管理员','10','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','root','超级管理员','11','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','M','男','12','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','F','女','13','',1);
INSERT INTO SYS_DICT_ITEM(DICT_KEY,KEY_,LABEL,SORT_,INTRO,REVISION) VALUES('Item','U','未知','14','',1);




