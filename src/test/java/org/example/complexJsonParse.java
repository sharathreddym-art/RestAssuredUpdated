package org.example;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {
    public static void main(String[] args) {
        JsonPath jsonPath = new JsonPath(payload.coursePrice());

        //print count of number of courses
        int courseCount = jsonPath.getInt("courses.size()");
        System.out.println(courseCount);
        int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        String courseTitle = jsonPath.get("courses[0].title");
        System.out.println(courseTitle);

        for (int i = 0; i < courseCount; i++) {
            String courseTitles = jsonPath.get("courses[" + i + "].title");
            System.out.println(jsonPath.get("courses[" + i + "].price").toString());
            System.out.println(courseTitles);
        }

        //print no of copies sold by cypress

        for (int i=0;i<courseCount;i++){
           String coursesTitleMatch= jsonPath.get("courses["+i+"].title");
            if(coursesTitleMatch.equalsIgnoreCase("Cypress"))
            {
               int copies= jsonPath.get("courses["+i+"].copies");
                System.out.println("The copies of Cypress are "+copies);
                break;
            }
        }


    }
}
