import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {
    //TODO Создание json-файла
    public void writeInJSONFile(JSONObject object, String path) throws Exception {
        if (!Files.exists(Paths.get(path).getParent())) {
            Files.createDirectories(Paths.get(path).getParent());
        }
        FileWriter file = new FileWriter(path);
        file.write(getMetro(object));
        file.flush();
        file.close();
    }

    //TODO Форматирование Json-файла из строки в дерево
    private String getMetro(JSONObject metro) throws ParseException {
        JSONParser parser = new JSONParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(parser.parse(metro.toJSONString()));
    }
}