package GeekBrains.Core.Seminar5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Code {
    public static void main(String[] args) throws IOException {
        Path file = Files.createFile(Paths.get("../pics/file.txt"));
        System.out.print("Was the file captured successfully in pics directory ? ");
        System.out.println(Files.exists(Paths.get("../pics/file.txt")));
        Path testDirectory = Files.createDirectory(Paths.get("./testing"));
        System.out.print("Was the test directory created successfully? ");
        System.out.println(Files.exists(Paths.get("./testing")));
        file = Files.move(file, Paths.get("./testing/file.txt"), REPLACE_EXISTING);
        System.out.print("Is our file still in the pics directory? ");
        System.out.println(Files.exists(Paths.get("../pics/file.txt")));
        System.out.print("Has our file been moved to testDirectory? ");
        System.out.println(Files.exists(Paths.get("./testing/file.txt")));
        Path copyFile = Files.copy(file, Paths.get("../pics/file.txt"), REPLACE_EXISTING);
        System.out.print("Has our file been copied to pics directory? ");
        System.out.println(Files.exists(Paths.get("../pics/file.txt")));
        Files.delete(file);
        System.out.print("Does the file exist in test directory? ");
        System.out.println(Files.exists(Paths.get("./testing/file.txt")));
        System.out.print("Does the test directory exist? ");
        System.out.println(Files.exists(Paths.get("./testing")));


//        Was the file captured successfully in pics directory?true
//        Was the test directory created successfully?true
//        Is our file still in the pics directory?false
//        Has our file been moved to testDirectory ? true
//        Has our file been copied to pics directory?true
//        Does the file exist in test directory ? false
//        Does the test directory exist ? true
    }
}
