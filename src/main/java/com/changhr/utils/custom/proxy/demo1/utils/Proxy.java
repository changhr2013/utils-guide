package com.changhr.utils.custom.proxy.demo1.utils;

import com.changhr.utils.custom.proxy.demo1.base.Flyable;
import com.changhr.utils.custom.proxy.demo1.dynamic.InvocationHandler;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author changhr
 * @create 2019-10-08 14:17
 */
public class Proxy {

    public static Object newProxyInstance(Class intfc, InvocationHandler handler) throws Exception {
        TypeSpec.Builder typeSpecBuilder = TypeSpec
                .classBuilder("DynamicProxy")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(intfc);

        FieldSpec fieldSpec = FieldSpec
                .builder(InvocationHandler.class, "handler", Modifier.PRIVATE)
                .build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "handler")
                .addStatement("this.handler = handler")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = Flyable.class.getDeclaredMethods();

        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addCode("try{\n")
                    .addStatement("\t $T method = " + intfc.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
                    .addStatement("\t this.handler.invoke(this, method, null)")
                    .addCode("} catch(Exception e) {\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile
                .builder("com.changhr.utils.custom.proxy.demo.dynamic", typeSpecBuilder.build())
                .build();

        String sourcePath = "C:/Users/m4000e/Desktop/utils-guide/src/main/java/";
        javaFile.writeTo(new File(sourcePath));

        // 编译
        JavaCompiler.compile(new File(sourcePath + "/com/changhr/utils/custom/proxy/demo1/dynamic/DynamicProxy.java"));

        // 使用反射 load 到内存
        URL[] urls = {new URL("file:/" + sourcePath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class<?> clazz = classLoader.loadClass("com.changhr.utils.custom.proxy.demo1.dynamic.DynamicProxy");
        Constructor<?> constructor = clazz.getConstructor(InvocationHandler.class);

        return constructor.newInstance(handler);
    }

}
