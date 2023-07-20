import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParserMoscowMetro {
    public JSONObject getMetro(JSONObject metro, String URL) throws IOException {
        Document document = Jsoup.connect(URL).maxBodySize(0).get();
        metro.put("stations", getStations(document));
        metro.put("lines", getLines(document));
        metro.put("connection", getConnection(document));
        return metro;
    }

    //TODO Линии
    private JSONArray getLines(Document document) {
        JSONArray lines = new JSONArray();
        document.getElementsByClass("js-metro-line").forEach(element -> {
            JSONObject line = new JSONObject();
            line.put("name", element.text());
            line.put("number", element.attr("data-line"));
            lines.add(line);
        });
        return lines;
    }

    //TODO Станции
    private JSONObject getStations(Document document) {
        JSONObject stations = new JSONObject();
        document.getElementsByClass("js-metro-stations").forEach(el -> el.children().forEach(element -> {
            if (stations.containsKey(el.attr("data-line"))) {
                JSONArray stationsLine = (JSONArray) stations.get(el.attr("data-line"));
                stationsLine.add(element.getElementsByClass("name").text());
            } else {
                JSONArray stationsArray = new JSONArray();
                stationsArray.add(element.getElementsByClass("name").text());
                stations.put(el.attr("data-line"), stationsArray);
            }
        }));
        return stations;
    }

    //TODO пересадки
    private JSONArray getConnection(Document document) {
        JSONArray connections = new JSONArray();
        document.getElementsByClass("single-station").forEach(child -> {
            JSONObject connection = new JSONObject();
            String oneline = child.parent().attr("data-line");
            String oneStation = child.text().substring(child.text().indexOf(". ") + 2);
            connection.put(oneline, oneStation);

            if (!child.getElementsByClass("t-icon-metroln").isEmpty()) {
                child.getElementsByClass("t-icon-metroln").forEach(child2 -> {
                    String nextLine = child2.getElementsByClass("t-icon-metroln").attr("class");
                    nextLine = nextLine.substring(nextLine.lastIndexOf('-') + 1);
                    String nextStation = child2.getElementsByClass("t-icon-metroln").attr("title");
                    nextStation = nextStation.substring(nextStation.indexOf('«') + 1, nextStation.indexOf('»'));
                    connection.put(nextLine, nextStation);
                });
            }
            if (!connections.contains(connection) && connection.size() > 1) {
                connections.add(connection);
            }
        });
        return connections;
    }
}
