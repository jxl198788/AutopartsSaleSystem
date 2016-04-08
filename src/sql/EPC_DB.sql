/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/4/8 16:09:23                            */
/*==============================================================*/


drop table if exists ass_OE;

drop table if exists ass_brand;

drop table if exists ass_city;

drop table if exists ass_domain;

drop table if exists ass_exception_log;

drop table if exists ass_image;

drop table if exists ass_operate_log;

drop table if exists ass_part;

drop table if exists ass_part_sort;

drop table if exists ass_permission;

drop table if exists ass_producer;

drop table if exists ass_producer_part;

drop table if exists ass_province;

drop table if exists ass_quota;

drop table if exists ass_role;

drop table if exists ass_role_permission;

drop table if exists ass_series;

drop table if exists ass_supplier;

drop table if exists ass_supplier_epc;

drop table if exists ass_supplier_orm;

drop table if exists ass_supplier_relative;

drop table if exists ass_task;

drop table if exists ass_town;

drop table if exists ass_type;

drop table if exists ass_type_oe;

drop table if exists ass_user;

drop table if exists ass_user_role;

/*==============================================================*/
/* Table: ass_OE                                                */
/*==============================================================*/
create table ass_OE
(
   oe_code              varchar(80) not null comment 'oe码',
   name                 varchar(40) not null comment '名称',
   type                 varchar(80) not null comment '型号',
   size                 varchar(80) not null comment '规格',
   description          varchar(255) comment '详情',
   attributes           varchar(2048) comment '参数集，key=value以,分割',
   imgs                 varchar(255) comment '图片集，以,分割',
   part_sort_id         int comment '汽车配件分类id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (oe_code)
);

alter table ass_OE comment 'OE';

/*==============================================================*/
/* Table: ass_brand                                             */
/*==============================================================*/
create table ass_brand
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   img_url              varchar(80) comment '图片地址',
   description          varchar(255) comment '详情',
   create_date          datetime comment '创建日期',
   creator_id           int comment '创建用户id',
   update_date          datetime comment '更新日期',
   updator_id           int comment '更新用户id',
   is_del               char(1) not null default '0' comment '删除标志 0:未删除 1:删除',
   primary key (id)
);

alter table ass_brand comment '汽车生产商';

/*==============================================================*/
/* Table: ass_city                                              */
/*==============================================================*/
create table ass_city
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   code                 varchar(11) comment '代号',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_city comment '城市';

/*==============================================================*/
/* Table: ass_domain                                            */
/*==============================================================*/
create table ass_domain
(
   id                   int not null auto_increment comment 'id',
   supplier_id          int not null comment '企业id',
   user_id              int comment '根管理员id',
   domain_name          varchar(80) not null comment '域名',
   status               char(1) not null comment '状态',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_domain comment '域名';

/*==============================================================*/
/* Table: ass_exception_log                                     */
/*==============================================================*/
create table ass_exception_log
(
   id                   int not null auto_increment comment 'id',
   thread               varchar(45) comment '线程名',
   level                varchar(45) comment '异常级别',
   class_name           varchar(45) comment '类名',
   message              varchar(255) comment '具体信息',
   location             varchar(255) comment '发生位置',
   create_date          datetime comment '创建时间',
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_exception_log comment '异常日记';

/*==============================================================*/
/* Table: ass_image                                             */
/*==============================================================*/
create table ass_image
(
   id                   int not null auto_increment,
   name                 varchar(20),
   url                  varchar(80),
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_image comment '图片';

/*==============================================================*/
/* Table: ass_operate_log                                       */
/*==============================================================*/
create table ass_operate_log
(
   id                   int not null auto_increment comment 'id',
   type                 varchar(10) comment '操作类型',
   content              varchar(255) comment '操作内容',
   user_id              int comment '用户id',
   user_name            varchar(40) comment '用户名称',
   user_company         varchar(40) comment '用户所属公司',
   operation_time       varchar(255) comment '操作时间',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_operate_log comment '操作日志';

/*==============================================================*/
/* Table: ass_part                                              */
/*==============================================================*/
create table ass_part
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '配件名称',
   type                 varchar(80) not null comment '型号',
   size                 varchar(80) not null comment '规格',
   description          varchar(255) comment '详情',
   attributes           varchar(2048) comment '参数集，以,分割',
   imgs                 varchar(255) comment '图片集',
   part_sort_id         int comment '汽车配件分类id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_part comment '汽车配件';

/*==============================================================*/
/* Table: ass_part_sort                                         */
/*==============================================================*/
create table ass_part_sort
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   parent_id            int comment 'parent_id 0:表示根',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_part_sort comment '汽车配件分类';

/*==============================================================*/
/* Table: ass_permission                                        */
/*==============================================================*/
create table ass_permission
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   type                 varchar(32) not null comment '权限类型',
   url                  varchar(80) comment 'url地址',
   percode              varchar(255) comment '权限代码字符串',
   parentid             int comment '父节点id',
   parentids            varchar(255) comment '父结点id列表串',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_permission comment '权限';

/*==============================================================*/
/* Table: ass_producer                                          */
/*==============================================================*/
create table ass_producer
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   email                varchar(80) comment '邮箱',
   phone                varchar(20) comment '固定电话',
   fax                  varchar(20) comment '传真',
   telephone            varchar(11) comment '手机',
   website              varchar(80) comment '公司网址',
   description          varchar(255) comment '公司简介',
   img_url              varchar(80) comment '公司logo图标',
   address              varchar(80) comment '公司详细地址',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_producer comment '汽车配件厂';

/*==============================================================*/
/* Table: ass_producer_part                                     */
/*==============================================================*/
create table ass_producer_part
(
   id                   int not null auto_increment comment 'id',
   product_code         varchar(80) comment '参照编码',
   oe_code              varchar(80) comment 'OE码',
   producer_id          int comment '汽车配件厂Id',
   part_id              int comment '汽车配件id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_producer_part comment '原厂配件表';

/*==============================================================*/
/* Table: ass_province                                          */
/*==============================================================*/
create table ass_province
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   code                 varchar(11) not null comment '代号',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_province comment '省份';

/*==============================================================*/
/* Table: ass_quota                                             */
/*==============================================================*/
create table ass_quota
(
   id                   int not null auto_increment comment 'id',
   quota                int not null comment '配额',
   supplier_id          int not null comment '公司id',
   permission_id        int not null comment '权限id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_quota comment '配额';

/*==============================================================*/
/* Table: ass_role                                              */
/*==============================================================*/
create table ass_role
(
   id                   int not null auto_increment,
   name                 varchar(40) not null,
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_role comment '角色';

/*==============================================================*/
/* Table: ass_role_permission                                   */
/*==============================================================*/
create table ass_role_permission
(
   id                   int not null auto_increment,
   role_id              int not null,
   permission_id        int not null,
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_role_permission comment '角色权限表';

/*==============================================================*/
/* Table: ass_series                                            */
/*==============================================================*/
create table ass_series
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   brand_id             int comment '汽车品牌id',
   create_date          datetime comment '创建日期',
   creator_id           int comment '创建人id',
   update_date          datetime comment '更新日期',
   updator_id           int comment '更新人id',
   is_del               char(1) not null default '0' comment '删除标志',
   primary key (id)
);

alter table ass_series comment '车系';

/*==============================================================*/
/* Table: ass_supplier                                          */
/*==============================================================*/
create table ass_supplier
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   business_license_url varchar(80) comment '营业执照url',
   province             varchar(11) comment '省份代号',
   city                 varchar(11) comment '城市代号',
   town                 varchar(11) comment '城镇代号',
   addr                 varchar(80) comment '地址',
   linkman              varchar(20) comment '联系人',
   telphone             varchar(11) comment '联系电话',
   group_id             char(1) not null comment '企业类型 0：供应商 1：分销商 2：维修厂',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier comment '企业';

/*==============================================================*/
/* Table: ass_supplier_epc                                      */
/*==============================================================*/
create table ass_supplier_epc
(
   id                   int not null auto_increment comment 'id',
   oe_code              varchar(80) comment 'oe码',
   product_name         varchar(40) comment '配件名称',
   type                 varchar(80) comment '型号',
   size                 varchar(80) comment '规格',
   attributes           varchar(1024) comment '参数集',
   part_sort_id         int comment '汽车配件分类id',
   supplier_id          int comment '企业id',
   type_id              int comment '车型id',
   status               char(1) comment '状态',
   platform_status      char(1) comment '平台状态',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_epc comment '企业epc';

/*==============================================================*/
/* Table: ass_supplier_orm                                      */
/*==============================================================*/
create table ass_supplier_orm
(
   id                   int not null auto_increment comment 'id',
   supplier_no          varchar(80) comment '供应商编码',
   oe_code              varchar(80) comment 'oe码',
   big_product_no       varchar(80) comment '大厂编码',
   small_product_no     varchar(80) comment '小厂编码',
   produer_name         varchar(40) comment '供应商品牌',
   part_name            varchar(40) comment '配件名称',
   first_price          float comment '一级价格',
   second_price         float comment '二级价格',
   third_price          float comment '三级价格',
   supplier_id          int comment '企业id',
   status               char(1) comment '状态',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_orm comment '企业orm';

/*==============================================================*/
/* Table: ass_supplier_relative                                 */
/*==============================================================*/
create table ass_supplier_relative
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) comment '名称',
   supplier_id          int comment '公司id',
   parent_id            int comment '父节点id  0：根节点',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_relative comment '企业关系';

/*==============================================================*/
/* Table: ass_task                                              */
/*==============================================================*/
create table ass_task
(
   id                   int not null auto_increment comment 'id',
   code                 varchar(255) comment '编号',
   title                varchar(40) comment '主题',
   submit_user_id       int comment '提交用户id',
   submit_date          datetime comment '提交任务时间',
   role_id              int comment '审核角色id',
   finish_user_id       int comment '审核用户id',
   end_date             date comment '任务完成时间',
   status               char(1) comment '任务状态 0：未完成 1：已完成',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_task comment '任务';

/*==============================================================*/
/* Table: ass_town                                              */
/*==============================================================*/
create table ass_town
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '名称',
   code                 varchar(11) comment '代号',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_town comment '城镇';

/*==============================================================*/
/* Table: ass_type                                              */
/*==============================================================*/
create table ass_type
(
   id                   int not null auto_increment comment 'id',
   displacement         varchar(20) not null comment '排量',
   manufacture_year     varchar(10) not null comment '年款',
   engine_type          varchar(20) not null comment '引擎类型',
   horsepower           int comment '马力',
   power                int comment '功率',
   body_type            varchar(80) comment '车身类型',
   origin               varchar(80) comment '产地',
   description          varchar(255) comment '详情',
   series_id            int comment '车系id',
   create_date          datetime,
   creator_id           int,
   update_date          int,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_type comment '车型';

/*==============================================================*/
/* Table: ass_type_oe                                           */
/*==============================================================*/
create table ass_type_oe
(
   id                   int not null auto_increment comment 'id',
   oe_code              varchar(80) not null comment 'oe编码',
   type_id              int not null comment '车型Id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_type_oe comment '车型-OE关系表';

/*==============================================================*/
/* Table: ass_user                                              */
/*==============================================================*/
create table ass_user
(
   id                   int not null auto_increment comment 'id',
   telphone             varchar(20) comment '手机号码',
   username             varchar(20) not null comment '用户名',
   realname             varchar(20) comment '真实姓名',
   password             varchar(32) comment '密码',
   job                  varchar(20) comment '职位',
   email                varchar(80) not null comment '邮箱',
   address              varchar(255) comment '地址',
   gruop                char(1) not null comment '用户类别 0：平台 1：企业',
   is_root              char(1) not null comment '是否根管理员',
   suppiler_id          int comment '企业id',
   locked               char(1) not null comment '是否被锁定',
   salt                 varchar(11) comment '盐',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_user comment '用户';

/*==============================================================*/
/* Table: ass_user_role                                         */
/*==============================================================*/
create table ass_user_role
(
   id                   int not null auto_increment,
   role_id              int not null,
   user_id              int not null,
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_user_role comment '用户角色表';

alter table ass_OE add constraint FK_FK_partSort_OE foreign key (part_sort_id)
      references ass_part_sort (id) on delete restrict on update restrict;

alter table ass_domain add constraint FK_FK_supplier_domain foreign key (supplier_id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_domain add constraint FK_FK_user_domain foreign key (user_id)
      references ass_user (id) on delete restrict on update restrict;

alter table ass_operate_log add constraint FK_FK_user_operateLog foreign key (user_id)
      references ass_user (id) on delete restrict on update restrict;

alter table ass_part add constraint FK_FK_partSort_part foreign key (part_sort_id)
      references ass_part_sort (id) on delete restrict on update restrict;

alter table ass_producer_part add constraint FK_FK_part_producerPart foreign key (part_id)
      references ass_part (id) on delete restrict on update restrict;

alter table ass_producer_part add constraint FK_FK_producer_producerPart foreign key (producer_id)
      references ass_producer (id) on delete restrict on update restrict;

alter table ass_quota add constraint FK_FK_permission_quota foreign key (permission_id)
      references ass_permission (id) on delete restrict on update restrict;

alter table ass_quota add constraint FK_FK_supplier_quota foreign key (supplier_id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_role_permission add constraint FK_FK_permission_rolePermission foreign key (permission_id)
      references ass_permission (id) on delete restrict on update restrict;

alter table ass_role_permission add constraint FK_FK_role_rolePermission foreign key (role_id)
      references ass_role (id) on delete restrict on update restrict;

alter table ass_series add constraint FK_FK_brand_series foreign key (brand_id)
      references ass_brand (id) on delete restrict on update restrict;

alter table ass_supplier_epc add constraint FK_FK_partSort_EPC foreign key (part_sort_id)
      references ass_part_sort (id) on delete restrict on update restrict;

alter table ass_supplier_epc add constraint FK_FK_series_EPC foreign key (type_id)
      references ass_type (id) on delete restrict on update restrict;

alter table ass_supplier_epc add constraint FK_FK_supplier_EPC foreign key (supplier_id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_supplier_orm add constraint FK_FK_supplier_ORM foreign key (id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_supplier_relative add constraint FK_FK_quota foreign key (supplier_id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_task add constraint FK_FK_role_task foreign key (role_id)
      references ass_role (id) on delete restrict on update restrict;

alter table ass_task add constraint FK_FK_user_task foreign key (submit_user_id)
      references ass_user (id) on delete restrict on update restrict;

alter table ass_task add constraint FK_FK_user_task2 foreign key (finish_user_id)
      references ass_user (id) on delete restrict on update restrict;

alter table ass_type add constraint FK_FK_series_type foreign key (series_id)
      references ass_series (id) on delete restrict on update restrict;

alter table ass_type_oe add constraint FK_FK_OE_typeOE foreign key (oe_code)
      references ass_OE (oe_code) on delete restrict on update restrict;

alter table ass_type_oe add constraint FK_FK_type_TypeOE foreign key (type_id)
      references ass_type (id) on delete restrict on update restrict;

alter table ass_user add constraint FK_FK_supplier_user foreign key (suppiler_id)
      references ass_supplier (id) on delete restrict on update restrict;

alter table ass_user_role add constraint FK_FK_role_userRole foreign key (role_id)
      references ass_role (id) on delete restrict on update restrict;

alter table ass_user_role add constraint FK_FK_user_userRole foreign key (user_id)
      references ass_user (id) on delete restrict on update restrict;

