package com.products.productsdata;

import com.products.model.ProductsPojo;
import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductCRUDTest extends TestBase {

    @Test
    public void test001() {
        //get full list
        Response response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test //post new data
    public void test002() {

        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("pitter");
        productsPojo.setType("wong");
        productsPojo.setPrice(9.1f);
        productsPojo.setUpc("056852214582");
        productsPojo.setShipping(452);
        productsPojo.setDescription("Power Preserve technology");
        productsPojo.setManufacturer("decny");
        productsPojo.setModel("MN1300R4Z");

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productsPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test //update data with id
    public void test003() {

        ProductsPojo productsPojo =new ProductsPojo();
        productsPojo.setName("Merry");
        productsPojo.setType("Creser");
        productsPojo.setPrice(3.5f);

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .pathParam("id","9999706")
                .body(productsPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test //delete data with id
    public void test004() {
        Response response = given()
                .basePath("/products")
                .pathParam("id","346575") //9999712  185267
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }
    @Test //retrieve id and validate id has delete
    public void test005() {
        Response response = given()
                .basePath("/products")
                .pathParam("id","346575") //9999712  185267
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }

}
