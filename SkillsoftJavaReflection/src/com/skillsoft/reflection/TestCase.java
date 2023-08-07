package com.skillsoft.reflection;

import java.lang.annotation.ElementType; // enum ElementType
import java.lang.annotation.Retention; // @interface Retention
import java.lang.annotation.RetentionPolicy; // enum RetentionPolicy
import java.lang.annotation.Target; // @interface Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCase {
}
