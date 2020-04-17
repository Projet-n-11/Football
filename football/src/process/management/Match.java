package process.management;
import java.util.ArrayList;
import java.util.Iterator;

import databall.DataBall;
import datafield.Position;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
import process.movement.MovementBall;
import process.movement.MovementPlayer;

public class Match {
	/**
	 * Used in playerBehavior();
	 * allow one action for each soccer-player
	 * @param userTeam
	 * @param botTeam
	 */

	private Boolean itsUserRound, pickUserTeamPlayer;
	private DataTeam userTeam, botTeam;
	private Map positions;
	private DataBall ball;
	private MovementBall mb;
	private MovementPlayer mp;
	private Vision v;
	private ArrayList<DataPlayer> allPlayers;
	private int GoalLimitX;

	public Match(DataTeam userTeam, DataTeam botTeam, Map positions, DataBall ball, MovementBall mb, ArrayList<DataPlayer> allPlayers) {
		this.userTeam = userTeam;
		this.botTeam = botTeam;
		this.positions = positions;
		this.ball = ball;
		this.mp = new MovementPlayer(positions, ball);
		this.mb = mb;
		this.allPlayers = allPlayers;
		v = new Vision();
	}

	public void matchOneRound() {

		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer = null;
		Boolean bothHavePlayed = false;
		itsUserRound = false;
		pickUserTeamPlayer = true;
		
		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();

		/**
		 * first we move the ball considering its own speed (if it is free)
		 * and slow it down
		 */
		letTheBallMove();
		if (ball.getOwnedBy()!=null) {
			System.out.println("ball owned by " + ball.getOwnedBy().getPlayerName());
			if (ball.getOwnedBy().getHaveBall())
			{
				System.out.println("    (confirm)");
			}
			else
			{
				System.out.println(" BUT HE DOES NOT KNOW");
			}
		}
		
		
		// While there is nothing to interrupt the match, players are playing
		// And while both teams have players to deal with:
		while ((itUser.hasNext() || itBot.hasNext())){
			bothHavePlayed = false;
			pickUserTeamPlayer = true;
			itsUserRound = true;
			while (!bothHavePlayed) {
				if(pickUserTeamPlayer && itUser.hasNext()) {
					currentPlayer = itUser.next();
					pickUserTeamPlayer = false;
					itsUserRound = true;
					bothHavePlayed = false;
				}
				else {
					currentPlayer = itBot.next();
					pickUserTeamPlayer = true;
					itsUserRound = false;
					bothHavePlayed = true;
				}
				
				if (currentPlayer.getPlayerType().getTitularPlayer()==1 && currentPlayer.getPlayerType().getCanHeAct() + currentPlayer.getPlayerType().getSpeed().getSpeedX()>=5)
				{
					if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Forward")==0)
					{
						didActionHappenned(currentPlayer,Forward(currentPlayer));
					}
					else if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Midfielder")==0)
					{
						didActionHappenned(currentPlayer,Midfielder(currentPlayer));
					}
					else if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Defender")==0)
					{
						didActionHappenned(currentPlayer,Defender(currentPlayer));
					}
					else
					{
						didActionHappenned(currentPlayer,Goalie(currentPlayer));
					}
					/*************************************************************************************/
				}
				else
				{
					currentPlayer.setPlayerStamina(currentPlayer.getPlayerType().getStamina() + 1);
				}
				
				currentPlayer.getPlayerType().setCanHePass(currentPlayer.getPlayerType().getCanHePass()+1);
				
				if (currentPlayer.getPlayerType().getCanHeAct()+currentPlayer.getPlayerType().getSpeed().getSpeedX()<5)
				{		
				currentPlayer.getPlayerType().setCanHeAct(currentPlayer.getPlayerType().getCanHeAct()+1);					
				}
			}
		}		

		System.out.println("1 round done\n");
	}
	
	public void letTheBallMove() {
		if (ball.getOwnedBy()==null)
		{
			System.out.println("they see me rollin'...");
			if (ball.getCanIt()+Math.abs(ball.getSpeedX())>=5 || ball.getCanIt()+Math.abs(ball.getSpeedY())>=5)
			{
				mb.roll();			
			}
			else
			{
				ball.setCanIt(ball.getCanIt()+1);
			}

		}

	}

	
	public Boolean Forward(DataPlayer currentPlayer) {
		if (currentPlayer.getHaveBall()) {										// if Forward player has ball
			if (v.seeCages(currentPlayer.getPositionX(), currentPlayer.getPositionY(), itsUserRound)) // and see cages
			{
				System.out.println(currentPlayer.getPlayerName() + " sees cages");
				mp.shoot(currentPlayer, ball, itsUserRound);
				return true;
			}
			else
			{
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);				// if does not see cages -> go to cages
				return true;
			}
		}
		else if (ball.getOwnedBy()!=null && ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())==0) // if ball owned by their own team
		{
			mp.cover(currentPlayer, ball.getOwnedBy(), itsUserRound);
			return false;
		}
		else											// if Forward player does not have ball
		{
			if (ball.getOwnedBy()!=null && ball.getOwnedBy().getPlayerType().getPlayerTypeName().compareTo("Goalie")==0) {
						mp.moveToCoord(currentPlayer, ConstantPosition.ENGAGEMENTX, ConstantPosition.INITIAL_POINT, itsUserRound);
						return false;
					}
			if (!mp.isCloseToBall(currentPlayer, ball)) {
				mp.move(currentPlayer, ball, itsUserRound);
			}
			if (mp.isCloseToBall(currentPlayer, ball)) {
				if (ball.getOwnedBy()==null) {									// if free ball -> reach ball
					mp.reachBall(currentPlayer, ball);
					return false;
				}
				else								// if ball owned by ennemy						
				{
					mp.tryInterception(currentPlayer, ball, itsUserRound, mb);
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean Goalie(DataPlayer currentPlayer) {
		ArrayList<Position> objectsSeen = v.Goalsee(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
		int i;
		
		if (itsUserRound)
		{
			GoalLimitX = ConstantPosition.INITIAL_POINT+15;
		}
		else
		{
			GoalLimitX = ConstantPosition.WIDTH-15;
		}
		
		if (currentPlayer.getHaveBall()) {												// if Goalie has ball ;
			if (Math.abs(currentPlayer.getPositionX()-GoalLimitX)<=5) {								// if is ready to pass :
				System.out.println("Goalie " + currentPlayer.getPlayerName() + " ready to pass !");
				DataPlayer otherPlayer;
				for (i=0; i<objectsSeen.size() ; i++) {
					if (objectsSeen.get(i) instanceof DataPlayer)				
					{
						otherPlayer = (DataPlayer)objectsSeen.get(i);
						if (otherPlayer.getTeam().compareTo(currentPlayer.getTeam())==0) // if see pal :
						{
							mp.passBalltoPal(currentPlayer, otherPlayer, ball);
							System.out.println("Goalie " + currentPlayer.getPlayerName() + " passed to " + otherPlayer.getPlayerName());
							currentPlayer.getPlayerType().setCanHePass(-1);
							otherPlayer.getPlayerType().setCanHePass(0);
							return true;
						}
					}
				}
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
				return true;
			}
			else if (itsUserRound) {
				if (currentPlayer.getPositionX()<GoalLimitX){
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
				return true;
				}
			}
			else {
				if (currentPlayer.getPositionX()>GoalLimitX) {
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
				}
			}
		}
		else if (ball.getOwnedBy()!=null && ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())==0) {
			if (Math.abs(currentPlayer.getPositionX()-getInitialPositionPlayer(currentPlayer).getPositionX())>0) {
				if (Math.abs(currentPlayer.getPositionX()-getInitialPositionPlayer(currentPlayer).getPositionX())>0) {
					mp.moveToCoord(currentPlayer, getInitialPositionPlayer(currentPlayer).getPositionX(), getInitialPositionPlayer(currentPlayer).getPositionX(), itsUserRound);
				}
			}
		}
		else
		{							// if Goalie does not have ball :
			for (i=0; i<objectsSeen.size() ; i++) {
				if (objectsSeen.get(i) instanceof DataBall)				// if see ball :
				{
					if (!mp.isCloseToBall(currentPlayer, ball))			// if is close to ball :
					{
						mp.move(currentPlayer, ball, itsUserRound);
					}
					if (mp.isCloseToBall(currentPlayer, ball)) {
						if (ball.getOwnedBy()==null) {					// if it is free :
							mp.reachBall(currentPlayer, ball);
							return true;
						}
						else if (ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())!=0) // if ennemy has this ball:
						{
							mp.tryInterception(currentPlayer, ball, itsUserRound, mb);
							return true;
						}
					}
				}
			}
		}
		objectsSeen = null;
		return false;
	}
	
	public Boolean Midfielder(DataPlayer currentPlayer) {
		int i=0;
		Boolean limit, act=false;
		ArrayList<Position> objectsSeen = v.see(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
		
		if (itsUserRound) {
			limit = Math.abs(currentPlayer.getPositionX()-ConstantPosition.WIDTH-(ConstantPosition.WIDTH/3))<10;
		}
		else {
			limit = Math.abs(currentPlayer.getPositionX()-ConstantPosition.WIDTH/3)<10;
		}
		
		if (currentPlayer.getHaveBall()) {
			if (limit) // if get close to their field-limits :
			{
											// consider to pass :	
				DataPlayer otherPlayer;
				Boolean didPass=false;
				for (i=0; i<objectsSeen.size() ; i++) {
					if (objectsSeen.get(i) instanceof DataPlayer)				
					{
						otherPlayer = (DataPlayer)objectsSeen.get(i);
						if (otherPlayer.getTeam().compareTo(currentPlayer.getTeam())==0) // if see pal :
						{
							mp.passBalltoPal(currentPlayer, otherPlayer, ball);
							currentPlayer.getPlayerType().setCanHePass(-1);
							otherPlayer.getPlayerType().setCanHePass(0);
							didPass=true;
							act=true;
						}
					}
				}
				if (!didPass)
				{
					mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
					act=true;
				}
				
			}
			else
			{
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
				act=true;
			}
		}		
		else if (ball.getOwnedBy()!=null && ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())==0)						
		{
			mp.cover(currentPlayer, ball.getOwnedBy(), itsUserRound);
			act=true;
		}
		else {																		 // if does not have ball
			if (ball.getOwnedBy()!=null && ball.getOwnedBy().getPlayerType().getPlayerTypeName().compareTo("Goalie")==0) {
				mp.moveToCoord(currentPlayer, ConstantPosition.ENGAGEMENTX, ConstantPosition.INITIAL_POINT, itsUserRound);
				return false;
			}
			for (i=0; i<objectsSeen.size() ; i++) {
				if (objectsSeen.get(i) instanceof DataBall)				
				{
					if (!mp.isCloseToBall(currentPlayer, ball))
					{
						mp.move(currentPlayer, ball, itsUserRound);
					}
					if (mp.isCloseToBall(currentPlayer, ball)) {
						if (ball.getOwnedBy()==null)
						{
							mp.reachBall(currentPlayer, ball);
							return true;
						}
						else {
							mp.tryInterception(currentPlayer, ball, itsUserRound, mb);
							return true;
						}
					}
				}
			}
		}
		objectsSeen = null;
		return act;
	}
	
	public Boolean Defender(DataPlayer currentPlayer) {
		int i=0, middle = ConstantPosition.WIDTH/2;
		Boolean act=false;
		ArrayList<Position> objectsSeen = v.see(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
		
		if (currentPlayer.getHaveBall()) {
			if (Math.abs(currentPlayer.getPositionX()-middle)<10) // if get close to their field-limits :
			{
												// consider to pass :	
				DataPlayer otherPlayer;
				Boolean didPass=false;
				for (i=0; i<objectsSeen.size() ; i++) {
					if (objectsSeen.get(i) instanceof DataPlayer)				
					{
						otherPlayer = (DataPlayer)objectsSeen.get(i);
						if (otherPlayer.getTeam().compareTo(currentPlayer.getTeam())==0) // if see pal :
						{
							mp.passBalltoPal(currentPlayer, otherPlayer, ball);
							currentPlayer.getPlayerType().setCanHePass(-1);
							otherPlayer.getPlayerType().setCanHePass(0);
							didPass=true;
							act=true;
						}
					}
				}
				if (!didPass)
				{
					mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
					act=true;
				}
			}
			else
			{
				mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
				return true;
			}
		}		
		else if (ball.getOwnedBy()!=null && ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())==0)						
		{
			mp.cover(currentPlayer, ball.getOwnedBy(), itsUserRound);
			return false;
		}
		else {																		 // if does not have ball
			for (i=0; i<objectsSeen.size() ; i++) {
				if (objectsSeen.get(i) instanceof DataBall)				
				{
					if (!mp.isCloseToBall(currentPlayer, ball))
					{
						mp.move(currentPlayer, ball, itsUserRound);
					}
					if (mp.isCloseToBall(currentPlayer, ball)) {
						if (ball.getOwnedBy()==null)
						{
							mp.reachBall(currentPlayer, ball);
							return true;
						}
						else {
							mp.tryInterception(currentPlayer, ball, itsUserRound, mb);
							return true;
						}
					}
				}
				else {
					mp.goBackToInitialPosition(currentPlayer, getInitialPositionPlayer(currentPlayer), itsUserRound);
					//System.out.println(currentPlayer.getPlayerType().getSpeed());
				}
			}
		}
		objectsSeen = null;
		return act;
	}

	public void didActionHappenned(DataPlayer currentPlayer, Boolean didSomething) {
		
		if (didSomething)
		{	
			if (currentPlayer.getPlayerType().getCanHeAct()>=0) {
				currentPlayer.getPlayerType().setCanHeAct(-1);
			}
			currentPlayer.setPlayerStamina(currentPlayer.getPlayerType().getStamina() - 1);
		}
		else {
			currentPlayer.setPlayerStamina(currentPlayer.getPlayerType().getStamina() + 1);
			currentPlayer.setPlayerStress(currentPlayer.getPlayerType().getStress()-1);
		}
		

		
	}
	
	public Position getInitialPositionPlayer(DataPlayer player) {
		for(DataPlayer players: allPlayers) {
			if(players.getPlayerName().contains(player.getPlayerName())) {
				Position initial_pos_player = new Position(players.getPositionX(), players.getPositionY());
				return initial_pos_player;
			}
		}
		return new Position(0,0);
	}

}
