package vip.codemonkey.datastore.data.sample.repository;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTest {

    @Test
    public void test(){
        List<String []> list = new ArrayList<>();

        String [] ar1 = {"8:00","9:00"};
        list.add(ar1);
        String [] ar2 = {"8:30","9:30"};
        list.add(ar2);
        String [] ar3 = {"9:00","10:00"};
        list.add(ar3);

        List<String[]> sortedList = list.stream().sorted(Comparator.comparing(it -> it[0])).collect(Collectors.toList());
        for (String [] sarr:sortedList){
            System.out.println(sarr[0]+"-"+sarr[1]);
        }
    }
}
