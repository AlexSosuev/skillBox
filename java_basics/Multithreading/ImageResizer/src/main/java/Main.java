import java.io.File;

public class Main {
    private static final String srcFolder = "c:\\Vremen\\Foto\\src";
    private static final String dstFolder = "c:\\Vremen\\Foto\\dst";
    private static final long start = System.currentTimeMillis();
    private static final int newWidth = 300;
    private static final int processorCoreCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        File[] files = new File(srcFolder).listFiles();

        assert files != null;
        int temp = files.length / processorCoreCount;
        int tmp = files.length % processorCoreCount;

        for (int i = 0; i < processorCoreCount; i++) {
            temp = (i == (temp - tmp) && tmp > 0) ? temp + 1 : temp;
            File[] tmpFile = new File[temp];
            System.arraycopy(files, i * temp, tmpFile, 0, temp);
            new Thread(new ImageResizer(tmpFile, newWidth, dstFolder, start, i)).start();
        }
    }
}