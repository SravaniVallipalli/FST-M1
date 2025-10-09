package Activities;

interface BicycleParts {
	public int tyres=2;
	public int maxSpeed=60;
			
}
interface BicycleOperations {
	public void applyBreak(int decrement);
	public void speedUp(int increment);
}
 class Bicycle implements BicycleParts, BicycleOperations{
	 
	 int gears;
	 int currentSpeed;
	 
	 public Bicycle(int gears,int currentSpeed) {
		 this.gears=gears;
		 this.currentSpeed=currentSpeed;
		 System.out.println("number of gears are " +gears);
		 System.out.println("current speed of cycle is " +currentSpeed);
	 }
	 
	

	@Override
	public void speedUp(int increment) {
		currentSpeed=currentSpeed+increment;
		System.out.println("current speed of cycle is " +currentSpeed);
	}
	@Override
	public void applyBreak(int decrement) {
		currentSpeed=currentSpeed-decrement;
		System.out.println("current speed of cycle is " +currentSpeed);
	}
	public String bicycleDesc() {
		return("max speed of bicycle is " + currentSpeed + "\n number of gears are " +gears);
	}
	 
 }
 class MountainBike extends Bicycle{
	

	 int seatHeight=10;
	 public MountainBike(int gears, int currentSpeed, int seatHeight) {
			super(gears, currentSpeed);
			// TODO Auto-generated constructor stub
			this.seatHeight=seatHeight;
		}
	 public void seatHeight(int newValue) {
		 seatHeight=newValue;
	 }
//	 @Override
//	 public String bicycleDesc() {
//		return("seat height of the bicycle is " +seatHeight); 
//	 }
	 
 }
	
public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike mb=new MountainBike(3,10,12);
		System.out.println(mb.bicycleDesc());
		mb.speedUp(10);
		mb.applyBreak(2);
	}

}
