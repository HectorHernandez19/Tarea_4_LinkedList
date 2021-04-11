package uaslp.enginering.labs.list;

public class ArrayList<H> implements List<H> {
    private Object array[];
    private int size;

    public ArrayList(){
        this.array = new Object[2];
    }
    @Override
    public void add(H data) {
        this.array[size++] = data;
    }

    @Override
    public H get(int index) {
        return (H)this.array[index];
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return null;
    }

    @Override
    public void insert(H data, Position position, Iterator<H> it) {

    }

    @Override
    public Iterator<H> getReverseIterator() {
        return null;
    }
}
