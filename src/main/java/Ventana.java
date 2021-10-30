import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.FileReader;

public class Ventana {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(Ventana.class);

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
        logger.info("{} ha sido cargada", Ventana.class.getSimpleName());
    }

    public static JTable createTable()
    {
        getJSON();
        String[] columnNames = {"Nombre", "Estatura", "Año de nacimiento"};
        JTable table = new JTable(personajes_array, columnNames);
        table.setFillsViewportHeight(true);
        logger.info("JTable ha sigo generada");
        return table;
    }
    public static void getJSON(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/starwars.json"));
            logger.info("JSON ha sido leido correctamente");
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
            logger.info("personajes_array se generó correctamente");
        } catch (Exception e) {
            logger.error(String.valueOf(e), e);
        }
    }
}