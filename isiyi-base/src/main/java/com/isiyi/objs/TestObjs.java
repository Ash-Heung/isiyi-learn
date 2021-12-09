package com.isiyi.objs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestObjs {

    @Test
    public void test1(){

        int i = 0;
        String str = "0";
        swap(i);
        System.out.println(i);
        swap(str);
        System.out.println(str);

        List<String> list = new ArrayList<>();
        swap(list);
        System.out.println(list.size());
        System.out.println(list);

    }

    private void swap(int i){
        i = 2;
    }

    private void swap(String i){
        i = "2";
    }

    private void swap(List<String> list){
        list.add("2");
    }

    @Test
    public void testShard(){
        getCustomerSharding("9000000028");
    }

    public static void getCustomerSharding(String value) {
        //String value = "9000000021";
        Long delivery = Long.parseLong(value) % (4 * 8);
        String suffix = delivery.toString();
        if (delivery < 10) {
            suffix = "0" + delivery.toString();
        }
        System.out.println(suffix);
    }
}
