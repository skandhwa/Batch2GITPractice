package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.Assert;

import POJOMapper.CreateUser;
import Utilities.ReadDataFromPropertyFile;
import Utilities.UsingExcelInrestAssured;

public class stepDefinition {
	
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification respec;
	Response response;
	String PropertyURL=ReadDataFromPropertyFile.readDatafromProperty().getProperty("baseURI");
	String PropertyURL2=ReadDataFromPropertyFile.readDatafromProperty().getProperty("baseURI2");
	String TokenValue=ReadDataFromPropertyFile.readDatafromProperty().getProperty("Token");
	String strResponse;
	
	
	
	@Given("User will request to hit the application URL")
	public void user_will_request_to_hit_the_application_url() {
		
		req=new RequestSpecBuilder().setBaseUri(PropertyURL).
				setContentType(ContentType.JSON).build();
		
	   
	}

	@Given("User will pass the payload in the request")
	public void user_will_pass_the_payload_in_the_request() {
		
		res=given().log().all().
				relaxedHTTPSValidation().spec(req).body(CreateUser.createUser());
		
		
		
		
		
		
	   
	}

	@When("user will hit the {string}")
	public void user_will_hit_the(String endpoint) {
		
		respec=new ResponseSpecBuilder().expectStatusCode(200).build();
		  response=res.when().post(endpoint).then().spec(respec).extract().response();
		
		
	    
	}

	@Then("User is going to validate the response with {string}")
	public void user_is_going_to_validate_the_response_with(String status_code) {
		
		String s=status_code;
		int status_code_original=Integer.parseInt(s);
		int statuscode_expected=response.getStatusCode();
		System.out.println("The status code is "+statuscode_expected);
		Assert.assertEquals(status_code_original, statuscode_expected);
		
		
	   
	}
	
	@Given("User will login into the application with the corresponding baseURI")
	public void user_will_login_into_the_application_with_the_corresponding_base_uri() {
		
		req=new RequestSpecBuilder().setBaseUri(PropertyURL2).
				setContentType(ContentType.JSON).build();
		
	    
	}

	@Given("the User will pass the payload with the required token")
	public void the_user_will_pass_the_payload_with_the_required_token() throws IOException {
		
		
		res=given().log().all().headers("Authorization",TokenValue).
				relaxedHTTPSValidation().spec(req).body(UsingExcelInrestAssured.createUser());
		
	    
	}

	@When("User will submit the post request with corresponding endpoint as {string}")
	public void user_will_submit_the_post_request_with_corresponding_endpoint_as(String endpoint) {
		
		
		respec=new ResponseSpecBuilder().expectStatusCode(201).build();
		  response=res.when().post(endpoint).then().spec(respec).extract().response();
		
	   
	}

	@Then("User will be validating the status code as {string}")
	public void user_will_be_validating_the_status_code_as(String status_code) {
		
		String s=status_code;
		int status_code_original=Integer.parseInt(s);
		int statuscode_expected=response.getStatusCode();
		System.out.println("The status code is "+statuscode_expected);
		Assert.assertEquals(status_code_original, statuscode_expected);
		
		
	    
	}

	@Then("the User will validate the responsebody of the sent request")
	public void the_user_will_validate_the_responsebody_of_the_sent_request() {
		
		
		strResponse=response.asString();
		System.out.println(strResponse);
		JsonPath js=new JsonPath(strResponse);
		js.getString("");
		
		
		
	    
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
