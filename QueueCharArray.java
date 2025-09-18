/*
 * QueueCharArray.java
 * fall 2025
 * prof. lehman
 * 
 * Queue approach has first and last point
 * to first and last elements in array.
 * The variable size is used to denote
 * an empty vs. full queue
 *
 * Student: Lukas Finch
 */

public class QueueCharArray {

	// data
	char data[];
	int front;
	int back;
	int size;
	int MAX;

	// default constructor
	public QueueCharArray() {
		MAX = 5;
		data = new char[MAX];
		front = 0;
		back = -1;
		size = 0;
	}

	// alternate constructor
	public QueueCharArray(int max) {
		MAX = max;
		data = new char[MAX];
		front = 0;
		back = -1;
		size = 0;
	}

	// delete all items in queue
	public void clear() {
		front = 0;
		back = -1;
		size = 0;
	}

	// add to back of queue
	public void add(char v) {
		if (!full()) {
			back = (back + 1) % MAX;
			data[back] = v;
			size++;
		}
		// do nothing if full
	}

	// see if queue is empty
	public boolean empty() {
		return size == 0;
	}

	// see if queue is full
	public boolean full() {
		return size == MAX;
	}

	// return element from front of queue
	public char front() {
		if (empty()) {
			return '?'; // requirement
		}
		return data[front];
	}

	// remove element from front of queue
	public boolean remove() {
		if (empty()) {
			return false;
		}
		front = (front + 1) % MAX;
		size--;
		return true;
	}

	// return size of queue
	public int size() {
		return size;
	}

	/**
	 * use with println to display queue
	 * 
	 * @return set as a String
	 */
	public String toString() {
		if (empty()) {
			return "QUEUE: empty";
		}
		String s = "QUEUE: ";
		for (int i = 0; i < size; i++) {
			int idx = (front + i) % MAX;
			s = s + data[idx] + " ";
		}
		return s;
	}
}// class