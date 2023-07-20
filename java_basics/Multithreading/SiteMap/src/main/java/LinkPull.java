import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class LinkPull extends RecursiveTask<Set<String>> {

    private final String href;
    private static final Set<String> allLinks = new TreeSet<>();

    public LinkPull(String url) {
        this.href = url;
        System.out.println(url);
    }

    @Override
    public Set<String> compute() {
        allLinks.add(href);
        Set<String> linksInsideCompute = parsePage(href);
        List<LinkPull> taskList = new ArrayList<>();
        for (String link : linksInsideCompute) {
            LinkPull links = new LinkPull(link);
            links.fork();
            taskList.add(links);
        }
        taskList.forEach(ForkJoinTask::join);
        return allLinks;
    }

    public Set<String> parsePage(String url) {
        Document doc;
        Set<String> links = new TreeSet<>();
        try {
            doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements elements = doc.select("a[href]");
            for (Element element : elements) {
                String link = element.absUrl("href");
                if (checkURL(link) && addNewURL(link)) {
                    links.add(link);
                }
            }
            Thread.sleep(200);
        } catch (HttpStatusException ex) {
            return new TreeSet<>();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return links;
    }

    private synchronized boolean addNewURL(String url) {
        return allLinks.add(url);
    }

    private static boolean checkURL(String url) {
        return url.startsWith("https://skillbox.ru/") && url.endsWith("/");
    }
}