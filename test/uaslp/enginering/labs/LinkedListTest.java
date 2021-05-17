package test.uaslp.enginering.labs;

import org.junit.jupiter.api.Test;
import src.uaslp.enginering.labs.list.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    //Give_When_Then

    @Test
    public void givenANewListIsCreated_ThenListIsEmpty(){
        //Given:

        //When:
        ArrayList<Integer> lista = new ArrayList<>(10);

        //Then:
        // Aserciones -> asserts
        assertEquals(0,lista.getSize());
    }
}
