import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Base {
    public static void main(String[] args) throws FileNotFoundException {
        int count, maxCount = 0;
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
        String word = "";
        String line = scanner.nextLine();

        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, line.split(" "));
        arrayList.sort(String::compareToIgnoreCase);
        Set<String> unic = new HashSet<>(arrayList);
        ArrayList<String> arrayListUnic = new ArrayList<String>(unic);
        for (int i = 0; i < arrayListUnic.size(); i++) {
            count = 0;
            for (String s : arrayList) {
                if (arrayListUnic.get(i).equals(s)) {
                    count++;
                }
            }
            System.out.println("Слово " + arrayListUnic.get(i) + " встречалось " + count + " раз(а).");
            if (count >= maxCount) {
                maxCount = count;
                word = arrayList.get(i);
            }
        }
        System.out.println("Самое популярное слово: " + word.toUpperCase(Locale.ROOT) + ", встретилось в файле " + maxCount + " раз(а).");
        scanner.close();
    }
}
