package uaslp.enginering.labs.list;

public class ArrayList<H> implements List<H> {
    private Object array[];
    private int size;

    public ArrayList(){
        this.array = new Object[4];
    }

    @Override
    public void add(H data) {
        if (size == array.length){
            Object []oldArray = array;
            array = new Object[array.length*2];
            System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        this.array[size++] = data;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) {
        for (int i=index;(i+1)<size;i++){
            array[i]=array[i+1];
        }
        size--;
    }
    public class ForwardIterator implements Iterator<H> {
        private int indice;
        public boolean hasNext(){
            return indice < size;
        }
        public H next(){
            indice++;
            return (H)array[indice-1];
        }
    }
    public class ReverseIterator implements Iterator<H> {
        private int indice=size-1;
        public boolean hasNext(){
            return indice >= 0;
        }
        public H next(){
            indice--;
            return (H)array[indice+1];
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    @Override

    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }
    public void insert(H data, Position position, Iterator<H> it) {

    }
}
