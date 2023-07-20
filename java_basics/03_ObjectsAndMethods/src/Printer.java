public class Printer {
    private String queue = "";
    private int pendingPagesCount = 0;
    private int allPrinterPageCount;

    public Printer() {
        queue = "Список документов на печать: ";
    }

    public void append(String text) {
        append(text,"", 1);
    }

    public void append(String text, String name) {
        append(text, name, 1);
    }

    public void append(String text, String name, int pages) {
        queue = queue + "\n" + text + "; " + name + "; "+ pages;
        pendingPagesCount = pendingPagesCount + pages;
    }

    public void clear() {
        queue = "";
        pendingPagesCount = 0;
    }

    public void print() {
        System.out.println(queue);
        allPrinterPageCount = allPrinterPageCount + pendingPagesCount;
        clear();
    }

    public int getPendingPagesCount() {
            return pendingPagesCount;
    }

    public int getAllPrinterPageCount() {
        return allPrinterPageCount;
    }

}
