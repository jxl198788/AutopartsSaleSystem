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
   oe_code              varchar(80) not null comment 'oe��',
   name                 varchar(40) not null comment '����',
   type                 varchar(80) not null comment '�ͺ�',
   size                 varchar(80) not null comment '���',
   description          varchar(255) comment '����',
   attributes           varchar(2048) comment '��������key=value��,�ָ�',
   imgs                 varchar(255) comment 'ͼƬ������,�ָ�',
   part_sort_id         int comment '�����������id',
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
   name                 varchar(40) not null comment '����',
   img_url              varchar(80) comment 'ͼƬ��ַ',
   description          varchar(255) comment '����',
   create_date          datetime comment '��������',
   creator_id           int comment '�����û�id',
   update_date          datetime comment '��������',
   updator_id           int comment '�����û�id',
   is_del               char(1) not null default '0' comment 'ɾ����־ 0:δɾ�� 1:ɾ��',
   primary key (id)
);

alter table ass_brand comment '����������';

/*==============================================================*/
/* Table: ass_city                                              */
/*==============================================================*/
create table ass_city
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   code                 varchar(11) comment '����',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_city comment '����';

/*==============================================================*/
/* Table: ass_domain                                            */
/*==============================================================*/
create table ass_domain
(
   id                   int not null auto_increment comment 'id',
   supplier_id          int not null comment '��ҵid',
   user_id              int comment '������Աid',
   domain_name          varchar(80) not null comment '����',
   status               char(1) not null comment '״̬',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_domain comment '����';

/*==============================================================*/
/* Table: ass_exception_log                                     */
/*==============================================================*/
create table ass_exception_log
(
   id                   int not null auto_increment comment 'id',
   thread               varchar(45) comment '�߳���',
   level                varchar(45) comment '�쳣����',
   class_name           varchar(45) comment '����',
   message              varchar(255) comment '������Ϣ',
   location             varchar(255) comment '����λ��',
   create_date          datetime comment '����ʱ��',
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_exception_log comment '�쳣�ռ�';

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

alter table ass_image comment 'ͼƬ';

/*==============================================================*/
/* Table: ass_operate_log                                       */
/*==============================================================*/
create table ass_operate_log
(
   id                   int not null auto_increment comment 'id',
   type                 varchar(10) comment '��������',
   content              varchar(255) comment '��������',
   user_id              int comment '�û�id',
   user_name            varchar(40) comment '�û�����',
   user_company         varchar(40) comment '�û�������˾',
   operation_time       varchar(255) comment '����ʱ��',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_operate_log comment '������־';

/*==============================================================*/
/* Table: ass_part                                              */
/*==============================================================*/
create table ass_part
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '�������',
   type                 varchar(80) not null comment '�ͺ�',
   size                 varchar(80) not null comment '���',
   description          varchar(255) comment '����',
   attributes           varchar(2048) comment '����������,�ָ�',
   imgs                 varchar(255) comment 'ͼƬ��',
   part_sort_id         int comment '�����������id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_part comment '�������';

/*==============================================================*/
/* Table: ass_part_sort                                         */
/*==============================================================*/
create table ass_part_sort
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   parent_id            int comment 'parent_id 0:��ʾ��',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_part_sort comment '�����������';

/*==============================================================*/
/* Table: ass_permission                                        */
/*==============================================================*/
create table ass_permission
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   type                 varchar(32) not null comment 'Ȩ������',
   url                  varchar(80) comment 'url��ַ',
   percode              varchar(255) comment 'Ȩ�޴����ַ���',
   parentid             int comment '���ڵ�id',
   parentids            varchar(255) comment '�����id�б�',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_permission comment 'Ȩ��';

/*==============================================================*/
/* Table: ass_producer                                          */
/*==============================================================*/
create table ass_producer
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   email                varchar(80) comment '����',
   phone                varchar(20) comment '�̶��绰',
   fax                  varchar(20) comment '����',
   telephone            varchar(11) comment '�ֻ�',
   website              varchar(80) comment '��˾��ַ',
   description          varchar(255) comment '��˾���',
   img_url              varchar(80) comment '��˾logoͼ��',
   address              varchar(80) comment '��˾��ϸ��ַ',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_producer comment '���������';

/*==============================================================*/
/* Table: ass_producer_part                                     */
/*==============================================================*/
create table ass_producer_part
(
   id                   int not null auto_increment comment 'id',
   product_code         varchar(80) comment '���ձ���',
   oe_code              varchar(80) comment 'OE��',
   producer_id          int comment '���������Id',
   part_id              int comment '�������id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_producer_part comment 'ԭ�������';

/*==============================================================*/
/* Table: ass_province                                          */
/*==============================================================*/
create table ass_province
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   code                 varchar(11) not null comment '����',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_province comment 'ʡ��';

/*==============================================================*/
/* Table: ass_quota                                             */
/*==============================================================*/
create table ass_quota
(
   id                   int not null auto_increment comment 'id',
   quota                int not null comment '���',
   supplier_id          int not null comment '��˾id',
   permission_id        int not null comment 'Ȩ��id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_quota comment '���';

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

alter table ass_role comment '��ɫ';

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

alter table ass_role_permission comment '��ɫȨ�ޱ�';

/*==============================================================*/
/* Table: ass_series                                            */
/*==============================================================*/
create table ass_series
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   brand_id             int comment '����Ʒ��id',
   create_date          datetime comment '��������',
   creator_id           int comment '������id',
   update_date          datetime comment '��������',
   updator_id           int comment '������id',
   is_del               char(1) not null default '0' comment 'ɾ����־',
   primary key (id)
);

alter table ass_series comment '��ϵ';

/*==============================================================*/
/* Table: ass_supplier                                          */
/*==============================================================*/
create table ass_supplier
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   business_license_url varchar(80) comment 'Ӫҵִ��url',
   province             varchar(11) comment 'ʡ�ݴ���',
   city                 varchar(11) comment '���д���',
   town                 varchar(11) comment '�������',
   addr                 varchar(80) comment '��ַ',
   linkman              varchar(20) comment '��ϵ��',
   telphone             varchar(11) comment '��ϵ�绰',
   group_id             char(1) not null comment '��ҵ���� 0����Ӧ�� 1�������� 2��ά�޳�',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier comment '��ҵ';

/*==============================================================*/
/* Table: ass_supplier_epc                                      */
/*==============================================================*/
create table ass_supplier_epc
(
   id                   int not null auto_increment comment 'id',
   oe_code              varchar(80) comment 'oe��',
   product_name         varchar(40) comment '�������',
   type                 varchar(80) comment '�ͺ�',
   size                 varchar(80) comment '���',
   attributes           varchar(1024) comment '������',
   part_sort_id         int comment '�����������id',
   supplier_id          int comment '��ҵid',
   type_id              int comment '����id',
   status               char(1) comment '״̬',
   platform_status      char(1) comment 'ƽ̨״̬',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_epc comment '��ҵepc';

/*==============================================================*/
/* Table: ass_supplier_orm                                      */
/*==============================================================*/
create table ass_supplier_orm
(
   id                   int not null auto_increment comment 'id',
   supplier_no          varchar(80) comment '��Ӧ�̱���',
   oe_code              varchar(80) comment 'oe��',
   big_product_no       varchar(80) comment '�󳧱���',
   small_product_no     varchar(80) comment 'С������',
   produer_name         varchar(40) comment '��Ӧ��Ʒ��',
   part_name            varchar(40) comment '�������',
   first_price          float comment 'һ���۸�',
   second_price         float comment '�����۸�',
   third_price          float comment '�����۸�',
   supplier_id          int comment '��ҵid',
   status               char(1) comment '״̬',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_orm comment '��ҵorm';

/*==============================================================*/
/* Table: ass_supplier_relative                                 */
/*==============================================================*/
create table ass_supplier_relative
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) comment '����',
   supplier_id          int comment '��˾id',
   parent_id            int comment '���ڵ�id  0�����ڵ�',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_supplier_relative comment '��ҵ��ϵ';

/*==============================================================*/
/* Table: ass_task                                              */
/*==============================================================*/
create table ass_task
(
   id                   int not null auto_increment comment 'id',
   code                 varchar(255) comment '���',
   title                varchar(40) comment '����',
   submit_user_id       int comment '�ύ�û�id',
   submit_date          datetime comment '�ύ����ʱ��',
   role_id              int comment '��˽�ɫid',
   finish_user_id       int comment '����û�id',
   end_date             date comment '�������ʱ��',
   status               char(1) comment '����״̬ 0��δ��� 1�������',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_task comment '����';

/*==============================================================*/
/* Table: ass_town                                              */
/*==============================================================*/
create table ass_town
(
   id                   int not null auto_increment comment 'id',
   name                 varchar(40) not null comment '����',
   code                 varchar(11) comment '����',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_town comment '����';

/*==============================================================*/
/* Table: ass_type                                              */
/*==============================================================*/
create table ass_type
(
   id                   int not null auto_increment comment 'id',
   displacement         varchar(20) not null comment '����',
   manufacture_year     varchar(10) not null comment '���',
   engine_type          varchar(20) not null comment '��������',
   horsepower           int comment '����',
   power                int comment '����',
   body_type            varchar(80) comment '��������',
   origin               varchar(80) comment '����',
   description          varchar(255) comment '����',
   series_id            int comment '��ϵid',
   create_date          datetime,
   creator_id           int,
   update_date          int,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_type comment '����';

/*==============================================================*/
/* Table: ass_type_oe                                           */
/*==============================================================*/
create table ass_type_oe
(
   id                   int not null auto_increment comment 'id',
   oe_code              varchar(80) not null comment 'oe����',
   type_id              int not null comment '����Id',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_type_oe comment '����-OE��ϵ��';

/*==============================================================*/
/* Table: ass_user                                              */
/*==============================================================*/
create table ass_user
(
   id                   int not null auto_increment comment 'id',
   telphone             varchar(20) comment '�ֻ�����',
   username             varchar(20) not null comment '�û���',
   realname             varchar(20) comment '��ʵ����',
   password             varchar(32) comment '����',
   job                  varchar(20) comment 'ְλ',
   email                varchar(80) not null comment '����',
   address              varchar(255) comment '��ַ',
   gruop                char(1) not null comment '�û���� 0��ƽ̨ 1����ҵ',
   is_root              char(1) not null comment '�Ƿ������Ա',
   suppiler_id          int comment '��ҵid',
   locked               char(1) not null comment '�Ƿ�����',
   salt                 varchar(11) comment '��',
   create_date          datetime,
   creator_id           int,
   update_date          datetime,
   updator_id           int,
   is_del               char(1) not null default '0',
   primary key (id)
);

alter table ass_user comment '�û�';

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

alter table ass_user_role comment '�û���ɫ��';

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

