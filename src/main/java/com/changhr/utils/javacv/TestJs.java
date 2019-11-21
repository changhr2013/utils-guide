package com.changhr.utils.javacv;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author changhr
 * @create 2019-11-20 15:08
 */
public class TestJs {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
//        engine.eval(new FileReader("C:\\Users\\m4000e\\Desktop\\utils-guide\\src\\main\\resources\\video.min.js"));
        engine.eval(new FileReader("C:\\Users\\m4000e\\Desktop\\utils-guide\\src\\main\\resources\\script.js"));

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println(result);
        System.out.println(result.getClass());

        invocable.invokeFunction("fun2", new Date());
        // [object java.util.Date]

        invocable.invokeFunction("fun2", LocalDateTime.now());
        // [object java.time.LocalDateTime]
    }

}
