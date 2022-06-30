package exam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static exam.FileVisitorTest.start;

public class FilesCollector implements FileVisitor<Path> {

    public List<Path> getAllFiles() {
        List<Path> files = new ArrayList<>();
        try {
            Files.walkFileTree(start, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    files.add(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return files;
    }

    public Map<String,List<Path>> getFilesByExtension(){
        List<Path> list = getAllFiles();
        List<String> extentions = new ArrayList<>();
        Map<String,List<Path>> files = new LinkedHashMap<>();
        for (int i = 0; i != list.size();++i ){
            String path = list.get(i).toString();
            String extention = path.substring(path.lastIndexOf("."));
            if (extentions.contains(extention) == false) {
                extentions.add(extention);
                List<Path> fileList = new ArrayList<>();
                for (int j = i; j != list.size(); ++j) {
                    path = list.get(j).toString();
                    String end = path.substring(path.lastIndexOf("."));
                    if (end.equals(extention)) {
                        fileList.add(list.get(j));
                    }
                }
                files.put(extention,fileList);
            }

        }
        return files;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}



