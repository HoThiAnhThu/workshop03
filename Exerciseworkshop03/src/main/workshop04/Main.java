package workshop04;

public class Main {

    public static void main(String []argv) {

        // Bai01
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<Integer>();
        MyArrayList<Float> floatMyArrayList = new MyArrayList<Float>();
        MyArrayList<Boolean> booleanMyArrayList = new MyArrayList<Boolean>();
        MyArrayList<String> stringMyArrayList = new MyArrayList<String>();
        integerMyArrayList.add(1);
        floatMyArrayList.add(2.7f);
        booleanMyArrayList.add(true);
        stringMyArrayList.add("hello world");

        System.out.println("Integer Value: " + integerMyArrayList.get());
        System.out.println("float Value: " + floatMyArrayList.get());
        System.out.println("boolean Value: " + booleanMyArrayList.get());
        System.out.println("String Value: " + stringMyArrayList.get());

        //Bai02
        MyGenericArrayList<Integer> myGenericArrayList = new MyGenericArrayList();
        int[] ints = {1, 2, 3};
        for (int i: ints) {
            myGenericArrayList.add(i);
        }
        myGenericArrayList.getArrayList().forEach(System.out::println);

        //Bai 05
        PersonModel<Student> person = new PersonModel<>();
        person.add(new Student(1, "tduy", 12));
        person.add(new Student(2, "hthu", 11));
        person.display();

        PersonModel<Employee> employee = new PersonModel<>();
        employee.add(new Employee(1, "tduy", 1000000));
        employee.add(new Employee(2, "hthu", 1000000));
        employee.display();

        PersonModel<String> personModel = new PersonModel<>();
        personModel.add("1, tduy, 1200");
        personModel.add("2, hthu, 1000");
        personModel.display();
    }
}
