/**
 * 
 */
package process.management;
import datafield.Corner;
import datafield.Engagement;
import datafield.Goal;
import datafield.Penalty;
import datafield.SixYard;
/**
 * @author quitt
 *
 */
public class ObjectFactory {

	public static Corner creaCorner(boolean isCorner,int positionX,int positionY) {
		return new Corner(isCorner, positionX, positionY);
	}
	public static Engagement creaEngagement(boolean engagementPoint, int positionX, int positionY) {
		return new Engagement(engagementPoint,positionX,positionY);
	}
	public static Goal creaGoal(boolean insideBall, int positionX, int positionY,int position2Y) {
		return new Goal(insideBall,positionX,positionY,position2Y);
	}
	public static Penalty creaPenalty( boolean fault, int positionX, int positionY) {
		return new Penalty(fault,positionX,positionY);
	}
	public static SixYard creaSixYard(boolean sixYardPoint, int positionX, int positionY) {
		return new SixYard(sixYardPoint,positionX,positionY);
	}
	
}
