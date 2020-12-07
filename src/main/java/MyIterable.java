import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyIterable {

    //Returns a view of unfiltered containing all elements that satisfy the input predicate retainIfTrue.
    public static <T> Iterable<T> filter(Iterable<T> initval, Predicate<? super T> condition) {
        List<T> result = new LinkedList<>();
        Iterator<T> iterator = initval.iterator();
        T currval;
        while (iterator.hasNext()) {
            currval = iterator.next();
            if (condition.test(currval))
                result.add(currval);
        }

        return result;
    }

    //Returns a view containing the result of applying function to each element of fromIterable.
    public static <F, T> Iterable<T> transform(Iterable<F> iterab,
                                               Function<? super F, ? extends T> foo)
    {
        List<T> result = new LinkedList<>();
        Iterator<F> iterator = iterab.iterator();
        F currval;
        while(iterator.hasNext()) {
            currval = iterator.next();
            result.add(foo.apply(currval));
        }
        return result;
    }
}
