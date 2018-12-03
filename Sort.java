package com.company;

import java.util.ArrayList;
public interface Sort {
    @SuppressWarnings("rawtypes")
    public <T extends Comparable> ArrayList<T> sortArray(ArrayList<T> arr);
}