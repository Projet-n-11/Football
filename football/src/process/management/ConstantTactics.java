package process.management;

public class ConstantTactics {
	
	/*
	 * Thoses constants are the positions which will place every players
	 * at every moment of the match in the field following which tactics
	 * the user chose. 
	 */
	
	public static final int INITIAL_POINT = ConstantPosition.INITIAL_POINT;
	public static final int HEIGHT = ConstantPosition.HEIGHT;
	public static final int WIDTH = ConstantPosition.WIDTH;
	public static final int R_GOALKEEPERX = WIDTH - 1;
	public static final int R_GOALKEEPERY = HEIGHT / 2;
	public static final int L_GOALKEEPERX = INITIAL_POINT + 1;
	public static final int L_GOALKEEPERY = HEIGHT / 2;
	public static final int ENGAGEMENT_PLAYER1X = WIDTH/2;
	public static final int ENGAGEMENT_PLAYER1Y = HEIGHT/2 - 8;
	public static final int ENGAGEMENT_PLAYER2X = WIDTH/2;
	public static final int ENGAGEMENT_PLAYER2Y = HEIGHT/2 + 8;
	
	/*
	 * 3 - 4 - 3
	 */
		//3-4-3 FOR LEFT SIDE OF THE FIELD
		public static final int L_FRONT_DEFENDERX343 = INITIAL_POINT + 21;
		public static final int L_FRONT_DEFENDERY343 = HEIGHT / 2;
		public static final int L_LEFT_DEFENDERX343 = INITIAL_POINT + 21;
		public static final int L_LEFT_DEFENDERY343 = HEIGHT/4;
		public static final int L_RIGHT_DEFENDERX343 = INITIAL_POINT + 21;
		public static final int L_RIGHT_DEFENDERY343 = HEIGHT/2 + HEIGHT/4;
		public static final int L_LEFT_MIDFIELDERX343 = WIDTH/2 - 10; 
		public static final int L_LEFT_MIDFIELDERY343 = HEIGHT/2 - 30; 
		public static final int L_MIDLEFT_MIDFIELDERX343 = WIDTH/2 - 20; 
		public static final int L_MIDLEFT_MIDFIELDERY343 = HEIGHT/2 - 8;
		public static final int L_MIDRIGHT_MIDFIELDERX343 = WIDTH/2 - 20; 
		public static final int L_MIDRIGHT_MIDFIELDERY343 = HEIGHT/2 + 8;
		public static final int L_RIGHT_MIDFIELDERX343 = WIDTH/2 - 10;
		public static final int L_RIGHT_MIDFIELDERY343 = HEIGHT/2 + 30;
		public static final int L_RIGHT_FORWARDX343 = WIDTH/2;
		public static final int L_RIGHT_FORWARDY343 = HEIGHT/2 - 8;
		public static final int L_LEFT_FORWARDX343 = WIDTH/2;
		public static final int L_LEFT_FORWARDY343 = HEIGHT/2 + 8;
		public static final int L_MID_FORWARDX343 = WIDTH/2 - 10;
		public static final int L_MID_FORWARDY343 = HEIGHT/2;
		
		//3-4-3 FOR RIGHT SIDE OF THE FIELD
		public static final int R_FRONT_DEFENDERX343 = WIDTH - 21;
		public static final int R_FRONT_DEFENDERY343 = HEIGHT / 2;
		public static final int R_LEFT_DEFENDERX343 = WIDTH - 21;
		public static final int R_LEFT_DEFENDERY343 = HEIGHT/4;
		public static final int R_RIGHT_DEFENDERX343 = WIDTH - 21;
		public static final int R_RIGHT_DEFENDERY343 = HEIGHT/2 + HEIGHT/4;
		public static final int R_LEFT_MIDFIELDERX343 = WIDTH/2 + 10; 
		public static final int R_LEFT_MIDFIELDERY343 = HEIGHT/2 - 30; 
		public static final int R_MIDLEFT_MIDFIELDERX343 = WIDTH/2 + 20; 
		public static final int R_MIDLEFT_MIDFIELDERY343 = HEIGHT/2 - 8;
		public static final int R_MIDRIGHT_MIDFIELDERX343 = WIDTH/2 + 20; 
		public static final int R_MIDRIGHT_MIDFIELDERY343 = HEIGHT/2 + 8;
		public static final int R_RIGHT_MIDFIELDERX343 = WIDTH/2 + 10;
		public static final int R_RIGHT_MIDFIELDERY343 = HEIGHT/2 + 30;
		public static final int R_RIGHT_FORWARDX343 = WIDTH/2;
		public static final int R_RIGHT_FORWARDY343 = HEIGHT/2 - 8;
		public static final int R_LEFT_FORWARDX343 = WIDTH/2;
		public static final int R_LEFT_FORWARDY343 = HEIGHT/2 + 8;
		public static final int R_MID_FORWARDX343 = WIDTH/2 + 10;
		public static final int R_MID_FORWARDY343 = HEIGHT/2;
	
	/*
	 *  2 - 3 - 5
	 */
		//2-3-5 FOR LEFT SIDE OF THE FIELD
		public static final int L_LEFT_DEFENDERX_235 = INITIAL_POINT + 21;
		public static final int L_LEFT_DEFENDERY_235 = HEIGHT/3;
		public static final int L_RIGHT_DEFENDERX_235 = INITIAL_POINT + 21;
		public static final int L_RIGHT_DEFENDERY_235 = HEIGHT/2 + HEIGHT/6;
		public static final int L_MID_HALFBACKX_235 = INITIAL_POINT + 35;
		public static final int L_MID_HALFBACKY_235 = HEIGHT / 2;
		public static final int L_LEFT_HALFBACKX_235 = INITIAL_POINT + 35; 
		public static final int L_LEFT_HALFBACKY_235 = HEIGHT/4;
		public static final int L_RIGHT_HALFBACKX_235 = INITIAL_POINT + 35; 
		public static final int L_RIGHT_HALFBACKY_235 = HEIGHT/2 + HEIGHT/4;
		public static final int L_LEFT_WINGERX_235 = WIDTH/2 - WIDTH/11; 
		public static final int L_LEFT_WINGERY_235 = HEIGHT/8;
		public static final int L_RIGHT_WINGERX_235 = WIDTH/2 - WIDTH/11;
		public static final int L_RIGHT_WINGERY_235 = HEIGHT - HEIGHT/8;
		public static final int L_LEFT_FORWARDX_235 = WIDTH/2;
		public static final int L_LEFT_FORWARDY_235 = HEIGHT/2 - WIDTH/14;
		public static final int L_RIGHT_FORWARDX_235 = WIDTH/2;
		public static final int L_RIGHT_FORWARDY_235 = HEIGHT/2 + WIDTH/14;
		public static final int L_MID_FORWARDX_235 = WIDTH/2 - 10;
		public static final int L_MID_FORWARDY_235 = HEIGHT/2;
		
		//2-3-5 FOR RIGHT SIDE OF THE FIELD
		public static final int R_LEFT_DEFENDERX_235 = WIDTH - 21;
		public static final int R_LEFT_DEFENDERY_235 = HEIGHT/2 - HEIGHT/6;
		public static final int R_RIGHT_DEFENDERX_235 = WIDTH - 21;
		public static final int R_RIGHT_DEFENDERY_235 = HEIGHT/2 + HEIGHT/6;
		public static final int R_MID_HALFBACKX_235 = WIDTH - 35;
		public static final int R_MID_HALFBACKY_235 = HEIGHT / 2;
		public static final int R_LEFT_HALFBACKX_235 = WIDTH - 35; 
		public static final int R_LEFT_HALFBACKY_235 = HEIGHT/4;
		public static final int R_RIGHT_HALFBACKX_235 = WIDTH - 35; 
		public static final int R_RIGHT_HALFBACKY_235 = HEIGHT/2 + HEIGHT/4;
		public static final int R_LEFT_WINGERX_235 = WIDTH/2 + WIDTH/11; 
		public static final int R_LEFT_WINGERY_235 = HEIGHT/8;
		public static final int R_RIGHT_WINGERX_235 = WIDTH/2 + WIDTH/11;
		public static final int R_RIGHT_WINGERY_235 = HEIGHT - HEIGHT/8;
		public static final int R_LEFT_FORWARDX_235 = WIDTH/2;
		public static final int R_LEFT_FORWARDY_235 = HEIGHT/2 - WIDTH/14;
		public static final int R_RIGHT_FORWARDX_235 = WIDTH/2;
		public static final int R_RIGHT_FORWARDY_235 = HEIGHT/2 + WIDTH/14;
		public static final int R_MID_FORWARDX_235 = WIDTH/2 + 10;
		public static final int R_MID_FORWARDY_235 = HEIGHT/2;	
	
	/*
	 * 4-2-4
	*/
		//4-2-4 FOR LEFT SIDE OF THE FIELD
		public static final int L_LEFTCENTERBACKX_424 = INITIAL_POINT + 21;
		public static final int L_LEFTCENTERBACKY_424 = HEIGHT/2 + HEIGHT/10;
		public static final int L_RIGHTCENTERBACKX_424 = INITIAL_POINT + 21;
		public static final int L_RIGHTCENTERBACKY_424 = HEIGHT/2 - HEIGHT/10;
		public static final int L_LEFTFULLBACKX_424 = INITIAL_POINT + 25;
		public static final int L_LEFTFULLBACKY_424 = HEIGHT/8;
		public static final int L_RIGHTFULLBACKX_424 = INITIAL_POINT + 25;
		public static final int L_RIGHTFULLBACKY_424 = HEIGHT - HEIGHT/8;
		public static final int L_LEFTHALFBACKX_424 = INITIAL_POINT + 40;
		public static final int L_LEFTHALFBACKY_424 = HEIGHT/2 + HEIGHT/10;
		public static final int L_RIGHTHALFBACKX_424 = INITIAL_POINT + 40;
		public static final int L_RIGHTHALFBACKY_424 = HEIGHT/2 - HEIGHT/10;
		public static final int L_LEFTWINGERX_424 = INITIAL_POINT + 55;
		public static final int L_LEFTWINGERY_424 = HEIGHT/8;
		public static final int L_RIGHTWINGERX_424 = INITIAL_POINT + 55;
		public static final int L_RIGHTWINGERY_424 = HEIGHT - HEIGHT/8;
		public static final int L_LEFTFOWARDX_424 = WIDTH/2;
		public static final int L_LEFTFOWARDY_424 = HEIGHT/2 - WIDTH/14;
		public static final int L_RIGHTFOWARDX_424 = WIDTH/2;
		public static final int L_RIGHTFOWARDY_424 = HEIGHT/2 + WIDTH/14;
		
		//4-2-4 FOR RIGHT SIDE OF THE FIELD
		public static final int R_LEFTCENTERBACKX_424 = WIDTH - 21;
		public static final int R_LEFTCENTERBACKY_424 = HEIGHT/2 + HEIGHT/10;
		public static final int	R_RIGHTCENTERBACKX_424 = WIDTH - 21;
		public static final int R_RIGHTCENTERBACKY_424 = HEIGHT/2 - HEIGHT/10;
		public static final int R_LEFTFULLBACKX_424 = WIDTH - 25;
		public static final int R_LEFTFULLBACKY_424 = HEIGHT/8;
		public static final int R_RIGHTFULLBACKX_424 = WIDTH - 25;
		public static final int	R_RIGHTFULLBACKY_424 = HEIGHT - HEIGHT/8;
		public static final int R_LEFTHALFBACKX_424 = WIDTH - 40;
		public static final int R_LEFTHALFBACKY_424 = HEIGHT/2 + HEIGHT/10;
		public static final int R_RIGHTHALFBACKX_424 = WIDTH - 40;
		public static final int R_RIGHTHALFBACKY_424 = HEIGHT/2 - HEIGHT/10;
		public static final int R_LEFTWINGERX_424 = WIDTH - 55;
		public static final int R_LEFTWINGERY_424 = HEIGHT/8;
		public static final int R_RIGHTWINGERX_424 = WIDTH - 55;
		public static final int R_RIGHTWINGERY_424 = HEIGHT - HEIGHT/8;
		public static final int R_LEFTFOWARDX_424 = WIDTH/2;
		public static final int R_LEFTFOWARDY_424 = HEIGHT/2 - WIDTH/14;
		public static final int R_RIGHTFOWARDX_424 = WIDTH/2;
		public static final int R_RIGHTFOWARDY_424 = HEIGHT/2 + WIDTH/14;
}
