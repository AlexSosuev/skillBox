import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> images = new ArrayList<>();
        Elements img = Jsoup.connect("https://lenta.ru/").get().select("img");
        for (Element element : img) {
            String image = element.attr("abs:src");
            if (image.startsWith("https://icdn.lenta.ru/")) {
                images.add(image);
            }
        }
        downloadImages(images);
    }

    private static void downloadImages(ArrayList<String> images) {
        String folderToSaveFiles = "images/";
        for (String path : images) {
            try (InputStream in = new URL(path).openStream()) {
                Files.createDirectories(Paths.get(folderToSaveFiles));
                Files.copy(in, Paths.get(folderToSaveFiles + new File(path).getName()),
                        StandardCopyOption.REPLACE_EXISTING);
                System.out.println("файл - " + path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf('.'))
                        + " - скопирован успешно");
            } catch (Exception ex) {
                ex.getStackTrace();
            }
        }
    }
}