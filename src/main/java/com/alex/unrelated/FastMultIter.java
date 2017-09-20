package com.alex.unrelated;

public final class FastMultIter {
    public static void main(String... args) {
        System.out.println(fastMult(4, 5));
        System.out.println(fastMult(9, 8));
    }

    private static int fastMult(final int target, final int times) {
        int x = target;
        int t = times;
        int ac = 0;

        while (t != 0) {
            if (t % 2 == 0) {
                x = 2 * x;
                t = t / 2;
            } else {
                ac = ac + x;
                t = t - 1;
            }
        }

        return ac;
    }

}
