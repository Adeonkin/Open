package forApi.dataForApi.stepsForApi;

import forApi.dataForApi.Human;
import forApi.dataForApi.Data;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class CheckJson {

    public void checkJsonFieldsNotNull(Data listUser) {
        listUser.getData().forEach(x -> Assert.assertNotNull(x.getId()));
        listUser.getData().forEach(x -> Assert.assertNotNull(x.getEmail()));
        listUser.getData().forEach(x -> Assert.assertNotNull(x.getFirst_name()));
        listUser.getData().forEach(x -> Assert.assertNotNull(x.getLast_name()));
        listUser.getData().forEach(x -> Assert.assertNotNull(x.getAvatar()));
        Assert.assertNotNull(listUser.getPage());
        Assert.assertNotNull(listUser.getPerPage());
        Assert.assertNotNull(listUser.getTotal());
        Assert.assertNotNull(listUser.getTotal_pages());
        Assert.assertNotNull(listUser.getSupport());
    }

    public void checkEqualsPeople(JsonPath jsonResponse, Human date){
        Assert.assertEquals((String) jsonResponse.get("name"), (String) date.getName(), "Name is not valid");
        Assert.assertEquals((String) jsonResponse.get("job"), (String) date.getJob(), "Job is not valid");
    }
}
