package com.products.productsdata;

import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleData extends TestBase {


    @Test
    public void GetAllSingleData() {

        //RestAssured.basePath=("/products");
        Response response = given()
                .basePath("/products")
                .pathParam("id","347155")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
