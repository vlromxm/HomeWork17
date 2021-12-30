package stream;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<People> peopleList = List.of(
                new People("Vasyl", 16, Sex.MAN),
                new People("Petro", 23, Sex.MAN),
                new People("Elena", 42, Sex.WOMAN),
                new People("Hanna", 50, Sex.WOMAN),
                new People("Oleh", 34, Sex.MAN),
                new People("Kateryna", 63, Sex.WOMAN),
                new People("Vladislav", 26, Sex.MAN),
                new People("Lyudmyla", 60, Sex.WOMAN)
        );
        peopleList.stream()
                .filter(people -> people.getAge() < 27 && people.getAge() > 18&&people.getSex().equals(Sex.MAN))
                .forEach(people -> System.out.println("Военнообязаны мужчины: " + people));

        peopleList.stream()
                .filter(people -> people.getSex().equals(Sex.MAN))
                .mapToInt(people -> people.getAge())
                .average().ifPresent(avg -> System.out.println("Средний возраст мужчин: " + avg));

        peopleList.stream()
                .filter(people -> people.getSex().equals(Sex.MAN) && people.getAge() > 18 && people.getAge() < 60
                        || people.getSex().equals(Sex.WOMAN) && people.getAge() > 18 && people.getAge() < 55)
                .sorted(Comparator.comparing(People::getSex))
                .forEach(people -> System.out.println("Работоспособные люди: " + people));
    }

}
