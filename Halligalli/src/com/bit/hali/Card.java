package com.bit.hali;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class Card extends Frame implements ActionListener {
	Button btn1, btn2, btn3, btn4, btnbell;
	String[][] allCard = {
			{"��1", "��1", "��1", "��1", "��1", "��2", "��2", "��2", "��2", "��3", "��3", "��3", "��4", "��4", "��5"}, // [0][0], [0][1] ..
			{"��1", "��1", "��1", "��1", "��1", "��2", "��2", "��2", "��2", "��3", "��3", "��3", "��4", "��4", "��5"}, // [1][0], [1][1] ..
			{"��1", "��1", "��1", "��1", "��1", "��2", "��2", "��2", "��2", "��3", "��3", "��3", "��4", "��4", "��5"}, // [2][0], [2][1] ..
			{"��1", "��1", "��1", "��1", "��1", "��2", "��2", "��2", "��2", "��3", "��3", "��3", "��4", "��4", "��5"} // [3][0], [3][1] ..
	};
	
	String[] shuffleCard = new String[56];
	int shuffleCardlength = 0;
	Vector<String> player1 = new Vector<String>(14);
	Vector<String> player2 = new Vector<String>(14);
	Vector<String> player3 = new Vector<String>(14);
	Vector<String> player4 = new Vector<String>(14);
	Vector<String> bell = new Vector<String>(56);
	Vector<String> showCard = new Vector<String>(4);
	
	String[] fruit = new String[showCard.size()]; // ��
	String[] num = new String[showCard.size()]; // 1
	
	public void Btn() {
		// ��ư�� arraylist ���� �ٽ� ����
		btn1.setLabel(Integer.toString(player1.size()));
		btn2.setLabel(Integer.toString(player2.size()));
		btn3.setLabel(Integer.toString(player3.size()));
		btn4.setLabel(Integer.toString(player4.size()));
		btnbell.setLabel(Integer.toString(bell.size()));
	}
	
	boolean boo = true;
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
//		if(showCard.size() == 4) { // ���̴� ī�尡 4���� index0���� ����
//			showCard.remove(0);
//		}
		
		if(obj == btnbell) {
			// ó�� ���� ������ player�鿡�� ī�� ������
			if(bell.size() == 56) {
				for(int i=0; i<56; i+=4) { 
					player1.add(shuffleCard[i]);
					player2.add(shuffleCard[i+1]);
					player3.add(shuffleCard[i+2]);
					player4.add(shuffleCard[i+3]);
					bell.clear();
				}
				boo = false;
				// �� ī�� null�� �ʱ�ȭ
				for(int i=0; i<4; i++) {
					showCard.add(null);
				}
				Btn();
			}
			// �� �������� �˻�
			else {
				String showCardStr = ""; 
				char[] fruit = new char[4];
				char[] su = new char[4];
				int index1 = 0;
				int index2 = 0;
				for(int i=0; i<4; i++) {
					showCardStr += showCard.get(i); // "��1��3��4��3"
				}
				char[] arr_showCardStr = new char[showCardStr.length()]; 
				
				for(int i=0; i<arr_showCardStr.length; i++) {
					arr_showCardStr[i] = showCardStr.charAt(i); // �� 1 �� 3 ...
					if(arr_showCardStr.length % 2 == 0) {
						fruit[index1] = arr_showCardStr[i]; // �� �� �� ��
						index1++;
					}
					else {
						su[index2] = arr_showCardStr[i]; // 1 3 4 3
						index2++;
					}
				} // for end
				
//				if(fruit)

					
			
				
			}
//			
			
 				
// 				for(int i=0; i<3; i++) {
// 					for(int j=1+i; j<4; j++) {
// 						if(showCard.get(i).charAt(0) == showCard.get(j).charAt(0)) {
// 							System.out.println(showCard.get(i));
// 							System.out.println(showCard.get(j));
// 						} else {
// 							System.out.println("�ߺ�����");
// 						}
// 						
// 					}
// 				}
//					if (showCard.elementAt(0).charAt(0) == showCardCheck.next().charAt(0)) {
//						if(showCard.elementAt(0).charAt(1) + showCardCheck.next().charAt(1) == "5") {
//							// ���� ����Ȱ� ���� 
//						}
//
//					} else {
//						// ���徿 ������
//					}
//				while(showCardCheck.hasNext()) {
////					System.out.print(showCard.elementAt(1).charAt(0) + " "); 
//					System.out.println(showCardCheck.next().charAt(0));
//				}

		} // btnbell end

		else if(obj == btn1) {
			System.out.println("player1 : " + player1.get(0));
			bell.add(player1.get(0)); // �� ī�� bell�� ����
			showCard.remove(0); // ���� �� ī�� �����
			showCard.add(0, player1.get(0)); // �� �ڸ��� �ٽ� ��
			player1.remove(0);
			Btn();
			if(player1.size() == 0) {
				System.out.println("�й�");
			}
		}
		else if(obj == btn2) {
			System.out.println("player2 : " + player2.get(0));
			bell.add(player2.get(0));
			showCard.remove(1);
			showCard.add(1, player2.get(0));
			player2.remove(0);
			Btn();
			if(player2.size() == 0) {
				System.out.println("�й�");
			}
		}
		else if(obj == btn3) {
			System.out.println("player3 : " + player3.get(0));
			bell.add(player3.get(0));
			showCard.remove(2);
			showCard.add(2, player3.get(0));
			player3.remove(0);
			Btn();
			if(player3.size() == 0) {
				System.out.println("�й�");
			}
		}
		else if(obj == btn4) {
			System.out.println("player4 : " + player4.get(0));
			bell.add(player4.get(0));
			showCard.remove(3);
			showCard.add(3, player4.get(0));
			player4.remove(0);
			Btn();
			if(player4.size() == 0) {
				System.out.println("�й�");
			}
		}
		
//		for(int i=0; i<showCard.size(); i++) {
//			fruit[i] = showCard.elementAt(i).charAt(0);
//			num[i] = showCard.elementAt(i).charAt(1);
//		}
		
		System.out.println("��ī�� : " + showCard);
		System.out.println("player1ī�� " + player1);
		System.out.println("player2ī�� " + player2);
		System.out.println("player3ī�� " + player3);
		System.out.println("player4ī�� " + player4);
		System.out.println("���ݱ��� �� ��� ī�� bell�� ���� " + bell);
		System.out.println();
	} // actionperfomed end
		
	public Card() {
		setTitle("�Ҹ�����");

		
		
		Panel p = new Panel();
		
		// ���ھտ� ���������ٿ��� ���ڿ���ȯ, �迭����.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 14; j++) {
				shuffleCard[shuffleCardlength] = allCard[i][j];
				shuffleCardlength++;
			}
		} // outforend
		
		// ī�� ����
		int count = 2000;
		for (int k = 0; k < count; k++) {
			int i = (int) (Math.random() * shuffleCard.length);
			int j = (int) (Math.random() * shuffleCard.length);
			
			String tmp = shuffleCard[i];
			shuffleCard[i] = shuffleCard[j];
			shuffleCard[j] = tmp;
		}
		
		// bell �� ���� 56�� ī�� ����
		for(int i=0; i<56; i++) {
			bell.add(shuffleCard[i]);
		}
		
		System.out.println(bell);
		
		// ��ư�� arraylist ����
		btn1 = new Button(); 
		btn1.setLabel(Integer.toString(player1.size()));
		btn1.addActionListener(this);
		btn2 = new Button();
		btn2.setLabel(Integer.toString(player2.size()));
		btn2.addActionListener(this);
		btn3 = new Button();
		btn3.setLabel(Integer.toString(player3.size()));
		btn3.addActionListener(this);
		btn4 = new Button();
		btn4.setLabel(Integer.toString(player4.size()));
		btn4.addActionListener(this);
		btnbell = new Button();
		btnbell.setLabel(Integer.toString(bell.size()));
		btnbell.addActionListener(this);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btn4);
		p.add(btnbell);
		add(p);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		setVisible(true);
		setSize(400, 400);
		setLocation(400, 100);

	} // card end
	
	public static void main(String[] args) {
		new Card();
		
	} // main end
} // card class end