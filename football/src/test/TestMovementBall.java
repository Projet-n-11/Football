package test;

import databall.DataBall;
import process.management.Map;
import process.movement.MovementBall;

public class TestMovementBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map table=new Map();
		System.out.println("..........test Corner Left.........");
		DataBall db=new DataBall(-1,5);
		System.out.println(db);
		
		MovementBall mb=new MovementBall(db,table);
		System.out.println(db);
		
		System.out.println("..........test goal Right.........");
		
		db.setPositionX(121);
		db.setPositionY(43);
		System.out.println(db);
		
		mb=new MovementBall(db,table);
		System.out.println(db);
		
		
		
		
	
		
	}

}
