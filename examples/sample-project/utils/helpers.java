package com.example.utils;

import java.util.*;
import java.text.SimpleDateFormat;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

/**
 * 通用工具类
 * 提供字符串处理、日期格式化、加密等常用功能
 */
public class Helpers {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 字符串工具类
     */
    public static class StringUtils {
        
        /**
         * 判断字符串是否为空或null
         */
        public static boolean isEmpty(String str) {
            return str == null || str.trim().length() == 0;
        }
        
        /**
         * 判断字符串是否非空
         */
        public static boolean isNotEmpty(String str) {
            return !isEmpty(str);
        }
        
        /**
         * 首字母大写
         */
        public static String capitalize(String str) {
            if (isEmpty(str)) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
        
        /**
         * 驼峰命名转下划线
         */
        public static String camelToUnderscore(String camelStr) {
            if (isEmpty(camelStr)) {
                return camelStr;
            }
            return camelStr.replaceAll("([A-Z])", "_$1").toLowerCase();
        }
        
        /**
         * 下划线转驼峰命名
         */
        public static String underscoreToCamel(String underscoreStr) {
            if (isEmpty(underscoreStr)) {
                return underscoreStr;
            }
            String[] parts = underscoreStr.split("_");
            StringBuilder camelCase = new StringBuilder(parts[0]);
            
            for (int i = 1; i < parts.length; i++) {
                camelCase.append(capitalize(parts[i]));
            }
            return camelCase.toString();
        }
    }
    
    /**
     * 日期工具类
     */
    public static class DateUtils {
        
        /**
         * 格式化当前时间
         */
        public static String formatNow() {
            return formatDate(new Date());
        }
        
        /**
         * 格式化指定日期
         */
        public static String formatDate(Date date) {
            if (date == null) {
                return "";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.format(date);
        }
        
        /**
         * 解析日期字符串
         */
        public static Date parseDate(String dateStr) {
            if (StringUtils.isEmpty(dateStr)) {
                return null;
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                return sdf.parse(dateStr);
            } catch (Exception e) {
                return null;
            }
        }
        
        /**
         * 获取时间戳
         */
        public static long getTimestamp() {
            return System.currentTimeMillis();
        }
    }
    
    /**
     * 加密工具类
     */
    public static class CryptoUtils {
        
        /**
         * MD5加密
         */
        public static String md5(String input) {
            if (StringUtils.isEmpty(input)) {
                return "";
            }
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
                StringBuilder hex = new StringBuilder();
                
                for (byte b : hashBytes) {
                    String hexString = Integer.toHexString(0xff & b);
                    if (hexString.length() == 1) {
                        hex.append('0');
                    }
                    hex.append(hexString);
                }
                return hex.toString();
            } catch (Exception e) {
                throw new RuntimeException("MD5加密失败", e);
            }
        }
        
        /**
         * 生成随机字符串
         */
        public static String generateRandomString(int length) {
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(chars.length());
                sb.append(chars.charAt(index));
            }
            return sb.toString();
        }
    }
    
    /**
     * 集合工具类
     */
    public static class CollectionUtils {
        
        /**
         * 判断集合是否为空
         */
        public static boolean isEmpty(Collection<?> collection) {
            return collection == null || collection.isEmpty();
        }
        
        /**
         * 判断集合是否非空
         */
        public static boolean isNotEmpty(Collection<?> collection) {
            return !isEmpty(collection);
        }
        
        /**
         * 安全获取列表元素
         */
        public static <T> T safeGet(List<T> list, int index) {
            if (list == null || index < 0 || index >= list.size()) {
                return null;
            }
            return list.get(index);
        }
        
        /**
         * 列表分页
         */
        public static <T> List<T> paginate(List<T> list, int page, int size) {
            if (isEmpty(list) || page < 1 || size < 1) {
                return new ArrayList<>();
            }
            
            int start = (page - 1) * size;
            int end = Math.min(start + size, list.size());
            
            if (start >= list.size()) {
                return new ArrayList<>();
            }
            
            return list.subList(start, end);
        }
    }
}