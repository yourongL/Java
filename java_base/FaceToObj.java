package java_base;

import java.util.ArrayList;
// import java.util.BitSet;
// import java.util.Dictionary;
// import java.util.Hashtable;
import java.util.List;

class Animal {
    public int countLegs() {
        return 0;
    }
}

class Dog extends Animal {

}

public class FaceToObj {

    List<?> mm;

    static int countLegs(List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    // static <T> int countLegs1 (List<T extends Animal> animals
    // ){//可见声明一个泛型类的对象时候只能使用通配符
    // int retVal = 0;
    // for ( Animal animal : animals )
    // {
    // retVal += animal.countLegs();
    // }
    // return retVal;
    // }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs(dogs);
        // 报错
        // countLegs1(dogs);
    }
    // public static void main(String[] args){
    // BitSet bits = new BitSet(10);
    // for(int i=0;i<10;i++){
    // bits.set(i,false);
    // }
    // System.out.println(bits);

    // }
}