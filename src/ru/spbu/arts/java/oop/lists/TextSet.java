package ru.spbu.arts.java.oop.lists;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TextSet {
    public static void main(String[] args) throws Exception {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        doReadWordsInFile(hashSet);
        doReadWordsInFile(linkedHashSet);
        doReadWordsInFile(treeSet);
    }

    private static void doReadWordsInFile(Set<String> set) throws Exception {
        //Path pathToFile = Paths.get(fileName);
        //Path file = Path.of(String.valueOf(pathToFile));
        Path file = Path.of("text/green.txt");
        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next();
                set.add(word.toLowerCase());
            }
        }
        System.out.println(set);
    }
}
