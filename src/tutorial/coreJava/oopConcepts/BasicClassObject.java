package tutorial.coreJava.oopConcepts;

public class BasicClassObject {

    /*
    just an example to show runtime exception (exception = stackoverflow)
    when you try to create the object of the same class and define as variable it will
    go into indefinite looping..
    BasicClassObject d1 = new BasicClassObject();*/

    public static void main(String[] args) {
        // new keyword is used to create object but how much object space/memory to create
        // again it depends on the constructor which will help to allocate the memory
        // (makes sense - what to do with just new keyword w/o constructor)
        ClassBlueprint obj = new ClassBlueprint();
        obj.set(5);
        System.out.println(obj.get());

        System.out.println(obj.add(2, 5));


        //below is the example to show if a new object is assigned in anyway to old references then previous
        //object (or reference) is lost
        ClassBlueprint obj2 = new ClassBlueprint();
        obj = new ClassBlueprint();  // or assign other reference like in below line
        obj = obj2;
        System.out.println(obj.get());

    }
}

/**
 * Traditional definition: Class is a blueprint by which object are created
 * It represents a set of properties or methods which revolve around some real world entity..
 * example - class Table, and properties would be length, height etc..
 *
 * Now, "object" is something that is instance of a class
 * for ex, object of a class Table would describes/contains the actual tables properties (like length = 10 meters, height = 5 meters etc.,)
 */
class ClassBlueprint {

    //variable declaration
    private int i;

    //this is default constructor, trying to show but not required to explicitly mention unless there is some
    //process that we do in the constructor
    //and it will not return anything....
    //but using default or parameterized constructors, you can initialize something when this class in instantiated
    ClassBlueprint() {
        super(); //again this is implicit, we don't have to call super()
    }

    ClassBlueprint(int constructorValue) {
        i = constructorValue;
    }

    int get() {
        return i;
    }

    void set(int param) {
        i = param;
    }

    int add(int a, int b) {
        return a + b;
    }

}