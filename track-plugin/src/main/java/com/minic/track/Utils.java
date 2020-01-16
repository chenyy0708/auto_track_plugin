package com.minic.track;

import org.objectweb.asm.Opcodes;

/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 10:50
 */
public class Utils {

    public static boolean isPublic(int access) {
        return (access & Opcodes.ACC_PUBLIC) != 0;
    }

    public static boolean isStatic(int access) {
        return (access & Opcodes.ACC_STATIC) != 0;
    }
}
