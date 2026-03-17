package lab_4;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue<T extends Comparable<T>> implements Comparable<Queue<T>>, Sort<T> {
    private QueueElement<T> head;

    // Getters & setters
    public QueueElement<T> getHead() {
        return this.head;
    }

    public void setHead(QueueElement<T> head) {
        this.head = head;
    }

    // Constructor
    public Queue(QueueElement<T> head) {
        this.head = head;
    }

    public Queue(T data) {
        QueueElement<T> element = new QueueElement<T>(data);
        this.head = element;
    }

    // Methods
    @Override
    public int compareTo(Queue<T> other) {
        QueueElement<T> this_element = this.head;
        QueueElement<T> other_element = other.head;

        while (this_element != null && other_element != null) {
            if (this_element.compareTo(other_element) > 0) {
                return 1;
            } else if (this_element.compareTo(other_element) < 0) {
                return -1;
            } else {
                this_element = this_element.getNextElement();
                other_element = other_element.getNextElement();
            }
        }

        if (this_element != null && other_element == null) {return 1;}
        if (this_element == null && other_element != null) {return -1;}
        return 0;
    }

    @Override
    public String toString() {
        QueueElement<T> this_element = this.head;
        StringBuilder result = new StringBuilder();

        while (this_element != null) {
            result.append(this_element.getData().toString());
            result.append(", ");
            this_element = this_element.getNextElement();
        }
        return result.toString();
    }

    public void enqueue(T element) {
        if (head == null) {
            head = new QueueElement<>(element);
            return;
        }

        QueueElement<T> new_element = new QueueElement<T>(element);
        QueueElement<T> this_element = this.head;

        while (this_element != null) {
            if (this_element.getNextElement() == null) {
                this_element.setNextElement(new_element);
                break;
            }
            this_element = this_element.getNextElement();
        }
    }

    public void dequeue() {
        this.head = this.head.getNextElement();
    }

    public QueueElement<T> takeFirst() {
        return this.head;
    }

    public boolean isEmpty() {
        if (this.head != null) {
            return false;
        }
        return true;
    }

    public int size() {
        QueueElement<T> this_element = this.head;
        int length = 0;

        while (this_element != null) {
            this_element = this_element.getNextElement();
            length++;
        }
        return length;
    }

    public ArrayList<T> getAsArray() {
        ArrayList<T> array = new ArrayList<>();

        QueueElement<T> this_element = this.head;

        while (this_element != null) {
            array.add(this_element.getData());
            this_element = this_element.getNextElement();
        }

        return array;
    }

    public QueueElement<T> getElementAtPos(int i) {
        int len = size();
        if (i >= len) {
            throw new Error("i in getElementAtPos method must be in array range");
        }

        QueueElement<T> this_element = this.head;
        int till_i = 0;
        while (this_element != null && till_i < i) {
            this_element = this_element.getNextElement();
            till_i++;
        }

        return this_element;
    }

    public QueueElement<T> setElementAtPos(int i, T value) {
        QueueElement<T> new_element = new QueueElement<T>(value);
        int len = size();
        if (i >= len) {
            throw new Error("i in getElementAtPos method must be in array range");
        }

        QueueElement<T> this_element = this.head;
        QueueElement<T> prev_element = null;
        int till_i = 0;
        while (this_element != null && till_i < i) {
            prev_element = this_element;
            this_element = this_element.getNextElement();
            till_i++;
        }


        new_element.setNextElement(this_element.getNextElement());
        if (prev_element != null) {
            prev_element.setNextElement(new_element);
        } else {
            head = new_element;
        }

        return new_element;        
    }

    public void swapElements(int i1, int i2) {
        int len = size();
        if (i1 >= len || i2 >= len) {
            throw new Error("i1 or i2 in swapElements method must be in array range");
        }

        QueueElement<T> temp = getElementAtPos(i1);
        setElementAtPos(i1, getElementAtPos(i2).getData());
        setElementAtPos(i2, temp.getData());
    }


    // Sort methods
    @Override
    public void sort() {
        ArrayList<T> array = getAsArray();
        int len = array.size();

        // building heap max-heap
        for (int i = len/2-1; i >= 0; i--) {
            heapify(array, len, i);
        }

        // swaping elements
        for (int i = len-1; i > 0; i--) {
            T temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            heapify(array, i, 0);
        }

        for (int i = 0; i < len; i++) {
            setElementAtPos(i, array.get(i));
        }
    }

    // ==== heapify array element with index i ====
    private void heapify(ArrayList<T> array, int len, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // find the largest element between nodes (node, leftChild, rightChild)
        if (left<len && array.get(left).compareTo(array.get(largest))>0) {
            largest = left;
        }
        if (right<len && array.get(right).compareTo(array.get(largest))>0) {
            largest = right;
        }

        // root must be the largest
        if (largest != i) {
            T temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);

            heapify(array, len, largest);
        }

    }
}
