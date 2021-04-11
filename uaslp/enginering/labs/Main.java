package uaslp.enginering.labs;

import uaslp.enginering.labs.list.*;

public class Main {
    //Inner classes, Outer classes
    public static void main(String[] args) {
        int cuenta = LinkedList.getListsCount();
        //Wrapper classes -> Integer,Float,Character,Boolean
        //Las wrapper classes son "Inmutables"

        List<Integer> lista1 = new LinkedList<>();
        List<String> lista2 = new LinkedList<>();

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

        it = lista1.getIterator();
        while(it.hasNext()){
            int element = it.next(); //regresar el dato y avanzar el iterador
            if(element == 4){
                lista1.insert(10, Position.BEFORE,it);
            }
            if(element == 6){
                lista1.insert(15, Position.AFTER, it);
            }
        }
        System.out.println("---------------------");
        it= lista1.getIterator();
        while (it.hasNext()) {
            int element = it.next();
            System.out.println("Dato: " + element);
        }
    }
}