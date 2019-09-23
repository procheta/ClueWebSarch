/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retriever;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Procheta
 */
public class retriever {

    public String retrieve(String query, int num) throws UnsupportedEncodingException, MalformedURLException {
        String charset = "UTF-8";
        String response = "";
        URL url = new URL("http://clueweb.adaptcentre.ie/WebSearcher/search?query=" + URLEncoder.encode(query, charset));
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String all = "";
            String line;
            while ((line = in.readLine()) != null) {
                all += line;
            }
            
            JSONObject jobJSONObject = new JSONObject();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(all);
            ArrayList arr = new ArrayList<String>();
            int count = 0;
            if (num > jsonArray.size() - 1) {
                num = jsonArray.size() - 1;
            }
            for (int j1 = 0; j1 < num; j1++) {

                String st1 = ((Object) jsonArray.get(j1)).toString();
                String st2 = st1.replace("[", "");
                st2 = st2.replace("]", "");
                char d = '"';
                String st4 = st2.substring(st2.indexOf("id" + d), st2.length());
                // String title = st2.substring(st2.indexOf("title") + 8, st2.indexOf("snippet") - 3);
                String title = st2.substring(st2.indexOf("title") + 8, st2.indexOf("url") - 3);
                //response += title+"<br>"; 
                //String Snippet = st2.substring(st2.indexOf("snippet") + 10, st2.indexOf("url") - 3);
                String Snippet = st2.substring(st2.indexOf("snippet") + 10, st2.indexOf("id") - 3);
                Snippet = Snippet.replaceAll("n", "");
                Snippet = Snippet.replaceAll("t", "");
                Snippet = Snippet.replaceAll("\\\\", "");
                Snippet = Snippet.replaceAll("<B>", "");
                Snippet = Snippet.replaceAll("</B>", "");
                
                
                 String st7 = st4;
                 String docid = "";
                try {
                    st4 = st4.substring(0, st4.indexOf(","));
                    String st3[] = st2.split(",");
                    String st5[] = st4.split(":");
                    st5[1] = st5[1].replace("" + d, "");
                    docid = st5[1];
                } catch (Exception e) {
                    st7 = st7.substring(st7.indexOf(",") + 1, st7.length());
                    String st8 = st7.substring(0, st7.indexOf(","));
                    String st5[] = st8.split(":");
                    //System.out.println(st8);
                    st5[1] = st5[1].replace("" + d, "");
                    docid = st5[1];
                }
                
                String link = "http://clueweb.adaptcentre.ie/WebSearcher/view?docid="+docid;
                response += "<a href="+link+">"+title+"</a><br>";
                response += Snippet+ "<br>";
                // title = title.replace("", param1)
                //title = title.replaceAll(, "");
                // System.out.println(title);
                // System.out.println(Snippet);
            }

        } catch (Exception e) {
            System.out.println("entered" + e);
            e.printStackTrace();
        }

        return response;
    }

}
