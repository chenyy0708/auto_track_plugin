package com.minic.track;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 09:14
 */
public class AutoTrackOnClickMethodVisitor extends AdviceAdapter {
    boolean isOnClickMethod = false;
    boolean pubAndNoStaticAccess = false;
    //nameDesc是'onClick(Landroid/view/View;)V'字符串
    String nameDesc;
    String name;
    String desc;
    int variableID = 0;
    int access = 0;

    public AutoTrackOnClickMethodVisitor(MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM4, mv, access, name, desc);
        this.name = name;
        this.desc = desc;
        this.access = access;
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        //方法执行前插入
        nameDesc = name + desc;
        pubAndNoStaticAccess = Utils.isPublic(access) && !Utils.isStatic(access);
        // ButterKnife
        if ((nameDesc.equals("onClick(Landroid/view/View;)V")) && pubAndNoStaticAccess) {
            isOnClickMethod = true;
            variableID = newLocal(Type.getObjectType("java/lang/Integer"));
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ASTORE, variableID);
        }
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        if (isOnClickMethod) {
            trackViewOnClick(mv, variableID);
        }
    }

    private void trackViewOnClick(MethodVisitor mv, int index) {
        mv.visitVarInsn(ALOAD, index);
        mv.visitMethodInsn(INVOKESTATIC, "com/minic/track_android/code/AutoTrackHelper", "trackViewOnClick", "(Landroid/view/View;)V", false);
    }

}
