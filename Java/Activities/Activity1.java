package Activities;

class Car1 {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	Car1 (){
	tyres=4;
	doors=4;
	}
	public  void displayCharacteristics() {
		System.out.println("Color of car is " + color);
		System.out.println("Transmission from car is " + transmission);
		System.out.println("Make of the car is " +make);
		System.out.println("Number of tyres is " +tyres);
		System.out.println("Number of doors is " +doors);
	}
	public void accelerate() {
		System.out.println("car is moving forward");
	}
	public void brake() {
		System.out.println("car is stopped moving");
	}
}
	public class Activity1 {

	public static void main(String[] args) {
		Car1 creta=new Car1();
		creta.make=2014;
		creta.color ="black";
		creta.transmission="manual";
		creta.displayCharacteristics();
		creta.accelerate();
		creta.brake();

	}

}
