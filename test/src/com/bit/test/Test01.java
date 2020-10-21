package com.bit.test;

import java.util.ArrayList;
import java.util.Scanner;

// �л������������α׷�(ver 1.0.0)
// Student Ŭ������ �ۼ��Ͽ� �й�, �̸�, ����, ����, ������ �����ÿ�
// �ڷᱸ���� Ȱ���Ͽ� �������� �۵��ǵ��� �Ͻÿ�
// �ܼ� ������ϵ��� �ۼ��Ͻÿ�
// ex) 1.��ü 2.�� 3.�Է� 4.���� 5.���� 0.����>2
//	�й�>1
//	�й�:1 �̸�:ȫ�浿
//	����:90		����:80		����:70
//	����:000
//	���:00.00

class Student {
	int num, kor, eng, math;
	String name;
	
	Student() { }
	
	int tot() { return kor + eng + math; }
	
	double avg() { return tot() * 100 / 3 /100.0; }
	
	void stuInfo() {
		System.out.println("�й�:" + this.num + " �̸�:" + this.name);
		System.out.println("����:" + this.kor + "\t����:" + this.eng + "\t����:" + this.math);
		System.out.println("����:" + this.tot());
		System.out.println("���:" + this.avg() + "\n");
	}
	
	void stuWrite() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸�>");
		this.name = sc.nextLine();
		System.out.print("����>");
		this.kor = Integer.parseInt(sc.nextLine());
		System.out.print("����>");
		this.eng = Integer.parseInt(sc.nextLine());
		System.out.print("����>");
		this.math = Integer.parseInt(sc.nextLine());
	}
}

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�л������������α׷� (ver 1.0.0)\n");
		String menu = "1.��ü 2.�� 3.�Է� 4.���� 5.���� 0.����>";
		ArrayList<Student> list = new ArrayList<Student>(); // �л� ������ ���� �迭 list

		while(true) {
			System.out.print(menu);
			int menuNum = Integer.parseInt(sc.nextLine());
			
			if(menuNum == 0) {
				// ����
				System.out.println("���α׷��� �����մϴ�. ");
				break;
				
			} else if(menuNum == 1) { 
				// ��ü
				if(list.size() == 0) { // �Էµ� �л� ������ ���� ��
					System.out.println("�Էµ� �л� ������ �����ϴ�. ������ ���� �Է��� �ּ���. \n");
					continue;
				}
				System.out.println(list.size() + "���� �л� ���� ������ ����մϴ�. \n");
				
				for(int i=0; i<list.size(); i++) {
					Student stu = list.get(i);
					stu.stuInfo();
				}
				
			} else if(menuNum == 2) {
				// ��
				if(list.size() == 0) { // �Էµ� �л� ������ ���� ��
					System.out.println("�Էµ� �л� ������ �����ϴ�. ������ ���� �Է��� �ּ���. \n");
					continue;
				}
				System.out.print("�й�>");
				int showNum = Integer.parseInt(sc.nextLine());

				for(int i=0; i<list.size(); i++) {
					Student stu = list.get(i);
					if(showNum == stu.num) {
						stu.stuInfo();
					}
				} // for end
				
			} else if(menuNum == 3) {
				// �Է�
				try {
					Student stu = new Student();
					System.out.print("�й�>");
					stu.num = Integer.parseInt(sc.nextLine());
					stu.stuWrite();
					System.out.println(stu.name + " �л��� ������ �ԷµǾ����ϴ�. ");
					System.out.println();
					
					list.add(stu); // �Է��� �л� ������ �迭 list�� ��´�
					
				} catch(Exception e) {
					System.out.println("�ٽ� �Է��ϼ���. ");
				} // try-catch end
				
			} else if(menuNum == 4) {
				// ����
				System.out.print("������ �л��� �й�>");
				int reNum = Integer.parseInt(sc.nextLine());

				for(int i=0; i<list.size(); i++) {
					Student stu = list.get(i); // list�� ����� ù��° �л��� �������� �������鼭
					if(reNum == stu.num) { // ������ �л��� �й��� ���� ���� ã�´�
						stu.stuWrite();
						System.out.println(stu.name + " �л��� ������ �����Ǿ����ϴ�. ");
						System.out.println();
						break;
					}
				} // for end

			} else if(menuNum == 5) {
				// ����
				System.out.print("������ �л��� �й�>");
				int delNum = Integer.parseInt(sc.nextLine());
				
				for(int i=0; i<list.size(); i++) {
					Student stu = list.get(i); // list�� ����� ù��° �л��� �������� �������鼭
					if(delNum == stu.num) { // ������ �л��� �й��� ���� ���� ã�´�
						list.remove(i);
						System.out.println(stu.name + " �л��� ���� ������ �����Ǿ����ϴ�." + "\n");
						break;
					}
				}
			} // else if end
		} // while end
		
	} // main end
} // Test01 end