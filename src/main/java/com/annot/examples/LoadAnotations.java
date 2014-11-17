/**
 * 
 */
package com.annot.examples;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Collection;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.Scanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

/**
 * @author schlei
 *
 */
public class LoadAnotations {

	/**
	 * 
	 */
    public static void loadCars() {
    	String name = LoadAnotations.class.getPackage().getName();
    	System.out.println(name);
    	
    	Reflections reflections = new Reflections(name);
    	Set<Class<? extends Car>> subTypes = reflections.getSubTypesOf(Car.class);
    	System.out.println(subTypes);
    	System.out.println(subTypes.size());

    	Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Car.class);
    	System.out.println(annotated);
    	System.out.println(annotated.size());
    	
    	for (Class<?> class1 : annotated) {
	        System.out.println(class1.getName());
	        Car car = class1.getAnnotation(Car.class);
	        System.out.println(car.brand());
	        System.out.println(car.model());
        }
    	
    }

	/**
	 * 
	 */
    public static void loadMaxSpeed() {
    	String name = LoadAnotations.class.getPackage().getName();
    	System.out.println(name);

    	ConfigurationBuilder builder = new ConfigurationBuilder();
    	Scanner scanners = new MethodAnnotationsScanner();
		builder.setScanners(scanners);
		Collection<URL> urls = ClasspathHelper.forPackage(name);
		builder.setUrls(urls);
    	Reflections reflections = new Reflections(builder);
    	Set<Method> set = reflections.getMethodsAnnotatedWith(MaxSpeed.class);
    	System.out.println(set);
    	for (Method method : set) {
    		System.out.println(method.getDeclaringClass());
    		System.out.println(method.toString());
    		System.out.println(method.getName());
	        MaxSpeed maxSpeed = method.getAnnotation(MaxSpeed.class);
	        System.out.println(maxSpeed.speed());
        }
    }

	/**
	 * 
	 */
    public static void loadInitialSpeed() {
    	String name = LoadAnotations.class.getPackage().getName();
    	System.out.println(name);

    	ConfigurationBuilder builder = new ConfigurationBuilder();
    	Scanner scanners = new FieldAnnotationsScanner();
		builder.setScanners(scanners);
		Collection<URL> urls = ClasspathHelper.forPackage(name);
		builder.setUrls(urls);
    	Reflections reflections = new Reflections(builder);
	    Set<Field> set = reflections.getFieldsAnnotatedWith(InitialSpeed.class);
	    System.out.println(set);
	    for (Field field : set) {
	    	System.out.println(field);
	        if (Modifier.isStatic(field.getModifiers())) {
	        	InitialSpeed initialSpeed = field.getAnnotation(InitialSpeed.class);
	        	try {
	        		if (Modifier.isPrivate(field.getModifiers())) {
	        			System.out.println("Field is private");
	        		} else {
	        			field.set(null, initialSpeed.speed());
	        			System.out.println("Initial value setted");
	        		}
                } catch (IllegalArgumentException | IllegalAccessException e) {
	                e.printStackTrace();
                }
	        }
        }
	    System.out.println(Ferrari.minSpeed);
	    System.out.println(Lamborghini.minSpeed);
    }

}
