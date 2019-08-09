package workShop03;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList<T> {
    private ArrayList<T> arrayList;
    private T t;

    public StudentArrayList() {
        arrayList = new ArrayList<>();
    }

    public void add(T t) {
        this.arrayList.add(t);
    }

    public List<T> get() {
        return this.arrayList;
    }
}
