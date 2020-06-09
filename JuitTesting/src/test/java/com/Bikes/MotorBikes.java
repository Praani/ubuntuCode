package com.Bikes;

public class MotorBikes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motor tvs = new Motor();
		Motor honda = new Motor();
		
		honda.Speed();
		tvs.setSpeed(100);
		System.out.println("The TVS Bike speed is "+ tvs.getSpeed()+ "kmph");
		
		honda.setSpeed(250);
		System.out.println("The HONDA Bike speed is "+honda.getSpeed()+"kmph");
	}

}
