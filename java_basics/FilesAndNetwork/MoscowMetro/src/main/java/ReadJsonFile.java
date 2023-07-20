import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadJsonFile {
    public void readFile(String path) throws ParseException {
        if (Files.exists(Paths.get(path))) {
            JSONParser parser = new JSONParser();
            JSONObject stationsObject = (JSONObject) ((JSONObject) parser.parse(getJsonFile(path))).get("stations");
            stationsObject.keySet().forEach(lineNumber -> System.out.println("На линии \"" + lineNumber +
                    "\" находится " + ((JSONArray) stationsObject.get(lineNumber)).size() + " станций"));

            JSONArray connectObject = (JSONArray) ((JSONObject) parser.parse(getJsonFile(path))).get("connection");
            System.out.println("В Московском метро есть " + connectObject.size() + " переходов");
        } else System.out.println("Json-файл отсутствует!!!");
    }

    private String getJsonFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return builder.toString();
    }
}