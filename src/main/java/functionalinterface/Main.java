package functionalinterface;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = number -> {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(integerPredicate.test(3));


        Consumer<Integer> integerConsumer = number -> System.out.println((int) (Math.random() * number));
        integerConsumer.accept(10);


        Supplier<DayOfWeek> dayOfWeekSupplier = ()-> DayOfWeek.from(LocalDate.now());
        System.out.println(dayOfWeekSupplier.get());


        Function<Double,Long> doubleLongFunction = number -> Math.round(number);
        System.out.println(doubleLongFunction.apply(4.378677));



        UnaryOperator<Integer> integerUnaryOperator = number->{
            int first=0;
            int second  = 1;
            int third;
            for (int i = 2; i <=number; i++) {
                third = first+second;
                first = second;
                second=third;
            }
            return first;
        };
        System.out.println(integerUnaryOperator.apply(4));
    }

}
