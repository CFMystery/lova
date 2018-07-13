package cn.fanhub.lova.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsTest {

    @Test
    public void testSortByValue() {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> sortMap = MapUtils.sortByValue(map);

        Map<Integer, Double> map1 = new HashMap<>();
        Map<Integer, Double> sortMap1 = MapUtils.sortByValue(map1);
    }
}
