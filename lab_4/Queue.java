package lab_4;

public class Queue<T extends Comparable<T>> implements Comparable<Queue<T>>{
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
}
