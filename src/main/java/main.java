import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/starwars.json"));

            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {
                JSONObject object =(JSONObject) json.get(i);
                String nombre = object.get("Nombre").toString();
                String estatura = object.get("Estatura").toString();
                String año = object.get("Año de nacimiento").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
