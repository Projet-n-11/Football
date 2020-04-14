package test.unit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import dataplayer.AbstractDataPlayerType;
import dataplayer.DataPlayer;
import dataplayer.PlayerGoalie;
import dataplayer.PlayerStamina;
import dataplayer.PlayerSpeed;
import dataplayer.PlayerStress;
import process.management.PlayerFactory;
import process.management.RecupTeam;
import test.input.InputParameter;
/**
 * this class allows to test the creation of a player 
 * @author Quitterie,Aladdine,Laura
 *
 */
public class CreationPlayerTest {
	private DataPlayer player;
	/**
	 * creation of a player
	 * @throws IOException
	 */
	@Before
	public void preparePlayer() throws IOException {
		RecupTeam team=new RecupTeam(InputParameter.NAME_TEAM);
		player=PlayerFactory.creaPlayer(team, InputParameter.NUMBER_PLAYER);
		
	}
	/**
	 * Name comparison
	 */
	@Test
	public void testPlayerName() {
		String name=player.getPlayerName();
		
		assertNotNull(player);
		assertEquals("Mandanda",name);
	}
	/**
	 * comparison of team name
	 */
	@Test
	public void testNameTeam() {
		String team=player.getTeam();
		assertEquals("France",team);
	}
	/**
	 * comparison of number
	 */
	@Test
	public void testPlayerNumber() {
		String number=player.getPlayerNumber();
		assertEquals("16",number);
		
	}
	/**
	 * comparison of team color
	 */
	@Test
	public void testTeamColor() {
		String color=player.getColorPlayer();
		assertEquals("blue",color);
	}
	/**
	 * comparison of all player characteristics 
	 */
	@Test
	public void testPlayerCharacteristics() {
		AbstractDataPlayerType type=player.getPlayerType();
		assertTrue(type instanceof PlayerGoalie);
		assertEquals("Goalie",type.getPlayerTypeName());
		
		int stamina=type.getStamina();
		assertEquals(100,stamina);
		
		int stress=type.getStress();
		assertEquals(0,stress);
		
		PlayerSpeed speed=type.getSpeed();
		assertEquals(1,speed.getSpeedX());
		assertEquals(1,speed.getSpeedY());
		 
		int titular=type.getTitularPlayer();
		assertEquals(1,titular);
		
		assertEquals(3,((PlayerGoalie)type).getDive().getValueDive());
		assertEquals(4,((PlayerGoalie)type).getReflex().getValueReflex());
		
	}
	
	
}