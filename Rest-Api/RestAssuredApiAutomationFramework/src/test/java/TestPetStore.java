import com.restassured.Listeners.TestListeners;
import com.restassured.constants.EndPoints;
import com.restassured.models.CreateNewPet.Category;
import com.restassured.models.CreateNewPet.CreatePet;
import com.restassured.models.CreateNewPet.Tag;
import com.restassured.utils.APIHeaders;
import com.restassured.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestPetStore {

    @Test(priority = 1, enabled = true, groups = "PetTests")
    public void addNewPet() throws IOException {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();
        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        CreatePet addNewPetVar = new CreatePet();
        Category setCategoryForPetVar = new Category();

        String petName = "Automationdoggie1";

        Tag setPetTagVar = new Tag();

        setPetTagVar.setId(0);
        setPetTagVar.setName("string");

        setCategoryForPetVar.setId(1);
        setCategoryForPetVar.setName("Dogs");


        List<String> photos = Arrays.asList("Photo1");

        List<Tag> object = new ArrayList<Tag>();
        object.add(0,setPetTagVar);

        addNewPetVar.setId(12);
        addNewPetVar.setName(petName);
        addNewPetVar.setCategory(setCategoryForPetVar);
        addNewPetVar.setPhotoUrls(photos);
        addNewPetVar.setStatus("available");
        addNewPetVar.setTags(object);

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");



        Response apiResponse;

        apiResponse = given().
                headers(getHeaderList).
                body(addNewPetVar).
                baseUri(BaseUrl).
                basePath(EndPoints.ADD_NEW_PET).
                when().
                post().
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(12)).
                body("name", equalTo(petName)).
                log().
                all().
                extract().
                response();
    }

    @Test(priority = 2, enabled = true, groups = "PetTests")
    public void getPetByStatus() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                basePath(EndPoints.GET_PET_BY_STATUS).with().queryParam("status","available").
                when().
                get().
                then().
                statusCode(200).
                assertThat().
                body("id", hasItem(12)).
                body("name", hasItem("Automationdoggie1")).
                log().
                all().
                extract().
                response();
    }


    @Test(priority = 3, enabled = true, groups = "PetTests")
    public void getPetByTag() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                basePath(EndPoints.GET_PET_BY_TAG).with().queryParam("tags","string").
                when().
                get().
                then().
                statusCode(200).
                assertThat().
                body("id", hasItem(12)).
                body("name", hasItem("Automationdoggie1")).
                log().
                all().
                extract().
                response();
    }


    @Test(priority = 4, enabled = true, groups = "PetTests")
    public void getPetByID() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                basePath(EndPoints.GET_PET_BY_ID).with().pathParam("ID","12").
                when().
                get().
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(12)).
                body("name", equalTo("Automationdoggie1")).
                log().
                all().
                extract().
                response();
    }

    @Test(priority = 5, enabled = true, groups = "PetTests")
    public void updatePetByID() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                contentType("multipart/form-data").
                basePath(EndPoints.UPDATE_PET_BY_ID).with().pathParam("petId","12").
                queryParam("name","Automationdoggie1").
                queryParam("status","sold").
                when().
                post().
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(12)).
                body("name", equalTo("Automationdoggie1")).
                body("status", equalTo("sold")).
                log().
                all().
                extract().
                response();
    }

    @Test(priority = 6, enabled = true, groups = "PetTests")
    public void uploadPetImage() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        File testUploadFile = new File("C:\\Users\\foaud.alam\\Desktop\\images (2).png");

        EncoderConfig ec = new EncoderConfig();
        ec.appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config().encoderConfig(ec.appendDefaultContentCharsetToContentTypeIfUndefined(false));


        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                config(RestAssured.config().encoderConfig(ec.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/octet-stream;").
                basePath(EndPoints.UPLOAD_PET_IMAGE).with().pathParam("petId","12").
                body(testUploadFile).
                when().
                post().
                then().
                statusCode(200).
                assertThat().
                body("photoUrls", iterableWithSize(2)).
                log().
                all().
                extract().
                response();
    }

    @Test(priority = 7, enabled = true, groups = "PetTests")
    public void updatePetViaPUT() throws IOException {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();
        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        CreatePet addNewPetVar = new CreatePet();
        Category setCategoryForPetVar = new Category();

        String petName = "Automationdoggie1";

        Tag setPetTagVar = new Tag();

        setPetTagVar.setId(0);
        setPetTagVar.setName("string");

        setCategoryForPetVar.setId(1);
        setCategoryForPetVar.setName("Dogs");


        List<String> photos = Arrays.asList("Photo1");

        List<Tag> object = new ArrayList<Tag>();
        object.add(0,setPetTagVar);

        addNewPetVar.setId(12);
        addNewPetVar.setName(petName);
        addNewPetVar.setCategory(setCategoryForPetVar);
        addNewPetVar.setPhotoUrls(photos);
        addNewPetVar.setStatus("pending");
        addNewPetVar.setTags(object);

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");



        Response apiResponse;

        apiResponse = given().
                headers(getHeaderList).
                body(addNewPetVar).
                baseUri(BaseUrl).
                basePath(EndPoints.ADD_NEW_PET).
                when().
                put().
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(12)).
                body("name", equalTo(petName)).
                body("status", equalTo("pending")).
                log().
                all().
                extract().
                response();
    }

    @Test(priority = 8, enabled = true, groups = "PetTests")
    public void deletePet() throws IOException {
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        ConfigManager getKey = new ConfigManager();

        System.out.println("*** Starting Test Case ***");
        System.out.println(" ");
        TestListeners logResult = new TestListeners();

        String BaseUrl = getKey.getKeyValue("baseURL");
        baseURI = BaseUrl;

        APIHeaders getHeadersList = new APIHeaders();
        Map<String, Object> getHeaderList = new HashMap<String, Object>();

        getHeaderList = getHeadersList.GetHeaders();

        System.out.println("*** Print User Headers Listing  ***");
        System.out.println(getHeaderList);
        System.out.println(" ");

        Response apiResponse;

        apiResponse = RestAssured.given().
                headers(getHeaderList).
                baseUri(BaseUrl).
                contentType("multipart/form-data").
                basePath(EndPoints.DELETE_BY_PET_ID).with().pathParam("petId","12").
                when().
                delete().
                then().
                statusCode(200).
                assertThat().
                log().
                all().
                extract().
                response();
    }

}
