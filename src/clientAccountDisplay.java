import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by erik on 2017-04-09.
 */
public class clientAccountDisplay {

    private static final String  USER_AGENT = "Mozilla/5.0";


    private static void sendGet(String ip, String port, String accountID) throws Exception{

        // url
        String url = "http://" + ip + ":" + port + "/mytest";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("AccountID", accountID);
        int responeCode = con.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responeCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null){
            response.append(inputLine + "\n");
        }
        in.close();

        System.out.println(response.toString());

    }
    public static void main(String[] args) {
        try {
            sendGet(args[1],args[3],args[5]);
        }catch (Exception e){
            System.out.println("ERROR OCCURED, " + e.getMessage());
        }
    }
}
