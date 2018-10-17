package com.xzy.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 页面form   token
 * @author 18505
 *在需要生成token的controller上增加@FormToken(save=true)，
 * 在需要检查重复提交的controller上添加@FormToken(remove=true)
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormToken {

    boolean save() default false;

    boolean remove() default false;
}
