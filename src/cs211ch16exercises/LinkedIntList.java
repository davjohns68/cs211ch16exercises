package cs211ch16exercises;

// Class LinkedIntList can be used to store a list of integers.

import java.util.NoSuchElementException;

// BJP code from text, Chapter 16

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }
    
    /**
     * Returns boolean value representing whether the list is a perfect stutter:
     * each value is doubles in the list
     * @return boolean
     */
    public boolean isPerfectStutter() {
        ListNode current = this.front;
        boolean perfect = true;
        
        // 0 and 1 element list is automatically false since at least 2 are needed
        if (this.size() == 0 || this.size() == 1) {
            return false;
        }
        
        while (current != null) {
            if (current.data != current.next.data) {
                perfect = false;
            }
            current = current.next.next;
        }
        
        return perfect;
    }
    
    /**
     * If list is a perfect stutter, this method will remove the
     * stutter-ification:  removes the second, duplicate entry from the list.
     * isPerfectStutter() will return false after this method is called.
     */
    public void undoStutter() {
        ListNode current = this.front;
        int index = 0;
        
        if (this.isPerfectStutter()) {
            while (current != null) {
                if (index % 2 == 0) {
                    this.remove(index);
                }
                current = current.next;
                index++;
            }
        }
    }
    
    // ADD ADDITIONAL METHODS (Exercises solutions) HERE (4-18)
    // Exercise 2
    /**
     * 
     * @return 
     */
    public int min() {
        ListNode current = this.front;
        int min = current.data;         // Arbitrarily set to first item in the list
        
        if (this.size() == 0) {
            throw new NoSuchElementException("List is empty");
        }
        
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        
        return min;
    }
    
    // Exercise 4
    /**
     * Returns the last index of given value in the list
     * @param value The value you're looking for
     * @return Last index of value in the linked list
     */
    public int lastIndexOf(int value) {
        int returnIndex = -1;
        int currentIndex = 0;
        ListNode current = this.front;
        
        while (current != null) {
            if (current.data == value) {
                returnIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        
        return returnIndex;
    }
    
    // Exercise 5
    /**
     * Counts and returns the number of duplicate values in the list.
     * Assumes a sorted list.  Anything else will return invalid data
     * @return Integer representing the number of duplicate values in the list
     */
    public int countDuplicates() {
        int dups = 0;
        ListNode current = this.front;
        
        while (current.next != null) {
            if (current.data == current.next.data) {
                dups++;
            }
            current = current.next;
        }
        
        return dups;
    }
    
    // Exercise 6
    /**
     * Returns whether the list has two numbers that are consecutive
     * @return boolean  
     */
    public boolean hasTwoConsecutive() {
        boolean result = false;
        ListNode current = this.front;
        
        while (current.next != null) {
            if (current.data + 1 == current.next.data) {
                result = true;
            }
            current = current.next;
        }
        
        return result;
    }
    
    // Exercise 7
    /**
     * Removes and returns the last element in the list
     * @throws NoSuchElementException if passed an empty list
     * @return int Value of the last element which was removed
     */
    public int deleteBack() {
        int result = 0;
        int index = 0;
        ListNode current = this.front;
        
        if (this.size() == 0) {
            throw new NoSuchElementException("Empty list passed");
        }
        while (current.next != null) {
            index++;
            current = current.next;
        }
        result = this.get(index);
        this.remove(index);
        
        return result;
    }
    
    // Exercise 8
    /**
     * 
     */
    public void switchPairs() {
        ListNode current = this.front;
        ListNode prev = current;
        
        while (current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = current;
            if (current == this.front) {
                this.front = temp;
            } else {
                prev.next = temp;
                prev = current;
            }
            current = current.next;
        }
    }
    
    // Exercise 9
    /**
     * 
     */
    public void stutter() {
        ListNode current = this.front;
        
        while (current != null) {
            ListNode doubleNode = new ListNode(current.data, current.next);
            current.next = doubleNode;
            current = current.next.next;
        }
    }
    
    // Exercise 10
    /**
     * 
     * @param n 
     */
    public void stretch(int n) {
        // Empty the list if n is 0 or less
        if (n <= 0) {
            this.front = null;
        }
        ListNode current = this.front;
                
        while (current != null) {
            for (int i = 0; i < n; i++) {
                ListNode doubleNode = new ListNode(current.data, current.next);
                current.next = doubleNode;
                current = current.next.next;
            }
        }
    }
    
    // Exercise 11
    public void compress() {
        
    }
    
    // Exercise 12
    public void split() {
        
    }
    
    // Exercise 13
    public void transferFrom(LinkedIntList other) {
        
    }
    
    // Exercise 14
    /**
     * 
     * @param value 
     */
    public void removeAll(int value) {
        ListNode current = this.front;
        ListNode prev = current;
        
        while (current != null) {
            if (current.data == value) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }
    
    // Exercise 15
    public boolean equals(LinkedIntList other) {
        return false;
    }
    
    // Exercise 16
    public LinkedIntList removeEvens() {
        return new LinkedIntList();
    }
    
    // Exercise 17
    public void removeRange(int start, int end) {
        
    }
    
    // Exercise 18
    public void doubleList() {
        
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
