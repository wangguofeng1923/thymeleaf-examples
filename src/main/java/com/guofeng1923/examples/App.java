package com.guofeng1923.examples;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 FileTemplateResolver templateResolver =  new FileTemplateResolver();
         templateResolver.setPrefix("src/main/resources/");
         templateResolver.setSuffix(".html");
         templateResolver.setCharacterEncoding("UTF-8");
         templateResolver.setTemplateMode("XHTML");

         TemplateEngine  engine = new TemplateEngine();
         engine.setTemplateResolver(templateResolver);
        
         
         

//         Properties properties = new Properties();
//         properties.setProperty("source", source);
//         properties.setProperty("target", target);
//         properties.setProperty("binary", String.valueOf(true));
         
         
         Map<String,Object>arguments=new HashMap<String, Object>();
         arguments.put("target", "UTF-8");
         arguments.put("models", TebModel.dummyModels(20));
         Context ctx = new Context();
         ctx.setVariables(arguments);
         Writer writer=new PrintWriter(System.out);
         engine.process("thymeleaf",  ctx, writer);
    }
}
