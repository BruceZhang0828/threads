package com.zhy.zhy_26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T02_SynchronizedList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(list);
    }
}
