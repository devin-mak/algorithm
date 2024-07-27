package com.wheat.algorithm.base.utils;

import cn.hutool.core.lang.Assert;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maij
 * @description:
 * @date 2023-11-06 16:29
 **/
public class CollectionUtil {

    public static <T> ArrayList<T> newArrayList(T ...elem) {
        Assert.notEmpty(elem);
        ArrayList<T> list = new ArrayList<>(elem.length);
        list.addAll(Arrays.asList(elem));
        return list;
    }
}
