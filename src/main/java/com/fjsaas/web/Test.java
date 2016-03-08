package com.fjsaas.web;

import com.fjsaas.shiro.HashUtils;

public class Test {
    public static void main(String[] args) {
        System.err.println(HashUtils.md5("12345"));
    }
}
