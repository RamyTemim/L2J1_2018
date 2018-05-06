package L2J1.L2J1;

import controllers.*;
import junit.framework.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	SudokuController mycontroller = new SudokuController();
	/**
     * check if every number is between 0 and 9
     */
	public void testNumbers() {
		
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {

				assertTrue(mycontroller.EasyGameSudoku()[i][j] < 10);
				assertTrue(mycontroller.MediumGameSudoku()[i][j] < 10);
				assertTrue(mycontroller.HardGameSudoku()[i][j] < 10);

			}
	}
	/**
     * check if the grids are differents than each others. 
     */
	public void testInequality(){
		assertFalse(mycontroller.EasyGameSudoku() == mycontroller.HardGameSudoku());
		assertFalse(mycontroller.MediumGameSudoku() == mycontroller.HardGameSudoku());
		assertFalse(mycontroller.EasyGameSudoku() == mycontroller.MediumGameSudoku());
	}
}
