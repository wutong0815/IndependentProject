package com.example.springbootmodule.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresPermissions {
    String[] value();
    Logical logical() default Logical.AND;
}

enum Logical {
    AND, OR
}