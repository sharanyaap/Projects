package example;

/*
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.params.HttpConnectionParams;
*/

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sharanya.p on 12/15/2017.
 */
public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "https://sso-247-inc.oktapreview.com/";

        /*URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        //con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);



                *//*BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());*//*

        url = "http://host0160.dev.sv2.247-inc.net:8080/org-hierarchy-service/";

        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);*/

        try {
            /*CloseableHttpClient httpclient;
            int timeout = 5;
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(timeout * 1000)
                    .setConnectionRequestTimeout(timeout * 1000)
                    .setSocketTimeout(timeout * 1000).build();


            HttpHost proxy = new HttpHost("cache.backside.sv2.tellme.com", 3128, "http");
            DefaultProxyRoutePlanner routePlaner = new DefaultProxyRoutePlanner(proxy);
            httpclient = HttpClients.custom().setRoutePlanner(routePlaner).setDefaultRequestConfig(config).build();

            //httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

            url = "https://sso-247-inc.oktapreview.com/api/v1/sessions/me";
            HttpGet httpGet = new HttpGet(url);
            //httpGet.addHeader(ACCEPT, APPLICATION_JSON);
            //httpGet.addHeader(CONTENT_TYPE, APPLICATION_JSON);
            // httpclient.execute(httpGet);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response :: " + response.getStatusLine());*/
        } catch (Exception e) {
            System.out.println("Exception :: " + e);
        }
    }

}

