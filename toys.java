package JavaApp;

import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.util.Map;
import java.util.HashSet;

public class toys {
    private static HashMap<Integer, String> criteria = new HashMap();

    private String name;

    public toys(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        Set<toys> toy = new HashSet<>();
        toy.add(new toys("машинка"));
        toy.add(new toys("кукла"));
        toy.add(new toys("вертолет"));
        toy.add(new toys("лизун"));
        toy.add(new toys("рагатка"));

        HashMap<Integer, String> filteringCriteria = new HashMap<>();
        numeringValues();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру от 1 до 5 (или 0 для вывода всех игрушек): ");
        // System.out.println(criteria);

        while (true) {
            int command = scanner.nextInt();
            if (0 == command) {
                Set<toys> result = filter(toy, filteringCriteria);
                if (!result.isEmpty())
                    System.out.println(result);
                else
                    System.out.println(toy);
                break;
            } else if (criteria.containsKey(command)) {
                System.out.println("Введите название игрушки: ");
                String value = scanner.next();
                filteringCriteria.put(command, value);
            } else {
                System.out.println("Неверные данные: ");
            }
        }
    }

    private static Set<toys> filter(Set<toys> toy, HashMap<Integer, String> filteringCriteria) {
        if (null != filteringCriteria && !filteringCriteria.isEmpty()) {
            for (Map.Entry<Integer, String> criterion : filteringCriteria.entrySet()) {
                if (criteria.containsKey(criterion.getKey())) {
                    return filterToys(toy, criteria.get(criterion.getKey()), criterion.getValue());
                }
            }
        }
        return toy;
    }

    private static Set<toys> filterToys(Set<toys> toy, String criterionName, String criterionValue) {
        Set<toys> result = new HashSet<>();

        for (toys info : toy) {
            if ("Name".equals(criterionName) && info.getName().equalsIgnoreCase(criterionValue))
                result.add(info);
        }
        return result;
    }

    private static void numeringValues() {
        criteria.put(1, "машинка");
        criteria.put(2, "кукла");
        criteria.put(3, "вертлет");
        criteria.put(4, "лизун");
        criteria.put(5, "рагатка");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
