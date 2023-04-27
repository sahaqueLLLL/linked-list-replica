public class CustomList<E> {
    public static class Node<E> {
        final private E value;

        Node<E> nextLink;
        int index;

        Node(E value, CustomList<E> owner)  {
            this.value = value;
            index = owner.size;
        }
        public E getValue() {
            return this.value;
        }
    }

    private Node<E> last;

    CustomList() {
        last = null;
    }
    private int size = 0;

    public void add(E value, CustomList<E> list)  {
        Node<E> newNode = new Node<>(value, list);
        newNode.nextLink = last;
        last = newNode;
        size++;
    }
    public void delete(int index) {
        Node<E> current = last;
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else if (index == size - 1) {
            last = last.nextLink;
            size--;
        } else if (index == 0) {
            for (int i = size - 1; i > 0; i--) {
                current = current.nextLink;
            }
            current.nextLink = null;
            size--;
            current = last;
            last.index -= 1;
            for (int i = size; i > 1; i--) {
                current.nextLink.index -= 1;
                current = current.nextLink;
            }
        } else {
            for (int i = size - 1; i > index + 1; i--) {
                current =  current.nextLink;
            }
            current.nextLink = current.nextLink.nextLink;
            size--;
            current = last;
            last.index -= 1;
            for (int i = size; i > index + 1; i--) {
                current.nextLink.index -= 1;
                current = current.nextLink;
            }
        }


    }
    public Node<E> get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> current = last;
        while (current.index != index) {
            current = current.nextLink;
        }
        return current;
    }
    public int size() {
        return this.size;
    }




}
