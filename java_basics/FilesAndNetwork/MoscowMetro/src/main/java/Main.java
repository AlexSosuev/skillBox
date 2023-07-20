import org.json.simple.JSONObject;

public class Main {
    private static final String URL = "https://skillbox-java.github.io/";
    private static final String PATH = "src/main/resources/moscowMetroMap.json";

    public static void main(String[] args) throws Exception {
        JSONObject metro = new JSONObject();
        new ParserMoscowMetro().getMetro(metro, URL);
        new WriteFile().writeInJSONFile(metro, PATH);
        new ReadJsonFile().readFile(PATH);
    }
}