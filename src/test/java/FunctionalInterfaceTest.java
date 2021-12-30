import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalInterfaceTest {

    @Test
    public void shouldReturnTrueIfNumberIsPrime() {
        Predicate<Integer> integerPredicate = number -> {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        };
        Assertions.assertTrue(integerPredicate.test(3));
    }
    @Test
    public void shouldReturnDayOfWeek(){
        Supplier<DayOfWeek> dayOfWeekSupplier = ()-> DayOfWeek.from(LocalDate.now());
        Assertions.assertEquals(dayOfWeekSupplier.get(),DayOfWeek.from(LocalDate.now()));
    }
    @Test
    public void shouldRoundDoubleToLongNumber(){
        Function<Double,Long> doubleLongFunction = number -> Math.round(number);
        Assertions.assertEquals(doubleLongFunction.apply(4.4434),4);
    }
    @Test
    public void shouldFindTheIndexOfFibonacciNumbers(){

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
        Assertions.assertEquals(integerUnaryOperator.apply(5),3);

    }
}