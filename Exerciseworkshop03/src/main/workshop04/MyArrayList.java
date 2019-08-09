package workshop04;

import java.util.ArrayList;

public class MyArrayList<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}
