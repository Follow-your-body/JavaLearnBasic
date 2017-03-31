package com.lzw;

public class Circle {
	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius;		
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double findArea() {
		return (Math.PI * radius * radius);				
	}

}
