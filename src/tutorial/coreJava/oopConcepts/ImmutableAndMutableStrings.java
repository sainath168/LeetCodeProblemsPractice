package tutorial.coreJava.oopConcepts;

public class ImmutableAndMutableStrings {
    public static void main(String[] args) {

        // Strings are stored in special region in HEAP memory called string pool
        // here, in below 3 lines of code
        // string object is created and placed in string pool and returned reference of "ava" to a
        // and then same reference is assigned to b, no new memory allocated for b
        // and then another string object is created and placed in string pool and assigned reference of that to a and b
        // but it will not replace "ava", there is still "ava" in string pool which is later cleared by GC
        String a = "ava";
        String b = a;
        a = b = "s";

        //a and b are same, they contain the same reference of value "s"
        System.out.println(a);
        System.out.println(b);

        // StringBuffer is thread safe (Note: we have StringBuilder also which is non thread-safe, and ofcourse it is faster)
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("def");
        sb1.append(sb2);
        System.out.println(sb1);
        System.out.println(sb2);

        // in above code the first String object that is created with value "ava" is called as immutable
        // and thus later changes didn't impact the value/object
        // and then StringBuffer object that is created with value "abc" is mutable
        // when append() method is triggered the value in the object itself is changed and
        // no more it is immutable

    }
}
