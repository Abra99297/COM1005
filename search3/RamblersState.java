import java.util.*;

public class RamblersState extends SearchState {
	
	//
	private TerrainMap Mymap;
	private Coords Mycoords;
	
	//my constructor
	public RamblersState(TerrainMap Map, Coords Coords) {
		Mymap = Map;
		Mycoords = Coords;
	}
	
	//the accessor
	public TerrainMap getThisMap() {
		return Mymap;
	}
	
	public Coords getCoords(){
		return Mycoords;
	}
	
	public boolean goalPredicate(Search searcher) {
		RamblersSearch Mysearcher = (RamblersSearch) searcher;
	    Coords goalCD = Mysearcher.getFinalCD(); 
	    return(Mycoords == goalCD);
	}
	
	public ArrayList<SearchState> getSuccessors(Search searcher){
		RamblersSearch Mysearcher = (RamblersSearch) searcher;
		Coords NextCD = Mysearcher.getFinalCD();
		
		//make list for RamblersState and searchState
		ArrayList<RamblersState> Rslist = new ArrayList<RamblersState>();
		ArrayList<SearchState> Slist = new ArrayList<SearchState>();
		
		//find out the height and the height difference
		int Myheight1 =Mycoords.gety() - Mycoords.getx();
		int Myheight2 =NextCD.gety() - NextCD.getx();
		int Hdiffer = Myheight2 - Myheight1;
		
		//find the right coords
		if(Myheight2 <= Myheight1) {
			
		}
		
		return Slist;
	}
	
	  public boolean sameState(SearchState RS1) {
		  RamblersState Mysearcher1 = (RamblersState) RS1;
		    return (Mycoords == Mysearcher1.getCoords());
		  }
	
	
	  public String toString() {
		  return "Ramblers State:" +Mycoords;
	  }
}