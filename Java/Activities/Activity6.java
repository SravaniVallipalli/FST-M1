package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;


public Plane(int passengersNum){
	this.maxPassengers=passengersNum;
	this.passengers=new ArrayList<>();
	
}
public void onboard(String passengerName) {
	if(passengers.size()<=maxPassengers) {
		this.passengers.add(passengerName);
	}
	else {
		System.out.println("plane is full");
	}
}
public Date takeoff() {
	this.lastTimeTookOf=new Date();
	return lastTimeTookOf;
}
public void land() {
	this.lastTimeLanded=new Date();
	//return lastTimeLanded;
	//this.passengers.clear();
}
public Date getLastLanded() {
	return lastTimeLanded;
}
public List<String> getPassengers() {
	return passengers;
}

}

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		Plane plane=new Plane(10);
		plane.onboard("sravani");
		plane.onboard("vivek");
		plane.onboard("syamala");
		System.out.println("last time take off is " +plane.takeoff());
		System.out.println("people on the plane " +plane.getPassengers());
		Thread.sleep(5000);
		plane.land();
		System.out.println("plane is landed " +plane.getLastLanded());
		System.out.println("people landed from the plane " +plane.getPassengers());
	}

}
