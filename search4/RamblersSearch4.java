import java.util.*;

public class RamblersSearch4 extends Search {
	private TerrainMap Mymap;
	private Coords GoalCD;
	
	public TerrainMap getMymap() {
		return Mymap;
	}
	
	public Coords getGoalCD() {
		return GoalCD;
	}
	
	
	public RamblersSearch4(TerrainMap Map, Coords Glcd) {
		Mymap = Map;
		GoalCD = Glcd;
	}
}