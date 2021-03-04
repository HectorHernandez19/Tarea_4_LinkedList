package uaslp.enginering.labs.list;

public class ReverseIterator {
    private Node currentNode;

    public ReverseIterator(Node currentNode){
        this.currentNode = currentNode;
    }

    public boolean hasNext(){
        return currentNode != null;
    }

    public int next(){
        int data = currentNode.getData();

        currentNode = currentNode.getPrevious();

        return data;
    }
    Node getCurrentNode() {  // modificador de acceso se llama -> package-private
        return currentNode;
    }
}
