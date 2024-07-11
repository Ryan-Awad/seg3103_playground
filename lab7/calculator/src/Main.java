//==============================================================================
//Calculator.java (S. Some)
//This program is largely based on  AwtCalc.java
//Author:  Ernest Criss Jr.
//==============================================================================

import javax.swing.JFrame;

public class Main {

	public static void main(String[] argv) {
    JFrame frame =
	  new CalCFrame("Calculator");
    frame.setSize(360,200);
    frame.setVisible(true); // BUG: Certain swing methods needs to be invoked in Swing thread --> Not sure how to fix this (might be out of the scope for this lab)
  }
}
