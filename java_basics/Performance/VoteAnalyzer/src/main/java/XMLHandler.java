import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private int countVoter = 0;
    private final int COUNT_ADD = 500_000;
    private int countTransactions = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        try {
            if (qName.equals("voter")) {
                countVoter++;
                DBConnection.countVoter(attributes.getValue("name"), attributes.getValue("birthDay"));
                if (countVoter > COUNT_ADD){
                    long start = System.nanoTime();
                    DBConnection.executeMultiInsert();
                    countVoter = 0;
                    long finish = (System.nanoTime() - start)/(1_000_000L * 1_000);
                    System.out.println("Партия № "+ ++countTransactions + " добавлена в БД за " + finish + " сек");
                }
            }

        } catch (Exception pE) {
            pE.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) {
            voter = null;
        }
    }
}