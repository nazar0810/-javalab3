import java.util.function.Function;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.*;
public class TestIterable {
    @Test
    public void  int_filter_test(){
        ArrayList<Integer> int_list = new ArrayList<>();
        int_list.add(0);
        int_list.add(1);
        int_list.add(2);
        int_list.add(0);
        Predicate<Integer> p = number -> number==0;
        ArrayList<Integer> expected_int_list = new ArrayList<>();
        expected_int_list.add(0);
        expected_int_list.add(0);
        assertEquals(MyIterable.filter(int_list,p),expected_int_list);

    }
    @Test
    public void filter_float_Test() {
        ArrayList<Float> float_list = new ArrayList<>();
        float_list.add(1.66f);
        float_list.add(3f);
        float_list.add(-4.3f);
        Predicate<Float> p = number -> number <= 0;
        ArrayList<Float> expected_float_list = new ArrayList<>();
        expected_float_list.add(-4.3f);
        assertEquals(MyIterable.filter(float_list, p), expected_float_list);
    }
    @Test
    public void filter_str_Test() {
        ArrayList<String> str_list = new ArrayList<>();
        str_list.add("aaa");
        str_list.add("abc");
        str_list.add("ab");
        Predicate<String> p = str -> str.charAt(1)=='b';
        ArrayList<String> expected_str_list = new ArrayList<>();
        expected_str_list.add("abc");
        expected_str_list.add("ab");
        assertEquals(MyIterable.filter(str_list, p), expected_str_list);
    }
    @Test
    public void filter_bool_Test() {
        ArrayList<Boolean> bool_list = new ArrayList<>();
        bool_list.add(true);
        bool_list.add(false);
        bool_list.add(true);
        Predicate<Boolean> p = bo -> !bo;
        ArrayList<Boolean> bool_list_result = new ArrayList<>();
        bool_list_result.add(false);
        assertEquals(MyIterable.filter(bool_list, p), bool_list_result);
    }

    @Test
    public void transform_int_Test() {
        ArrayList<Integer> int_list = new ArrayList<>();
        int_list.add(-6);
        int_list.add(6);
        int_list.add(-3);
        Function<Integer,Integer> foo = number -> number*-1;
        ArrayList<Integer> expected_int_list = new ArrayList<>();
        expected_int_list.add(6);
        expected_int_list.add(-6);
        expected_int_list.add(3);

        assertEquals(MyIterable.transform(int_list, foo), expected_int_list);
    }
    @Test
    public void transform_float_Test() {
        ArrayList<Float> float_list = new ArrayList<>();
        float_list.add(1.2f);
        float_list.add(5.4f);
        float_list.add(-2f);
        Function<Float,Integer> foo = Float::intValue;
        ArrayList<Integer> expected_float_list = new ArrayList<>();
        expected_float_list.add(1);
        expected_float_list.add(5);
        expected_float_list.add(-2);
        assertEquals(MyIterable.transform(float_list, foo), expected_float_list);
    }
    @Test
    public void transform_str_Test() {
        ArrayList<String> str_list = new ArrayList<>();
        str_list.add("AAAA");
        str_list.add("ABC");

        Function<String,String> foo = String::toLowerCase;
        ArrayList<String> expected_str_list = new ArrayList<>();
        expected_str_list.add("aaaa");
        expected_str_list.add("abc");
        assertEquals(MyIterable.transform(str_list, foo), expected_str_list);
    }
    @Test
    public void transform_bool_Test() {
        ArrayList<Boolean> bool_list = new ArrayList<>();
        bool_list.add(false);
        bool_list.add(true);
        bool_list.add(false);
        Function<Boolean,Boolean> foo = boo -> boo=!boo;
        ArrayList<Boolean> expected_bool_list = new ArrayList<>();
        expected_bool_list.add(true);
        expected_bool_list.add(false);
        expected_bool_list.add(true);

        assertEquals(MyIterable.transform(bool_list, foo), expected_bool_list);
    }
}
