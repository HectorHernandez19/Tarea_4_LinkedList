package uaslp.enginering.labs.list;
/**
 * Lista doblemente ligada
 */
public class LinkedList<G> implements List<G> {
    //static -> pertenece a la clase y no al objeto
    //--> variables -> variables que pertenezcan a la clase Linkedlist.listsCount
    //--> Metodos --> linkedList.getListsCount();
    //--> Inner classes
    private static class Node<T>{
        // IMPORTANTE 1:
        // Noten que el tipo genérico G le pertenece a los OBJETOS LinkedList no a la clase, y ya que Node no le pertenece
        // a un objeto LinkedList, entonces no comparte el significado del tipo genérico G y es necesario
        // que se le defina un propio tipo genérico como si estuviera fuera del archivo
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data){
            this.data = data;
        }

        // IMPORTANTE 2:
        // Ya que Node es privado podemos eliminar los getters y los setters y utilizar sus atributos directamente
        // ya que no puede estar expuesto a malos usos desde fuera del LinkedList por tener visibilidad privada
    }
    private Node<G> tail;
    private Node<G> head;
    private int size;

    private static int listsCount = 0;

    public LinkedList() {
        listsCount ++;
    }
    public static int getListsCount(){
        return listsCount;
    }
    public class ForwardIterator implements Iterator<G> {
        private Node<G> currentNode;

        public ForwardIterator() {
            this.currentNode=head;
        }

        public ForwardIterator(ForwardIterator iterator){
            currentNode = iterator.currentNode;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data; // Noten que a pesar de que data es private, la outer class (LinkedList) tiene acceso
            // al campo
            currentNode = currentNode.next;
            return data;
        }
        Node<G> getCurrentNode() {  // modificador de acceso se llama -> package-private
            return currentNode;
        }
    }

    public class ReverseIterator implements Iterator<G> {

        private Node<G> currentNode;

        public ReverseIterator() {
            this.currentNode = tail;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;

            currentNode = currentNode.previous;

            return data;
        }
    }
    /**
     * Inserts data at the end of the list
     * @param data Data to be inserted
     */
    @Override
    public void add(G data) {
        Node<G> node = new Node<>(data);
        if (tail != null) {//si ya tiene datos
            tail.next=node;
            node.previous=tail;
        }
        if (head == null) {//si esta vacia
            head = node;
        }
        tail = node;
        size++;
    }
    /**
     * @param index 0-index
     * @return data in index
     */
    @Override
    public G get(int index) {
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size) {//Por si el elemento no esta en el rango de elementos
            System.out.println("El elemento no se encuentra en la lista actual");
            return null;
        }
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.data;
    }
    @Override
    public void delete(int index) {
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size) {
            System.out.println("El elemento no se encuentra en la lista actual");
            return;
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
            return;
        }

        if (index == 0) {
            head = head.next;
            head.previous=null;
            return;
        }

        if (index == size-1) {
            tail = tail.previous;
            tail.next = null;
            return;
        }

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
    }
    @Override
    public Iterator<G> getIterator() {
        return new ForwardIterator();
    }

    public void insert(G data,Position position, Iterator<G> it) {
        // ¿qué ofrece java para restringir los valores de position a solamente BEFORE y AFTER?

        Node<G> newNode = new Node<>(data);
        Node<G> currentNode = ((ForwardIterator)it).getCurrentNode().previous;

        if (position == Position.AFTER) {
            newNode.next = currentNode.next;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            if (newNode.next != null) {
                newNode.next.previous = newNode;
            } else {
                tail = newNode;
            }
        } else if (position == Position.BEFORE) {
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous = newNode;
            if (newNode.previous != null) {
                newNode.previous.next = newNode;
            } else {
                head = newNode;
            }
        }else {
            System.out.println("No conozco el valor de la position");
        }
        size++;
    }
    //Iterador -> patrón de diseño
    public int getSize() {
        return size;
    }

    public ReverseIterator getReverseIterator() {
        return new ReverseIterator();
    }
}