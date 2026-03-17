package lab_4;

public class QueueElement<T extends Comparable<T>> implements Comparable<QueueElement<T>> {
    private T data;
    private QueueElement<T> next_element;

    // Getters & setters
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueElement<T> getNextElement() {
        return this.next_element;
    }

    public void setNextElement(QueueElement<T> nexElement) {
        this.next_element = nexElement;
    }

    // Constructors
    public QueueElement(T data) {
        this.data = data;
        this.next_element = null; 
    }

    public QueueElement(T data, QueueElement<T> element) {
        this.data = data;
        this.next_element = element; 
    }

    // Methods
    @Override
    public int compareTo(QueueElement<T> other) {
        return this.data.compareTo(other.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
