import java.util.*;

public class RamblersSearch4 extends Search4 {
	private TerrainMap4 Mymap;
	private Coords GoalCD;
	
	public TerrainMap4 getMymap() {
		return Mymap;
	}
	
	public Coords getGoalCD() {
		return GoalCD;
	}
	
	
	public RamblersSearch4(TerrainMap4 Map, Coords Glcd) {
		Mymap = Map;
		GoalCD = Glcd;
	}
}