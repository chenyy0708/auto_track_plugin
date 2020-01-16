package com.minic.track;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.JSRInlinerAdapter;

/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 11:27
 */
public class AnalyticsJSRAdapter extends JSRInlinerAdapter {
    protected AnalyticsJSRAdapter(int api, MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        super(api, mv, access, name, desc, signature, exceptions);
    }
}