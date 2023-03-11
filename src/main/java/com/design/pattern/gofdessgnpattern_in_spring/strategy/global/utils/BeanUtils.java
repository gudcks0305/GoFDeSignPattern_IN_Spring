package com.design.pattern.gofdessgnpattern_in_spring.strategy.global.utils;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.global.config.ApplicationProviderConfig;

public class BeanUtils {
   public static Object getBean(String beanName) {
      return ApplicationProviderConfig.getContext().getBean(beanName);
   }
}
