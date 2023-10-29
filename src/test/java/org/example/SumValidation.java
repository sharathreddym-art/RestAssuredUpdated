package org.example;

import Files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumOfCourses(){
        int sum=0;
        JsonPath jsonPath = new JsonPath(payload.coursePrice());
        int courseCount = jsonPath.getInt("courses.size()");
        for(int i=0; i<courseCount;i++)
        {
           int coursePrice= jsonPath.get("courses["+i+"].price");
            int courseCopies= jsonPath.get("courses["+i+"].copies");
            int amount=coursePrice*courseCopies;
            System.out.println(amount);
            sum=sum+amount;
        }
        int purchaseAmount=jsonPath.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount);



    }
}
