package RestAssured;

import io.restassured.path.json.JsonPath;


public class ComplexJsonPaerse {
	
	public static void main (String[] args) {
		
		JsonPath jh=new JsonPath(PlayLoad.courseprice());  //Sucssfulky mocked the response this response is not coming from api still api is not ready  we should not wait untill develped compleet it when we know what to test we have to take one dummy response assuming that real api and contiunue automation  tommarow when we get real api we can remove this dummy one  and connect it to real one 
		//1. Print No of courses returned by API
		System.out.println("Print No of courses returned by API "+jh.getInt("courses.size()"));
		
		int count=jh.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print purshase amount 
		System.out.println("Print purshase amount "+jh.getInt("dashboard.purchaseAmount"));
		
		//3.Print tittle of first course
		
		
		
		System.out.println("Print tittle of first course "+jh.getString("courses[0].title"));
		
		// 4.print all course tittles and respective prices
		
		
		
		
		
		System.out.println("==========================");
		
		
		for(int i=0;i<count;i++) {
			
			System.out.println("courses "+jh.getString("courses["+i+"].title"));
			System.out.println("Prices "+jh.getInt("courses["+i+"].price"));
		
			String courseTittle=jh.getString("courses["+i+"].title");
			
			if(courseTittle.equalsIgnoreCase("RPA")) {
				System.out.println("copies --> "+jh.getInt("courses["+i+"].copies"));
			}
			
		//Verify if sum of all corses prices mathes purshase ammount
			
		}
		
		
		System.out.println("==========================");
		
		int sum=0;
		
		for(int j=0;j<count;j++) {
			int pricees=jh.getInt("courses["+j+"].price")*jh.getInt("courses["+j+"].copies"); 
			
			sum+=pricees;
			
			
			
		}
		
		int purchaseAmount=jh.getInt("dashboard.purchaseAmount");
		
		if(purchaseAmount==sum) {
		System.out.println("Printintimg sum of all course prices which is eqal to purasches amount "+sum);
	
		}
	}

}
