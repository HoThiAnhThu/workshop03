package workShop03;

public class Sample {
    public <T> void printArray(T[] inputArray) {
        // Display array elements
        for ( T element : inputArray ){
            System.out.print(element);
        }
        System.out.println();
    }

    public static void main(String[] argv) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        // Create object
        Sample gmt = new Sample();
        System.out.println( "Array integerArray contains:" );
        gmt.printArray( intArray ); // pass an Integer array
        System.out.println( "\nArray doubleArray contains:" );
        gmt.printArray( doubleArray ); // pass a Double array
        System.out.println( "\nArray characterArray contains:" );
        gmt.printArray( charArray ); // pass a Character array

        Box<Integer> intBox = new Box<Integer>();
        Box<String> strBox = new Box<String>();
        intBox.add(new Integer(10));
        strBox.add(new String("Hello World"));
        System.out.println("Integer Value: " + intBox.get());
        System.out.println("String Value: " + strBox.get());
    }
}

class Box<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}