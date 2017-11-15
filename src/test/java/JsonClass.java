
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class JsonClass {
    static Object ob;
    String fileName="sample";
    public static void main(String args[]) throws FileNotFoundException {
        String jsonpath="C:\\Users\\hbansal\\IdeaProjects\\SampleMavenProject\\src\\main\\resources\\json\\filename.json";
        Scanner scanner=new Scanner(new File(jsonpath));
        String next=scanner.useDelimiter("\\Z").next();
       // System.out.println(next);
        JSONObject obj=new JSONObject(next);
        /*String title=(String) obj.get("content_item_state_code");
        System.out.println(title);*/
        Object content_obj = obj.get("content_item");
        if(content_obj instanceof JSONObject){
            JSONObject jsonObj = (JSONObject)content_obj;
            String[] keys = JSONObject.getNames(jsonObj);
            for(String key: keys){
                if(key.equalsIgnoreCase("contributors"))
                {
                    ob=jsonObj.get(key);
                    break;
                }
                System.out.println("The key is>>>>>>>>>>>>>" + key + "The value is--------------" + jsonObj.get(key).toString());
            }
            if(ob instanceof JSONArray){
                JSONArray ar=(JSONArray) ob;
                for(int i=0;i<ar.length();i++){
                    JSONObject omn=ar.getJSONObject(i);
                    String slugid=omn.getString("slug");
                    if(slugid.equalsIgnoreCase("slug_ID_of_first_content_item")){
                        omn.put("slug","abc");
                        File fi=new File("C:\\Users\\hbansal\\IdeaProjects\\SampleMavenProject\\src\\main\\resources\\json\\sample_updated.json");
                        try {
                            FileWriter fil=new FileWriter(fi);
                            fil.write(obj.toString());
                            fil.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(slugid);
                }
            }

        }

    }


}
