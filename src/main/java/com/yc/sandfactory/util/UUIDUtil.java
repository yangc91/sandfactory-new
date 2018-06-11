package com.yc.sandfactory.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author hsun
 * @version 1.0
 * @since 2017/7/4 下午8:04
 */
public class UUIDUtil {

    /**
     * 随机获取UUID
     * @return
     */
    public static String random() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取count个UUID
     * @param count 获取数量
     * @return 包含count个UUID的String数组
     */
    public static String[] random(int count) {
        if (count < 1) {
            return null;
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = random();
        }
        return result;
    }
}
