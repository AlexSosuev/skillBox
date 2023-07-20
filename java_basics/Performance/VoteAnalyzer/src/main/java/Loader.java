import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";

        long usage = System.currentTimeMillis();
        parseBySAX(fileName);
        System.out.println("\n" + (System.currentTimeMillis() - usage) + " ms\n");
    }

    private static void parseBySAX(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        DBConnection.executeMultiInsert();
        //DBConnection.printVoterCounts();
    }
}