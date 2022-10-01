package com.products.productsdata;

import com.products.model.ProductsPojo;
import com.products.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUpdateData extends TestBase {

    @Test
    public void UpdateProductData() {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName("Merry");
        productsPojo.setType("Creser");
        productsPojo.setPrice(3.5f);

        Response response = given()
                .basePath("/products")
                .header("Content-Type", "application/json")
                .pathParam("id", "9999706")
                .body(productsPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
/* {
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
*/
