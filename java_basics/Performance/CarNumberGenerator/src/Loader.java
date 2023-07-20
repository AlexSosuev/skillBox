import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader implements Runnable {
    private final int regionCode;

    Loader(int regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public void run() {
        String regionCodeTemp = padNumber(regionCode, 2);
        try {
            PrintWriter writer = new PrintWriter("res/numbers" + regionCodeTemp + ".txt");
            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int number = 1; number < 1000; number++) {
                StringBuilder builder = new StringBuilder();
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter).append(padNumber(number, 3))
                                    .append(secondLetter).append(thirdLetter)
                                    .append(regionCodeTemp).append('\n');
                        }
                    }
                }
                writer.write(builder.toString());
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }
}