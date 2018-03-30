package com.example;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

public final class WXVisitor extends SimpleAnnotationValueVisitor7<Void, Void> {

    private Filer mFiler;
    private TypeMirror mTypeMirror;
    private String mPackageName;

    private String wxType;

    public WXVisitor(String wxType) {
        this.wxType =wxType;
    }

    public void setFiler(Filer filer) {
        mFiler = filer;
    }

    @Override
    public Void visitString(String s, Void v) {
        mPackageName = s;
        return v;
    }

    @Override
    public Void visitType(TypeMirror mirror, Void v) {
        mTypeMirror = mirror;
        generateJavaCode();
        return v;
    }

    private void generateJavaCode() {

        String className;
        switch (wxType) {
            case "wxpay" :
                className = "WXPayEntityActivity";
                break;
            case "register" :
                className = "AppRegister";
                break;
            default:
                className = "WXEntityActivity";
                break;
        }

        final TypeSpec targetActivity = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)
                .superclass(TypeName.get(mTypeMirror))
                .build();

        final JavaFile javaFile = JavaFile.builder(mPackageName + ".wxapi", targetActivity)
                .addFileComment("wechat entrance, do not edit")
                .build();

        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
