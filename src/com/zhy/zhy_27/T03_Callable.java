package com.zhy.zhy_27;

import java.util.concurrent.Callable;

/**
 * 带有返回值 可以抛出异常
 */
public class T03_Callable implements Callable {
    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
