create table staff
(
    id         int(11)     not null auto_increment,
    staff_name varchar(50) not null default '',
    staff_en   varchar(50),
    staff_pos varchar(50) comment '员工职位',
    department varchar(50) comment '所属部门',
    module     varchar(50) comment '负责模块',
    primary key (id)
) comment 'staff';

create table work_module
(
    id          int(11) not null auto_increment,
    module_name varchar(50),
    work_hour   decimal(22, 4),
    department  varchar(50),
    start_day date,
    end_day date,
    primary key (id)
);

create table task
(
    id int(11) not null auto_increment,
    task_name varchar(100),
    module varchar(50),
    staff_pos varchar(500),
    weight decimal(22,4),
    primary key (id)
);

create table work_detail
(
    id         int(11) not null auto_increment,
    module     varchar(50),
    staff_name varchar(50),
    staff_pos  varchar(50),
    task_name  varchar(100),
    due_day date,
    start_time datetime,
    end_time datetime,
    primary key (id)
);

