package GeekBrains.Core.Seminar5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackUp {
    public static void runBackUp() throws IOException {
        Path projectPath = Path.of(".\\Core\\Seminar5");

        Path backup = Paths.get(String.valueOf(projectPath), "backup").toAbsolutePath();
        if (!Files.exists(backup)) {
            Files.createDirectories(backup);
        }

        File[] files = projectPath.toFile().listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                Path sourceFile = file.toPath().toAbsolutePath();
                System.out.println("sourceFile -> " + sourceFile);
                Path fileName = projectPath.toAbsolutePath().relativize(sourceFile);
                System.out.println("fileName -> " + fileName);
                Path backupWithFileName = Paths.get(String.valueOf(backup), String.valueOf(fileName));
                System.out.println("backupWithFileName -> " + backupWithFileName);
                Files.copy(sourceFile, backupWithFileName);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        runBackUp();
    }
}

