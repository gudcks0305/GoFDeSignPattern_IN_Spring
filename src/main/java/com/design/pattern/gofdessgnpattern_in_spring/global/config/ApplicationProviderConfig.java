package com.design.pattern.gofdessgnpattern_in_spring.global.config;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProviderConfig implements ApplicationContextAware {
   private static ApplicationContext context;


   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      context = applicationContext;
   }
   public static ApplicationContext getContext() {
      return context;
   }
}
