package spaceAndroid.util;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raihan on 6/29/16.
 */
public class APIException extends Throwable {
    public APIException(String message)
    {
        super(message);
    }


    public void sendTestRail(int status, String comment, int testRunID, int testCaseID) throws Exception, APIException {
        APIClient client = new APIClient("https://icehousecorp.testrail.com/");
        client.setUser("raihan@icehousecorp.com");
        client.setPassword("Yasier11");

        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "This test has been marked as "+comment);
        data.put("custom_defect_grade",new Integer(3));
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+ testRunID+"/"+testCaseID, data);
    }
}
