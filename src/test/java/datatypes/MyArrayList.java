package datatypes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-01-29
 */
public class MyArrayList {
    private List<String> myArrayList;

    public void createArrayList() {
        this.myArrayList = new ArrayList<>();
        myArrayList.add("zero");
        myArrayList.add("first");
        myArrayList.add("second");
    }

    @Test
    void test1() {
        createArrayList();
        System.out.println(myArrayList.toString());
    }
    @Test
    void test2() {
        createArrayList();
        System.out.println(myArrayList.toString());
    }
}