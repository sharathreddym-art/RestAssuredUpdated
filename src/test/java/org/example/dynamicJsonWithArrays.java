package org.example;


import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class dynamicJsonWithArrays {
    @Test (dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {

        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse = given().header("Content-Type", "application/json")
                .body(payload.AddBookWithArray(isbn, aisle))
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jsonPath = reusableMethods.rawToJson(addBookResponse);
        String id = jsonPath.get("ID");
        System.out.println(id);
    }

    @DataProvider (name="BooksData")
    public Object[][] getData(){
      return new Object[][] {{"rtyu", "7898"}, {"sdfsd", "1234"}, {"gghh", "6789"}};

    }

}
