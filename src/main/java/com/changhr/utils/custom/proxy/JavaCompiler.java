package com.changhr.utils.custom.proxy;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.File;
import javax.tools.ToolProvider;
import java.io.IOException;

/**
 * 编译工具类
 *
 * @author changhr
 * @create 2019-10-08 14:36
 */
public class JavaCompiler {

    public static void compile(File javaFile) throws IOException {
        javax.tools.JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(javaFile);

        javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();
    }
}
