package ohs;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sharanya.p on 2/23/2018.
 */
public class NetClientPost {

    // http://localhost:8080/RESTfulExample/json/product/post
    public static void main(String[] args) {
        String filePath = "D:/Project/CLOUD-12898-Script/update_user_nemo-client-optus_13_03_2018_2.json";
        String serverurl = "http://localhost:6060/org-hierarchy-service/adminEntity/update?entity";
        //try {
        //	serverurl = java.net.URLEncoder.encode("http://localhost:6061/org-hierarchy-service/adminEntity/update?entity","UTF-8");
        //	} /*catch (UnsupportedEncodingException e2) {
        // TODO Auto-generated catch block
        //	e2.printStackTrace();
        //}*/
        StringBuilder fileData = new StringBuilder(1000);//Constructs a string buffer with no characters in it and the specified initial capacity
        BufferedReader reader;
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter1 = null;
        try {
            File myFile = new File("D:/Project/CLOUD-12898-Script/update_user_nemo-client-optus_Error_13_03_2018_2.json");
            File myFile1 = new File("D:/Project/CLOUD-12898-Script/update_user_nemo-client-optus_ErrorOutput_13_03_2018_2.txt");
            // check if file exist, otherwise create the file before writing
            /*if (!myFile.exists()) {
                myFile.createNewFile();
            }*/
            Writer writer = new FileWriter(myFile);
            Writer writer1 = new FileWriter(myFile1);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter1 = new BufferedWriter(writer1);
            reader = new BufferedReader(new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String returnStr = fileData.toString();
        System.out.println(returnStr);
        String[] restUrls = returnStr.split("\\n");
        for (String restUrl : restUrls) {
            try {
                String encodedURL = java.net.URLEncoder.encode("[" + restUrl + "]", "UTF-8");
                System.out.println(encodedURL);
                URL url = new URL(serverurl + "=" + encodedURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    if (output.contains("ERROR")) {
                        bufferedWriter.write(restUrl + "\n");
                        bufferedWriter1.write(output + "\n");
                        System.out.println(restUrl);
                        System.out.println(output);
                    }
                }

                conn.disconnect();
            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
        if (bufferedWriter != null)
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (bufferedWriter1 != null)
            try {
                bufferedWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
