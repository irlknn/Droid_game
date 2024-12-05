import java.io.*;

public class FileWork {
    private static final String FILE_NAME = "battle_log.txt";

    private PrintStream originalOut;
    private PrintStream fileOut;
    private PrintStream teeStream;

    public void download() {
        try {
            // Перенаправляємо вивід в консоль і у файл
            redirectOutputToFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Метод для завершення запису битви у файл
    public void stopLogging() {
        // Закриваємо потік файлу
        if (fileOut != null) {
            fileOut.close();
        }

        // Повертаємо стандартний вивід назад в консоль
        if (originalOut != null) {
            System.setOut(originalOut);
        }
    }

    public void redirectOutputToFile() throws FileNotFoundException {
        originalOut = System.out;
        fileOut = new PrintStream(new FileOutputStream(FILE_NAME, true));

        teeStream = new TeeStream(originalOut, fileOut);

        System.setOut(teeStream);
    }

    public void upload() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Історія битв:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Виведення історії битв з файлу
            }
        } catch (FileNotFoundException e) {
            System.out.println("Історія битв ще не збережена!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
