package com.yuxuan66;

import org.objectweb.asm.*;

public class HelloWorldProxyFactory extends ClassLoader implements Opcodes {

    public Class<?> getProxyClass() {

        ClassWriter classWriter = new ClassWriter(0);
        MethodVisitor methodVisitor;
        classWriter.visit(V11, ACC_PUBLIC | ACC_SUPER, "com/yuxuan66/HelloWorldProxy", null, "com/yuxuan66/HelloWorld", null);

        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/yuxuan66/HelloWorld", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "test", "()V", null, null);
            methodVisitor.visitCode();
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitLdcInsn("\u524d\u7f6e\u589e\u5f3a");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/yuxuan66/HelloWorld", "test", "()V", false);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitLdcInsn("\u540e\u7f6e\u589e\u5f3a");
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            methodVisitor.visitInsn(RETURN);
            methodVisitor.visitMaxs(2, 1);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();
        byte[] data = classWriter.toByteArray();
        return defineClass("com.yuxuan66.HelloWorldProxy", data, 0, data.length);
    }

}
