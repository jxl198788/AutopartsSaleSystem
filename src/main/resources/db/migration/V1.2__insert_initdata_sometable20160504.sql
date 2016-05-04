-- ----------------------------
-- Records of ass_brand
-- ----------------------------
INSERT INTO `ass_brand` VALUES ('1', '奥迪', null, null, null, null, null, null, '0');
INSERT INTO `ass_brand` VALUES ('2', '宝马', null, null, null, null, null, null, '0');
-- ----------------------------
-- Records of ass_series
-- ----------------------------
INSERT INTO `ass_series` VALUES ('1', 'Q1', '1', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('2', 'Q2', '1', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('3', 'Q3', '1', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('4', 'Q4', '1', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('5', 'Q5', '1', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('6', 'X1', '2', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('7', 'X2', '2', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('8', 'X3', '2', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('9', 'X4', '2', null, null, null, null, '0');
INSERT INTO `ass_series` VALUES ('10', 'X5', '2', null, null, null, null, '0');
-- ----------------------------
-- Records of ass_type
-- ----------------------------
INSERT INTO `ass_type` VALUES ('1', '20', '2011', '2X-001', '30', '1500', 'FULL-F', '德国', null, '1', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('2', '22', '2012', '2X-002', '30', '1600', 'FULL-F', '德国', null, '2', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('3', '25', '2013', '3X-778', '40', '1800', 'FULL-F', '德国', null, '3', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('4', '27', '2014', '4X-XFG', '44', '1900', 'FULL-F', '德国', null, '5', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('5', '22', '2014', '4X-JJK', '34', '1750', 'FULL-F', '德国', null, '4', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('6', '23', '2012', '2X-CCF', '35', '1246', 'FULL-F', '德国', null, '7', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('7', '21', '2010', '4X-FFC', '34', '2312', 'FULL-F', '德国', null, '6', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('8', '33', '2015', '5X-GGH', '45', '2344', 'FULL-F', '德国', null, '8', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('9', '35', '2016', 'FG-GGH', '44', '2345', 'FULL-F', '德国', null, '9', null, null, null, null, '0');
INSERT INTO `ass_type` VALUES ('10', '43', '2016', 'FG-LLK', '54', '2356', 'FULL-F', '德国', null, '10', null, null, null, null, '0');
-- Records of ass_part_sort
-- ----------------------------
INSERT INTO `ass_part_sort` VALUES ('1', '车轮组', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('2', '汽车动力', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('3', '车盘', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('4', '车头', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('5', '车尾', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('6', '冷却系统', '-1', null, null, null, null, '0');
INSERT INTO `ass_part_sort` VALUES ('7', '制动系统', '-1', null, null, null, null, '0');
-- ----------------------------
-- Records of ass_oe
-- ----------------------------
INSERT INTO `ass_oe` VALUES ('X01', '车轮', '国标RS', '188*177', null, null, null, '1', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X02', '引擎', '标准RS', '17*199', null, null, null, '2', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X03', '车盖', '标准338', 'HS-188', null, null, null, '3', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X04', '车身', '国标BBS', 'HS-XN', null, null, null, '4', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X05', '制动钳子', '非标BS', 'BS-NXM', null, null, null, '5', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X06', '钳子', '国际BA', 'HS-XSW', null, null, null, '6', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X07', '车盘', '非标NX', 'NX-JA', null, null, null, '7', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X08', '导向轮', '国标AX', 'AX-18', null, null, null, '6', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X09', '制动刹车', '标准KXX', 'FK188', null, null, null, '4', null, null, null, null, '0');
INSERT INTO `ass_oe` VALUES ('X10', '车子轴承', '国际AX', 'AX-989', null, null, null, '1', null, null, null, null, '0');
-- ----------------------------
-- Records of ass_type_oe
-- ----------------------------
INSERT INTO `ass_type_oe` VALUES ('1', '1', 'X01', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('2', '2', 'X02', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('3', '3', 'X03', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('4', '4', 'X04', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('5', '5', 'X05', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('6', '6', 'X06', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('7', '7', 'X07', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('8', '8', 'X08', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('9', '9', 'X09', null, null, null, null, '0');
INSERT INTO `ass_type_oe` VALUES ('10', '10', 'X10', null, null, null, null, '0');
-- ----------------------------
-- Records of ass_image
-- ----------------------------
INSERT INTO `ass_image` VALUES ('1', 'image1', '/image/001.jpg', 'X01', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('2', 'image2', '/image/002.jpg', 'X02', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('3', 'image3', '/image/003.jpg', 'X03', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('4', 'image4', '/image/004.jpg', 'X04', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('5', 'image5', '/image/005.jpg', 'X05', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('6', 'image6', '/image/006jpg', 'X06', '0', '0', null, null, null, null, '0');
INSERT INTO `ass_image` VALUES ('7', 'image7', '/image/007.jpg', 'X07', '0', '0', null, null, null, null, '0');
-- ----------------------------
-- Records of ass_supplier
-- ----------------------------
-- ----------------------------
-- Records of ass_supplier
-- ----------------------------
INSERT INTO `ass_supplier` VALUES ('1', '壳牌', null, '350000', '350300', '350322', null, null, null, '0', '0', null, null, null, null, '0');

-- ----------------------------
-- Records of ass_producer
-- ----------------------------
INSERT INTO `ass_producer` VALUES ('1', '飞利浦', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('2', '美的', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('3', '格力', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('4', '联想', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('5', '华为', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('6', '小米', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('7', '苹果', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('8', '特拉斯', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('9', '美孚', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('10', '壳牌', null, null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `ass_producer` VALUES ('11', '漫步者', null, null, null, null, null, null, null, null, null, null, null, null, '0');
-- ----------------------------
-- Records of ass_productcode_oe
-- ----------------------------
INSERT INTO `ass_productcode_oe` VALUES ('1', '', 'X03', 'E01', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('2', '', 'X05', 'E01', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('3', '', 'X03', 'E02', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('4', '', 'X04', 'E02', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('5', '', 'X06', 'E02', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('6', '', 'X06', 'E03', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('7', '', 'X02', 'E03', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('8', '', 'X01', 'E04', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('9', '', 'X05', 'E04', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('10', '', 'X01', 'E07', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('11', '', 'X07', 'E07', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('12', '', 'X01', 'E08', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('13', 'R01', '', 'E09', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('14', 'R02', '', 'E09', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('15', 'R01', '', 'E10', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('16', 'R03', '', 'E10', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('17', 'R04', '', 'E10', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('19', 'R01', '', 'E11', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('20', 'E01', '', 'E10', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('21', 'E11', '', 'R02', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('22', 'E08', '', 'E11', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('23', '', 'X10', 'E22', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('24', '', 'X10', 'E24', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('25', '', 'X11', 'E23', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('26', '', 'X11', 'E25', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('27', '', 'X11', 'E26', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('28', '', 'X15', 'E29', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('29', '', 'X15', 'E26', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('30', '', 'Z15', 'E30', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('31', '', 'X12', 'E20', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('32', '', 'X12', 'E21', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('33', '', 'X14', 'E21', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('34', '', 'X14', 'E28', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('35', '', 'X13', 'E28', null, null, null, null, '0');
INSERT INTO `ass_productcode_oe` VALUES ('36', '', 'X14', 'E27', null, null, null, null, '0');