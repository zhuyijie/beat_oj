package net.visualgo.head;

/**
 * Created by yijiezhu on 15-11-21.
 */
public class MaxHead {

    private int[] data;

    public static void main(String[] args) {

    }

    public MaxHead(int[] data) {
        this.data = data;
        build();
    }

    private void build() {

    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }
}
