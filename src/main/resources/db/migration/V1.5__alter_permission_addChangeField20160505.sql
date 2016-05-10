ALTER TABLE ass_permission ADD sort INT COMMENT '排序';
ALTER TABLE ass_permission CHANGE type type CHAR(1) NOT NULL COMMENT '类型   0:菜单栏 1：菜单 2：权限 3:根节点';