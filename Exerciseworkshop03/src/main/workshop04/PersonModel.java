package workshop04;

import java.util.ArrayList;

public class PersonModel<T> {

    private ArrayList<T> al = new ArrayList<>();

    public void add(T obj) {
        al.add(obj);
    }

    public void display() {
        for (T o : al) {
            System.out.println(o);
        }
    }
}
