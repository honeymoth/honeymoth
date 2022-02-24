import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class fileReader {
    public static void main(String[] args) throws Exception {
        readFile();
    }

    private static void readFile() throws Exception {
        String filename = "nums.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
        Path file = Path.of("text/nums.txt");
        int[] nums;
        try (Scanner in = new Scanner(file, StandardCharsets.UTF_8)) {
            nums = new int[in.nextInt()];
            int i = 0;
            while (in.hasNextInt()) {
                nums[i] = in.nextInt();
                i = i + 1;
            }
        }
        int[] sizes = new int[nums.length];
        int max = 0;
        for (int i = 0; i != nums.length; ++i) {
            int num = nums[i];
            while (num != 0) {
                num = num / 10;
                sizes[i] = sizes[i] + 1;
            }
            if (max < sizes[i]) {
                max = sizes[i];
            }
        }
        try (PrintStream outFile = new PrintStream("text/new_nums.txt", StandardCharsets.UTF_8)) {
            for (int i = 0; i != nums.length; ++i) {

                outFile.println(" ".repeat(max - sizes[i]) + nums[i]);
            }
        }
    }
}
