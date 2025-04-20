package com.design.pattern.java;

import java.util.List;

public class GenericQuiz {
    public static void main(String[] args) throws Exception {
        List<BooleanData> data = List.of(new BooleanData());
        List<Dummy> dummies = List.of(new Dummy());
        compare(List.of(new Data()));
        compare(data);
        compare(dummies);
    }

    static class Data implements Comparable<Data> {
        public int compareTo(Data o) {
            return 0;
        }
    }
    static class Dummy implements Comparable<Dummy> {
        public int compareTo(Dummy o) {
            return 0;
        }
    }

    static class BooleanData extends Data {

    }

    static <T extends Comparable<? super T>> void compare(List<T> list) {
        list.get(0).compareTo( list.get(1));
    }
}
