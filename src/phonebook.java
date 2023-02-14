import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Иван Иванов", List.of("88001122333"));
        phonBook.put("Иван Курицин", List.of("88001662333", "88001112333"));
        phonBook.put("Иван Незлобин", List.of("88001122432"));
        phonBook.put("Сергей Потапов", List.of("88001112453", "8800163214"));
        phonBook.put("Сергей Курицин", List.of("8800142421"));
        phonBook.put("Михаил Незлобин", List.of("880012343"));

        menu(phonBook);

    }
    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя и фамилию: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Функции: book - показать всю телефонную книгу, contact - найти контакт, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "book":
                        allBook(phonBook);
                        break;
                    case "contact":
                        find(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}