package day11;
// 自定义的注解
public @interface MyAnnotation {
	String values() default "hello";
}
