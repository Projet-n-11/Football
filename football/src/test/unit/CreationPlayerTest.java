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
import dataplayer.PlayerHealth;
import dataplayer.PlayerSpeed;
import dataplayer.PlayerStress;
import process.management.PlayerFactory;
import process.management.RecupTeam;
import test.input.InputParameter;

public class CreationPlayerTest {
	private DataPlayer player;
	
	@Before
	public void preparePlayer() throws IOException {
		RecupTeam team=new RecupTeam(InputParameter.NAME_TEAM);
		player=PlayerFactory.creaPlayer(team, InputParameter.NUMBER_PLAYER);
		
	}
	@Test
	public void testPlayerName() {
		String name=player.getPlayerName();
		
		assertNotNull(player);
		assertEquals("Mandanda",name);
	}
	@Test
	public void testNameTeam() {
		String team=player.getTeam();
		assertEquals("France",team);
	}
	@Test
	public void testPlayerNumber() {
		String number=player.getPlayerNumber();
		assertEquals("16",number);
		
	}
	@Test
	public void testTeamColor() {
		String color=player.getColorPlayer();
		assertEquals("blue",color);
	}
	@Test
	public void testPlayerCharacteristics() {
		AbstractDataPlayerType type=player.getPlayerType();
		assertTrue(type instanceof PlayerGoalie);
		assertEquals("Goalie",type.getPlayerTypeName());
		
		PlayerHealth health=type.getHeath();
		assertEquals(100,health.getHealth());
		
		PlayerStress stress=type.getStress();
		assertEquals(0,stress.getStress());
		
		PlayerSpeed speed=type.getSpeed();
		assertEquals(1,speed.getSpeedX());
		assertEquals(1,speed.getSpeedY());
		 
		int titular=type.getTitularPlayer();
		assertEquals(1,titular);
		
		assertEquals(3,((PlayerGoalie)type).getDive().getValueDive());
		assertEquals(4,((PlayerGoalie)type).getReflex().getValueReflex());
		
	}
	
	
}