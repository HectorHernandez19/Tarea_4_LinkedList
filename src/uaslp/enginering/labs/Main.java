package src.uaslp.enginering.labs;

import src.uaslp.enginering.labs.list.ArrayList;
import src.uaslp.enginering.labs.list.Iterator;
import src.uaslp.enginering.labs.list.LinkedList;
import src.uaslp.enginering.labs.list.List;

public class Main {
    //Inner classes, Outer classes
    public static void main(String[] args) {
        int cuenta = LinkedList.getListsCount(); //No entiendo porque esta esto aqui
        //Wrapper classes -> Integer,Float,Character,Boolean
        //Las wrapper classes son "Inmutables"

        List<Integer> lista1 = new ArrayList<>(7);
        List<String> lista2 = new ArrayList<>(5);

        lista1.add(6);
        lista1.add(0);
        lista1.add(5);
        lista1.add(7);
        lista1.add(4);
        lista1.add(0);
        lista1.add(0);

        lista2.add("Prueba");
        lista2.add("de");
        lista2.add("kfkldalfl");
        lista2.add("Linked");
        lista2.add("List");

        lista1.delete(3);
        lista2.delete(2);

        System.out.println("---------------------");
        System.out.println("El tamaño es:" + lista1.getSize());

        Iterator<Integer> it = lista1.getIterator();
        while (it.hasNext()) {
            int element = it.next();
            System.out.println("Dato: " + element);
        }
        System.out.println("---------------------");

        it = lista1.getReverseIterator();

        while (it.hasNext()) {
            int element = it.next();
            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");
        System.out.println("El tamaño es:" + lista2.getSize());

        Iterator<String> itStrings = lista2.getIterator();

        while (itStrings.hasNext()) {
            System.out.println(itStrings.next());
        }
        System.out.println("---------------------");
        itStrings = lista2.getReverseIterator();
        while (itStrings.hasNext()) {
            System.out.println(itStrings.next());
        }
    }
}