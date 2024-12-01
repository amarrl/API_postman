package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class TestNgExam {
	
	@Test
	public void sum() {
		
		JsonPath jh=new JsonPath(PlayLoad.courseprice());  //Sucssfulky mocked the response this response is not coming from api still api is not ready  we should not wait untill develped compleet it when we know what to test we have to take one dummy response assuming that real api and contiunue automation  tommarow when we get real api we can remove this dummy one  and connect it to real one 
		//1. Print No of courses returned by API
		System.out.println("Print No of courses returned by API "+jh.getInt("courses.size()"));
		
		int count=jh.getInt("courses.size()");
		System.out.println(count);
		
int sum=0;
		
		for(int j=0;j<count;j++) {
			int pricees=jh.getInt("courses["+j+"].price")*jh.getInt("courses["+j+"].copies"); 
			
			sum+=pricees;
			
			
			
		}
		
		int purchaseAmount=jh.getInt("dashboard.purchaseAmount");
		
		if(purchaseAmount==sum) {
		System.out.println("Printintimg sum of all course prices which is eqal to purasches amount "+sum);
	
		}
		
		Assert.assertEquals(sum, 910);
	}
	
	
	
	

}
