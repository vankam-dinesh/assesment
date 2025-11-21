import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Load JSON file
            FileReader reader = new FileReader("data.json");

            // 2. Convert to JSON object
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject obj = new JSONObject(tokener);

            // 3. Print full JSON
            System.out.println("JSON File Loaded Successfully:");
            System.out.println(obj.toString(4)); // Pretty printing

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
