/*
 * 类作用 公共方法
 * author lyn
 * createTime 2016-04-27 
 * version 0.1
 */
package com.fjsaas.web.utils;

import com.fjsaas.web.constants.Constants;

public class Function {
	/**
     * 判断字符串是否为空
     * @param value
     * @return
     */
    public static boolean equalsNull(Object value) {
        if (value != null && !value.equals("") && !value.equals(Constants.NULL_VALUE) && !value.equals("-9999")&& !value.equals("null")) {
            return false;
        }
        else {
            return true;
        }
    }
}
