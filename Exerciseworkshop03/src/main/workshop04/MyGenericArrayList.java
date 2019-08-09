package workshop04;

import java.util.ArrayList;

public class MyGenericArrayList<T> {
    private ArrayList<T> arrayList;

    public MyGenericArrayList() {
        this.arrayList = new ArrayList<>();
    }
    public void add(T t) {
        arrayList.add(t);
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }
}
