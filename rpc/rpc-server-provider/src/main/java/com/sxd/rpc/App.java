package com.sxd.rpc;

import com.sxd.rpc.core.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        ((AnnotationConfigApplicationContext)applicationContext).start();
    }
}
