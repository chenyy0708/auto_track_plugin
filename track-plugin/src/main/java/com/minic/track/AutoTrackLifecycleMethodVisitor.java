package com.minic.track;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 09:14
 */
public class AutoTrackLifecycleMethodVisitor extends AdviceAdapter {
    String name;
    String desc;
    int access = 0;
    String superName;

    String CLASS_PATH = "com/minic/track_android/code/ActivityLifeUtil";

    public AutoTrackLifecycleMethodVisitor(MethodVisitor mv, int access, String name, String desc, String superName) {
        super(Opcodes.ASM4, mv, access, name, desc);
        this.name = name;
        this.desc = desc;
        this.access = access;
        this.superName = superName;
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        // 排除系统类
        if (name.startsWith("android")) {
            return;
        }
        handleActivity(name, mv);
    }

    private void handleActivity(String name, MethodVisitor mv) {
        System.out.println("方法：" + name);
        if (Config.ACTIVITY_METHOD_ONCREATE.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityCreate", "(Landroid/app/Activity;)V", false);
        } else if (Config.ACTIVITY_METHOD_ONSTART.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityStart", "(Landroid/app/Activity;)V", false);
        } else if (Config.ACTIVITY_METHOD_ONSTOP.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityStop", "(Landroid/app/Activity;)V", false);
        } else if (Config.ACTIVITY_METHOD_ONDESTROY.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityDestroy", "(Landroid/app/Activity;)V", false);
        } else if (Config.ACTIVITY_METHOD_ONRESUME.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityResume", "(Landroid/app/Activity;)V", false);
        } else if (Config.ACTIVITY_METHOD_ONPAUSE.equals(name)) {
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, CLASS_PATH, "onActivityPause", "(Landroid/app/Activity;)V", false);
        }
    }

}
