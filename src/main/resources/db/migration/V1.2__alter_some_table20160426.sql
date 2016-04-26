alter table ass_type_oe modify id int auto_increment;
alter table ass_productcode_oe alter oe_code drop default;
alter table ass_productcode_oe alter reference_code drop default;
alter table ass_productcode_oe alter oe_code set default '';
alter table ass_productcode_oe alter reference_code set default '';