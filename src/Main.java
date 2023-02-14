// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

/*Иван Иванов 88001122333
Иван Курицин 88001662333
Иван Курицин 88001112333
Иван Незлобин 88001122432
Сергей Потапов 88001112453
Сергей Потапов 8800163214
Сергей Курицин 8800142421
Михаил Незлобин 880012343

OutPut
Иван - 3
Сергей - 2
Потому как если один сотрудник имеет 2 или более номера , его имя считаем 1 раз.*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] emploees = new String[]{"Иван Иванов", "Иван Курицин", "Иван Незлобин", "Сергей Потапов", "Сергей Купмцин", "Михаил Незлобин"};
        ArrayList<String> emploeesName = getName(emploees);
        Map<String, Integer> mapName = getMap(emploeesName);
        System.out.println("Повторяющиеся имена c колличеством повторений: ");
        nameRepeat(mapName);
        System.out.println("Имена, по убыванию популярности: ");
        sortName(mapName);
    }

    public static ArrayList<String> getName(String[] list) {
        ArrayList<String> listName = new ArrayList<>();
        for (String el : list) {
            String[] elList = el.split(" ");
            listName.add(elList[0]);
        }
        return listName;
    }

    public static Map<String, Integer> getMap(ArrayList<String> name) {
        Map<String, Integer> mapName = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < name.size(); j++) {
                if (name.get(i).equals(name.get(j))) count += 1;
            }
            if (mapName.containsKey(name.get(i)) == false) mapName.put(name.get(i), count);
        }
        return mapName;
    }

    public static void nameRepeat(Map<String, Integer> map) {
        for (var item : map.entrySet()) {
            if (item.getValue() > 1) System.out.printf("%s: %d \n", item.getKey(), item.getValue());
        }
    }

    public static void sortName(Map<String, Integer> map) {
        Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
        ArrayList<Integer> listCount = new ArrayList<>();
        for (var item : map.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size() - 1; i > -1; i--) {
            for (var item : map.entrySet()) {
                if (listCount.get(i) == item.getValue())
                    System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }
}