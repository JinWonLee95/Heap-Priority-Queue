import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HeapPriorityQueue {

	public void max_heapify(ArrayList<Node> a, int i) {
		int L = 2 * i + 1;
		int R = 2 * i + 2;
		int Largest = i;
		Node temp;

		if (L < a.size() && a.get(L).getNumber() > a.get(i).getNumber()) {
			Largest = L;
		} else {
			Largest = i;
		}

		if (R < a.size() && a.get(R).getNumber() > a.get(Largest).getNumber()) {
			Largest = R;
		}

		if (Largest != i) {
			temp = a.get(Largest);
			a.set(Largest, a.get(i));
			a.set(i, temp);

			max_heapify(a, Largest);
		}
	}

	public void build_max_heap(ArrayList<Node> a) {
		for (int i = (a.size() / 2); i >= 0; i--) {
			max_heapify(a, i);
		}
	}

	public void insert(ArrayList<Node> a, Node x) {
		a.add(x);
		build_max_heap(a);
	}

	public void max(ArrayList<Node> a) {
		System.out.println("최대값 : [" + a.get(0).getNumber() + ", " + a.get(0).getSubject() + "]");
	}

	public void extract_max(ArrayList<Node> a) {
		a.remove(0);
		build_max_heap(a);
	}

	public void increase_key(ArrayList<Node> a, String subject, int key) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getSubject().equals(subject)) {
				a.set(i, new Node(key, subject));
			}
		}
		build_max_heap(a);
	}

	public void h_delete(ArrayList<Node> a, int x) {
		a.remove(x);
		build_max_heap(a);
	}
}
