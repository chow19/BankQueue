import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class BankQueue {
	Queue<Integer> queueA;
	Queue<Integer> queueB;
	public BankQueue(int[] list1) {
		queueA = new LinkedList<>();
		queueB = new LinkedList<>();
		for (int i : list1) {
			if(i%2!=0){
				queueA.add(i);
				//若超出队列长度
				//add,直接抛出异常;
				//put,发生阻塞一直等待空间;
				//offer,直接返回false
			}else {
				queueB.add(i);
			}
		}
	}
	
	public void Work() {
		int flag=0;
		while (!(queueA.isEmpty()&&queueB.isEmpty())) {
			if(!queueA.isEmpty()){
				System.out.print(queueA.remove()+" ");
				//若队列为空
				//poll,返回null;
				//remove,抛出NoSuchElementException异常;
				//take,发生阻塞等待有元素;
				flag++;
			}else {
				flag=2;
			}
			if (flag==2&&(!queueB.isEmpty())) {
				flag=0;
				System.out.print(queueB.remove()+" ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int list1size = sc1.nextInt();
		int[] list1 = new int[list1size];
		for (int i = 0; i < list1.length; i++) {
			list1[i] = sc1.nextInt();
		}
		
		BankQueue bankQueue = new BankQueue(list1);
		System.out.println();
		bankQueue.Work();
		
		sc1.close();
	}
	
}
