package com.nevercaution.demoapplication;

import com.nevercaution.customdependencyinject.CustomApplicationContext;
import com.nevercaution.customdependencyinject.annotation.CustomComponentScan;
import com.nevercaution.demoapplication.service.UserService;

@CustomComponentScan(basePackage = "com.nevercaution.demoapplication.service")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("DemoApplication.main");
        CustomApplicationContext context = new CustomApplicationContext();

        context.initialize(DemoApplication.class);

        UserService userService = (UserService)context.getBean("userService").orElseThrow(IllegalAccessError::new);

        String s = userService.pullOut();
        System.out.println("s = " + s);
    }

}
