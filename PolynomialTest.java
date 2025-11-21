import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class PolynomialTest {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject data = (JSONObject) parser.parse(new FileReader("input2.json"));
            JSONObject poly = (JSONObject) data.get("polynomial");
            JSONArray coeffs = (JSONArray) poly.get("coefficients");
            JSONArray xVals = (JSONArray) data.get("x_values");

            for (Object xObj : xVals) {
                double x = ((Number) xObj).doubleValue();
                double result = 0;
                int n = coeffs.size();
                for (int i = 0; i < n; i++) {
                    double coef = ((Number) coeffs.get(i)).doubleValue();
                    result += coef * Math.pow(x, n - i - 1);
                }
                System.out.println("P(" + x + ") = " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
