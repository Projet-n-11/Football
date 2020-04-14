package test.unit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import datafield.Corner;
import datafield.Engagement;
import datafield.Goal;
import datafield.Penalty;
import datafield.SixYard;
import datafield.SpecialPosition;
/**
 * this class allows to to test all the special positions of the ground
 * @author Quitterie,Laura,Aladdine
 *
 */

public class SpecialPosTest {
	
	private SpecialPosition spePos; 
	
	/**
	 * creation of all special positions
	 */
	@Before
	public void prepareSpecialPos() {
		spePos=new SpecialPosition();
	}
	
	/**
	 * comparison of corner position
	 */
	@Test
	public void testCorners() {
		Corner corner1=spePos.getCorner1();
		assertNotNull(corner1);
		assertEquals(6,corner1.getPositionX());
		assertEquals(6,corner1.getPositionY());
		
		Corner corner2=spePos.getCorner2();
		assertNotNull(corner2);
		assertEquals(6,corner2.getPositionX());
		assertEquals(96,corner2.getPositionY());
		
		Corner corner3=spePos.getCorner3();
		assertNotNull(corner3);
		assertEquals(126,corner3.getPositionX());
		assertEquals(6,corner3.getPositionY());
		
		Corner corner4=spePos.getCorner4();
		assertNotNull(corner4);
		assertEquals(126,corner4.getPositionX());
		assertEquals(96,corner4.getPositionY());
	}
	
	/**
	 * comparison of penalty positions
	 */
	
	@Test
	public void testPenalty() {
		Penalty penalty1=spePos.getPenalty1();
		assertNotNull(penalty1);
		assertEquals(18,penalty1.getPositionX());
		assertEquals(48,penalty1.getPositionY());
		
		
		Penalty penalty2=spePos.getPenalty2();
		assertNotNull(penalty2);
		assertEquals(114,penalty2.getPositionX());
		assertEquals(48,penalty2.getPositionY());
	}
	
	/**
	 * comparison of engagement positions
	 */
	@Test
	public void testEngagement() {
		Engagement engagement=spePos.getEngagement();
		assertNotNull(engagement);
		assertEquals(63,engagement.getPositionX());
		assertEquals(48,engagement.getPositionY());
	}
	
	/**
	 * comparison of sixYard positions
	 */
	@Test
	public void testSixYard() {
		SixYard sixYard1=spePos.getSixYard1();
		assertNotNull(sixYard1);
		assertEquals(6,sixYard1.getPositionX());
		assertEquals(48,sixYard1.getPositionY());
		
		SixYard sixYard2=spePos.getSixYard2();
		assertNotNull(sixYard2);
		assertEquals(120,sixYard2.getPositionX());
		assertEquals(48,sixYard2.getPositionY());
	}
	
	/**
	 * comparison of goal positions
	 */
	@Test
	public void testGoals() {
		Goal goal1=spePos.getGoal1();
		assertNotNull(goal1);
		assertEquals(6,goal1.getPositionX());
		assertEquals(44,goal1.getPositionY());
		assertEquals(52,goal1.getPosition2Y());
		
		Goal goal2=spePos.getGoal2();
		assertNotNull(goal2);
		assertEquals(126,goal2.getPositionX());
		assertEquals(44,goal2.getPositionY());
		assertEquals(52,goal2.getPosition2Y());
		
		
		
		
	}
}
