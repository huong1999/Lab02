package com.company;

import java.util.ArrayList;

public class Main implements Sort{

    public static void main(String[] args) {
        System.out.println("-Truoc khi sap xep : ");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(10);
        arr.add(7);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "\t");
        }
        System.out.println();

        Main mt = new Main();
        mt.sortArray(arr);
        System.out.println("-Sau khi sap xep : ");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "\t");
        }
    }

    @Override
    public <T extends Comparable> ArrayList<T> sortArray(ArrayList<T> arr) {
        if(arr == null) return null;
        else {
            boolean continueSort = true;
            while(continueSort) {
                continueSort = false;
                for(int i = 0; i < arr.size()-1; i++) {
                    if(arr.get(i).compareTo(arr.get(i+1)) >= 0) {
                        //lay phan tu thu i luu vao element
                        T element = arr.get(i);
                        //xoa phan tu thu i do
                        arr.remove(i);
                        //them phan tu element vao vi tri i+1
                        arr.add(i+1, element);
                        //van con phan tu ko dung vi tri => tiep tuc sap xep
                        continueSort = true;
                    }
                }
            }
        }
        return arr;
    }

}