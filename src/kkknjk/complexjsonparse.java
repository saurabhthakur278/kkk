package kkknjk;

import io.restassured.path.json.JsonPath;
import pa.payload;

public class complexjsonparse {

	public static void main(String [] args) {
		
		JsonPath js= new JsonPath(payload.courseprise());
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		
		int count1=js.getInt("dashboard.purchaseAmount");
		System.out.println(count1);
		
		
//		print title of first course 
		
		String count2=js.get("courses[0].title");
		System.out.println(count2);
		
		
		
//		for(int i=0;i<=count;i++) {
//			
//		System.out.println( js.get("courses["+i+"].title").toString());
//		
//		System.out.println( js.get("courses["+i+"].price").toString());
//		
//		
//		
//		}
//		
		
		for(int i=0;i<=count;i++) {
			String courseTitle=js.get("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("Cypress")) {
				int ss= js.get("courses["+i+"].copies");
				System.out.println(ss);
				break;
			}
			
			
		}
		
		int sum = 0;
		
		for(int i=0;i<=count;i++) {
			String courseTitle=js.get("courses["+i+"].title");
			
				int ss= js.get("courses["+i+"].copies");
				int tt=js.get("courses["+i+"].price");
			 int  about= ss*tt;
			 sum=sum+about;
			System.out.println(sum);
			
			
		}
		
		
		
		
		
	}
	
}
