package com.alex.unrelated;

import java.util.List;

public final class Overloaded {
    public static boolean allZero(List<Integer> ints) {
        for (int i : ints) if (i != 0) return false;
        return true;
    }

//    public static boolean allZero(List<String> strings) {
//        for (String s : strings) if (s.length() != 0)
//                for (String s : strings) if (s.length() != 0) return false;
//        return true;
//    }


}
