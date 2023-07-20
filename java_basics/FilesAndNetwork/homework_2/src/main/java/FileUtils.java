import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        Files.walk(Paths.get(sourceDirectory)).forEach(source -> {
            try {
                Files.copy(source, Paths.get(destinationDirectory,
                        source.toString().substring(sourceDirectory.length())),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Копирование завершено успешно");
    }
}