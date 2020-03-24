package datafield;

import process.management.SpecialPositionFactory;
import process.management.ConstantPosition; 

public class SpecialPosition {
	private Corner corner1;
	private Corner corner2;
	private Corner corner3;
	private Corner corner4;
	private Goal goal1;
	private Goal goal2;
	private Engagement engagement;
	private Penalty penalty1;
	private Penalty penalty2;
	private SixYard sixYard1;
	private SixYard sixYard2;
	
	public SpecialPosition() {
		this.corner1=SpecialPositionFactory.creaCorner(false, ConstantPosition.CORNER1X,ConstantPosition.CORNER1Y);
		this.corner2 = SpecialPositionFactory.creaCorner(false, ConstantPosition.CORNER2X,ConstantPosition.CORNER2Y);
		this.corner3 = SpecialPositionFactory.creaCorner(false, ConstantPosition.CORNER3X,ConstantPosition.CORNER3Y);
		this.corner4 = SpecialPositionFactory.creaCorner(false, ConstantPosition.CORNER4X,ConstantPosition.CORNER4Y);
		this.goal1 = SpecialPositionFactory.creaGoal(false, ConstantPosition.GOAL1X, ConstantPosition.GOALY1,ConstantPosition.GOALY2);
		this.goal2 = SpecialPositionFactory.creaGoal(false, ConstantPosition.GOAL2X, ConstantPosition.GOALY1,ConstantPosition.GOALY2);
		this.engagement = SpecialPositionFactory.creaEngagement(true,ConstantPosition.ENGAGEMENTX , ConstantPosition.ENGAGEMENTY);
		this.penalty1 = SpecialPositionFactory.creaPenalty(false, ConstantPosition.PENALTY1X, ConstantPosition.PENALTY1Y);
		this.penalty2 = SpecialPositionFactory.creaPenalty(false, ConstantPosition.PENALTY2X, ConstantPosition.PENALTY2Y);;
		this.sixYard1 = SpecialPositionFactory.creaSixYard(false, ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y);
		this.sixYard2 = SpecialPositionFactory.creaSixYard(false, ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y);
	}

	public Corner getCorner1() {
		return corner1;
	}
	public void setCorner1(Corner corner1) {
		this.corner1 = corner1;
	}
	public Corner getCorner2() {
		return corner2;
	}
	public void setCorner2(Corner corner2) {
		this.corner2 = corner2;
	}
	public Corner getCorner3() {
		return corner3;
	}
	public void setCorner3(Corner corner3) {
		this.corner3 = corner3;
	}
	public Corner getCorner4() {
		return corner4;
	}
	public void setCorner4(Corner corner4) {
		this.corner4 = corner4;
	}
	public Goal getGoal1() {
		return goal1;
	}
	public void setGoal1(Goal goal1) {
		this.goal1 = goal1;
	}
	public Goal getGoal2() {
		return goal2;
	}
	public void setGoal2(Goal goal2) {
		this.goal2 = goal2;
	}
	public Engagement getEngagement() {
		return engagement;
	}
	public void setEngagement(Engagement engagement) {
		this.engagement = engagement;
	}
	public Penalty getPenalty1() {
		return penalty1;
	}
	public void setPenalty1(Penalty penalty1) {
		this.penalty1 = penalty1;
	}
	public Penalty getPenalty2() {
		return penalty2;
	}
	public void setPenalty2(Penalty penalty2) {
		this.penalty2 = penalty2;
	}
	public SixYard getSixYard1() {
		return sixYard1;
	}
	public void setSixYard1(SixYard sixYard1) {
		this.sixYard1 = sixYard1;
	}
	public SixYard getSixYard2() {
		return sixYard2;
	}
	public void setSixYard2(SixYard sixYard2) {
		this.sixYard2 = sixYard2;
	}
	public String toString() {
		return "Les corners sont aux positions: " + corner1 + corner2 + corner3 + corner4 + " \nLes cages sont aux positions: " + goal1 + goal2 + "\n Le point d'engagement et à l a position: " + engagement
				+"\nLes pénaltys sont aux positions: " + penalty1 + penalty2 + "\nLes six-mètres sont aux positions: " + sixYard1 + sixYard2;
	}
	
	
}
