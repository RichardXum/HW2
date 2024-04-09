package stores;

/**
* A generic implementation of the IList iterface, that uses LinkElements.
*/

import interfaces.IList;

public class MyLinkedList<E> implements IList<E> {
    
    MyLinkedListElement<E> head;
    
    public MyLinkedList() {
        this.head = null;
    }
    
    // INCOMPLETE.
    public boolean isEmpty() {
        // Returns whether the list is empty.
        return head == null ? true : false;
    }
    
    // INCOMPLETE.
    public boolean add(E element) {
        // Adds an element to the head of the list.
        MyLinkedListElement<E> temp = new MyLinkedListElement<>(element);
        
        // if the list is not empty, point the new link to head
        if (head != null) {
            temp.setNext(head);
        }
        // update the head
        head = temp;
        
        return true;
    }
    
    // INCOMPLETE.
    public int size() {
        // Returns the number of elements in stored in this list.
        if (head == null) {
            return 0;
        }
        MyLinkedListElement<E> ptr = head;
        int index = 0;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
            index++;
        } 
        return index+1;
    }
    
    // INCOMPLETE.
    public String toString() {
        // Returns a string representation of this list.
        if (isEmpty() == true) {
            return "[]";
            }
        StringBuilder sb = new StringBuilder('[');
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
        }
        sb.append(']');
        return sb.toString();
    }
    
    // INCOMPLETE.
    public boolean addToTail(E element) {
        // Adds element to tail of the list
        MyLinkedListElement<E> ptr = head;
        MyLinkedListElement<E> e = new MyLinkedListElement<E>(element);
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
        }
        ptr.setNext(e);
        return true;
    }
    
    // INCOMPLETE.
    public E removeFromHead() {
        // Removes and returns the head element
        if (head == null) {
            return null;
        }
        MyLinkedListElement<E> ptr = head;
        ptr = ptr.getNext();
        E res = ptr.getNext().getValue();
        ptr.setNext(ptr.getNext().getNext());
        return res;
    }
    
    
    
    public E get(int index) {
        if (isEmpty() || index >= size()) {
            return null;
        }
        // Gets the element at index in the list
        MyLinkedListElement<E> ptr = head;
        for (int i = 0; i < index; i++) {
            ptr = ptr.getNext();
        }
        return ptr.getValue();
    }

    public int indexOf(E element) {
        // Gets the index of element in the list
        MyLinkedListElement<E> ptr = head;
        int i=0;
        while (ptr != null) {
            if (element.equals(ptr.getValue())) {
                return i;
            }
            i++;
            ptr = ptr.getNext();
        }
        return -1;
    }

    public E set(int index, E element) {
        if (isEmpty()) {
            return null;
        }

        // Sets element at index in the list
        MyLinkedListElement<E> ptr = head;
        MyLinkedListElement<E> prev = null;

        for (int i = 0; i < index; i++) {
            prev = ptr;
            ptr = ptr.getNext();
        }

        E ret = ptr.getValue();

        MyLinkedListElement<E> newLink = new MyLinkedListElement<>(element);
        newLink.setNext(ptr.getNext());
        if (prev != null) {
            prev.setNext(newLink);
        } else {
            head = newLink;
        }

        return ret;
    }
    
    public void clear() {
        // Clears the list
        head = null;
    }
    
    public boolean contains(E element) {
        // Returns whether the element exists in the list
        return indexOf(element) != -1;
    }

    public boolean remove(E element) {
        MyLinkedListElement<E> ptr = head;
        MyLinkedListElement<E> prev = null;

        while (ptr != null) {
            if (ptr.getValue().equals(element)) {
                if (prev == null) {
                    head = ptr.getNext();
                } else {
                    prev.setNext(ptr.getNext());
                }

                return true;
            }

            prev = ptr;
            ptr = ptr.getNext();
        }

        return false;
    }
}
