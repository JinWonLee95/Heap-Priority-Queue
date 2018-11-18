import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestHeapPriorityQueue {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data03.txt"), "UTF-8"));

		String temp;
		ArrayList<Node> array = new ArrayList<Node>();

		while ((temp = br.readLine()) != null) {
			String[] line = temp.split(", ");
			array.add(new Node(Integer.parseInt(line[0]), line[1]));
		}

		HeapPriorityQueue heapPriorityQueue = new HeapPriorityQueue();
		long start_time = System.nanoTime();
		heapPriorityQueue.build_max_heap(array);
		long end_time = System.nanoTime();
		long time = end_time - start_time;

		System.out.println("*** 현재 우선 순위 큐에 저장되어 있는 작업 대기 목록은 다음과 같습니다. ***");
		System.out.println("[index] key, value");

		System.out.println("-----------------------");
		System.out.println("Max_Heap 걸린시간 : "+time+" nano seconds");

		for (int i = 0; i < array.size(); i++)
			System.out.println("[" + i + "] " + array.get(i).getNumber() + ", " + array.get(i).getSubject());
		
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1.작업추가\t2.최대값\t3.최대 우선순위 작업 처리");
			System.out.println("4.원소 키 값 증가\t5.작업 제거\t6.종료");
			System.out.println("-----------------------------------------");
			System.out.print("명령 번호 입력 : ");
			int job = sc.nextInt();

			if (job == 6) {
				break;
			} else {
				String subject_temp;
				int key_temp;

				switch (job) {
				case 1:
					System.out.print("입력할 과목을 입력하세요 : ");
					subject_temp = sc.next();
					System.out.print("과목의 key 값을 입력하세요 : ");
					key_temp = sc.nextInt();
					heapPriorityQueue.insert(array, new Node(key_temp, subject_temp));
					for (int i = 0; i < array.size(); i++)
						System.out.println("[" + i + "] " + array.get(i).getNumber() + ", " + array.get(i).getSubject());
					break;
				case 2:
					heapPriorityQueue.max(array);
					break;
				case 3:
					heapPriorityQueue.extract_max(array);
					for (int i = 0; i < array.size(); i++)
						System.out.println("[" + i + "] " + array.get(i).getNumber() + ", " + array.get(i).getSubject());
					break;
				case 4:
					System.out.print("수정 할 과목을 입력하세요 : ");
					subject_temp = sc.next();
					System.out.print("과목의 수정할 key 값을 입력하세요 : ");
					key_temp = sc.nextInt();
					heapPriorityQueue.increase_key(array, subject_temp, key_temp);
					for (int i = 0; i < array.size(); i++)
						System.out.println("[" + i + "] " + array.get(i).getNumber() + ", " + array.get(i).getSubject());
					break;
				case 5:
					System.out.print("삭제할 index를 입력하세요 : ");
					key_temp = sc.nextInt();
					heapPriorityQueue.h_delete(array, key_temp);
					for (int i = 0; i < array.size(); i++)
						System.out.println("[" + i + "] " + array.get(i).getNumber() + ", " + array.get(i).getSubject());
					break;
				}
			}
		}

	}

}
