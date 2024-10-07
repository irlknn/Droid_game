import java.io.*;

public class FileWork {
    private static final String FILE_NAME = "battle_log.txt";

    private PrintStream originalOut;  // Зберігаємо оригінальний потік System.out
    private PrintStream fileOut;      // Потік для запису у файл
    private PrintStream teeStream;    // Потік для одночасного виводу в консоль і файл

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

    // Метод для перенаправлення виводу в консоль і у файл
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

class TeeStream extends PrintStream {
    private final PrintStream secondStream;

    public TeeStream(PrintStream mainStream, PrintStream secondStream) {
        super(mainStream);
        this.secondStream = secondStream;
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        try {
            super.write(buf, off, len);
            secondStream.write(buf, off, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
        super.flush();
        secondStream.flush();
    }
}
