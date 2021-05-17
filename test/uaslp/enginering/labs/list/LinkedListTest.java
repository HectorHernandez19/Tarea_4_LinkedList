package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Test;
import uaslp.enginering.labs.list.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void givenANewListIsCreated_ThenListIsEmpty(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecución
        int size = list.getSize();

        //Validación
        assertEquals(0, size, "Deberia Estar vacia la lista");
    }

    @Test
    public void givenANewArray_whenAddElement_thenSizeIsOne(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecución
        list.add(500);

        //Validación
        assertEquals(1, list.getSize(), "Deberia tener solo un elemento");
        assertEquals(500, list.get(0), "Esta asignando mal el valor, deberia ser 500");
    }

    @Test
    public void givenAnExistingArrayWith1Element_whenAddElement_thenSizeIsTwo(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);

        //Ejecución
        list.add(100);

        //Validación
        assertEquals(2, list.getSize(), "Deberia tener dos elementos");
        assertEquals(500, list.get(0), "Asigno mal el valor, debe ser 500");
        assertEquals(100, list.get(1), "Asigno mal el valor, debe ser 100");
    }
}
