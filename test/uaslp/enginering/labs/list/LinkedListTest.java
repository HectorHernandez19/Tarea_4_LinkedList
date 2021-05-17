package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void givenANewList_WhenIsCreated_ThenListIsEmpty(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecución
        int size = list.getSize();

        //Validación
        assertEquals(0, size, "Deberia Estar vacia la lista");
    }

    @Test
    public void givenANewList_whenAddElement_thenSizeIsOne(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();

        //Ejecución
        list.add(500);

        //Validación
        assertEquals(1, list.getSize(), "Deberia tener solo un elemento");
        assertEquals(500, list.get(0));
    }

    @Test
    public void givenAnExistingListWith1Element_whenAddElement_thenSizeIsTwo(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);

        //Ejecución
        list.add(100);

        //Validación
        assertEquals(2, list.getSize(), "Deberia tener dos elementos");
        assertEquals(500, list.get(0));
        assertEquals(100, list.get(1));
    }

    @Test
    public void givenAListWith5Elements_whenIterator_thenElementsAreAccesible() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        //Ejecución
        Iterator<Integer> iterator = list.getIterator();

        //Validación
        assertTrue(iterator.hasNext());
        assertEquals(5, list.getSize(), "Deberia tener 5 elementos");
        assertEquals(500, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(600, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(700, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(800, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1000, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAListWith5Elements_whenReverseIterator_thenElementsAreAccesible() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        //Ejecución
        Iterator<Integer> iterator = list.getReverseIterator();

        //Validación
        assertTrue(iterator.hasNext());
        assertEquals(5, list.getSize(), "Deberia tener 5 elementos");
        assertEquals(1000, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(800, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(700, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(600, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(500, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAnExistingListWith4Element_whenDeleteHeadElement_thenSizeDecrements() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución
        list.delete(0);

        //Validación
        assertEquals(3, list.getSize(), "Debe tener 3 elementos");
        assertEquals(600, list.get(0));
        assertEquals(700, list.get(1));
        assertEquals(800, list.get(2));
    }

    @Test
    public void givenAnExistingListWith1El_whenDeleteHeadElement_thenSizeDecrements() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);

        //Ejecución
        list.delete(0);

        //Validación
        assertEquals(0, list.getSize(), "Debe tener 0 elementos");
    }

    @Test
    public void givenAnExistingListWith4Element_whenDeleteTailElement_thenSizeDecrements() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución
        list.delete(3);

        //Validación
        assertEquals(3, list.getSize(), "Debe tener 3 elementos");
        assertEquals(500, list.get(0));
        assertEquals(600, list.get(1));
        assertEquals(700, list.get(2));
    }

    @Test
    public void givenAnExistingListWith4Element_whenDeleteElementInTheMiddle_thenSizeDecrements() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución
        list.delete(2);

        //Validación
        assertEquals(3, list.getSize(), "Debe tener 3 elementos");
        assertEquals(500, list.get(0));
        assertEquals(600, list.get(1));
        assertEquals(800, list.get(2));
    }

    @Test
    public void givenAnExistingListWith4Element_whenGet1Index_thenShowElement2() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución
        int element = list.get(1);

        //Validación
        assertEquals(600, element);
    }

    @Test
    public void givenAnExistingListWith4Element_whenInsertBeforeHeadElement_thenOrderOfElementsChange() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución
        list.insert(100,Position.BEFORE, list.getIterator());

        //Validación
        assertEquals(5, list.getSize(), "Debe tener 3 elementos");
        assertEquals(100, list.get(0));
        assertEquals(500, list.get(1));
        assertEquals(600, list.get(2));
        assertEquals(700, list.get(3));
        assertEquals(800, list.get(4));
    }

    @Test
    public void givenAnExistingListWith4Element_whenInsertAfterMiddleElement_thenOrderOfElementsChange() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        Iterator it = list.getIterator();
        int i = (int) it.next();

        //Ejecución
        list.insert(650,Position.AFTER,it);

        //Validación
        assertEquals(5, list.getSize(), "Debe tener 3 elementos");
        assertEquals(500, list.get(0));
        assertEquals(600, list.get(1));
        assertEquals(650, list.get(2));
        assertEquals(700, list.get(3));
        assertEquals(800, list.get(4));
    }

    @Test
    public void givenAnExistingListWith4Element_whenDeleteElementAtIndex5_thenIndexOutOfBoundExceptionIsThrown(){
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución/Validación
        Assertions.assertThrows(MyIndexOutOfBoundsException.class, ()-> list.delete(5)); //Esto es Lambdas
        //Lambdas
        //Clases anónimas
        //Swing
        //Interfaces -> Solo un método -> Interfaces funcionales
    }

    @Test
    public void givenAnExistingListWith4Element_whenGet4Index_thenIndexNullPointerExceptionIsThrown() {
        //Inicialización
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        //Ejecución/Validación
        Assertions.assertThrows(MyNullPointerException.class, () -> list.get(4)); //Esto es Lambdas
    }

}
