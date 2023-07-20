import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class Main {
    private static final String SITEMAP_DOC = "src/main/resources/sitemap.txt";
    private static final String linkScrapingSite = "https://skillbox.ru/";

    public static void main(String[] args) throws IOException {
        if (!Files.exists(Paths.get(SITEMAP_DOC))) {
            Files.createDirectories(Paths.get(SITEMAP_DOC).getParent());
        } else {
            Files.delete(Paths.get(SITEMAP_DOC));
        }

        LinkPull linkPull = new LinkPull(linkScrapingSite);
        Set<String> link = linkPull.compute();

        try {
            PrintWriter writer = new PrintWriter(SITEMAP_DOC);
            link.forEach(element -> {
                String[] strings = element.split("/");
                writer.write(tab(strings) + element + "\n");
            });
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }

    private static String tab(String[] strings) {
        StringBuilder string = new StringBuilder();
        int tab = strings.length - 3;
        if (tab > 0) {
            string.append("\t".repeat(tab));
        }
        return String.valueOf(string);
    }
}