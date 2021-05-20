import java.util.*;

public class RamblersSearch extends Search {
	private TerrainMap Mymap;
	private Coords GoalCD;
	
	public TerrainMap getMymap() {
		return Mymap;
	}
	
	public Coords getFinalCD() {
		return GoalCD;
	}
	
	
	public RamblersSearch(TerrainMap Map, Coords Glcd) {
		Mymap = Map;
		GoalCD = Glcd;
	}
}