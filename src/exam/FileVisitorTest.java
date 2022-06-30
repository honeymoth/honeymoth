package exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

public class FileVisitorTest{
    static Path start = FileSystems.getDefault().getPath("C:\\Users\\User\\Desktop\\english");

    public static void main(String[] args) throws IOException {
        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(start, fc);
        List<Path> allFiles = fc.getAllFiles();
        Map<String, List<Path>> allFilesByExtension = fc.getFilesByExtension();
        System.out.println(allFilesByExtension);
        printList(allFiles);
        FileVisitor();
    }
    static void FileVisitor(){
        try {
            Files.walkFileTree(start, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Заходим в каталог "+ getName(dir.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Найден файл "+ getName(file.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.out.println("Файл с ошибкой "+ getName(file.toString()));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("Выходим из каталога "+ getName(dir.toString()));
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static String getName(String p){
        int flag = p.lastIndexOf('\\');
        p = p.substring(flag+1);
        return p;
    }
    static void printList(List<Path> l) {
        l.forEach(System.out::println);
    }
}
