import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.FileReader;

public class Ventana {

    public static Object[][] personajes_array = new Object[9][3];
    public static void getJSON(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/starwars.json"));

            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {
                String[] subarray = new String[3];
                JSONObject object =(JSONObject) json.get(i);
                String nombre = object.get("Nombre").toString();
                String estatura = object.get("Estatura").toString();
                String edad = object.get("Año de nacimiento").toString();
                subarray[0] = nombre;
                subarray[1] = estatura;
                subarray[2] = edad;
                personajes_array[i] = subarray;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        public static Object[][] personajes_array = new Object[9][3];
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static JTable createTable()
    {
        String[] columnNames = {"First Name", "Last Name"};
        Object[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);

        return table;
    }
}