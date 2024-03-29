package com.bit.day24;

import java.io.IOException;
import java.io.OutputStream;

public class Ex05 {
	
	public static void main(String[] args) {
		OutputStream oout = System.out;
		try {
			oout.write(97);
			oout.write(98);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oout != null) {oout.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // finally end
		
	} // main end
} // Ex05 end
