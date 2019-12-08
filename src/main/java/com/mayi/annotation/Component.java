package com.mayi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//修饰的目标对象
@Retention(RetentionPolicy.RUNTIME)//在jvm中一直运行
@Documented
public @interface Component {
	
	String value() default "";
	
}
