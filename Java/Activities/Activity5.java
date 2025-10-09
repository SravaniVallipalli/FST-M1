package Activities;

 abstract class Book{
	String title;
	//abstract method
	abstract void setTitle(String s);
	//concrete method
	String getTitle() {
		return title;
	}
	}
	
	class MyBook extends Book {

		@Override
	public 	void setTitle(String s) {
			// TODO Auto-generated method stub
			title=s;
		}
}

public class Activity5 {
	public static void main(String[] args) {
		String title="learn new";
		MyBook newNovel=new MyBook();
		newNovel.setTitle(title);
		System.out.println("title of the page is " +newNovel.getTitle());
	}

}
