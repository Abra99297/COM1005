import java.util.*;

public class RamblersState extends SearchState {
	
	//
	private Coords Mycoords;
	private String Myway;
	
	//my constructor
	public RamblersState(Coords Coords, String Myway1) {
		Mycoords = Coords;
		Myway = Myway1;
	}

	//accessor
	public Coords getCoords(){
		return Mycoords;
	}
	
	public boolean goalPredicate(Search searcher) {
		RamblersSearch Mysearcher = (RamblersSearch) searcher;
	    Coords goalCD = Mysearcher.getGoalCD(); 
	    int Y = goalCD.gety();
	    int X = goalCD.getx();
	    return(Mycoords.gety() == Y && Mycoords.getx() == X);
	}
	
	public ArrayList<SearchState> getSuccessors(Search searcher){
		//find the map and the information
		RamblersSearch Mysearcher = (RamblersSearch) searcher;
		TerrainMap MyTmap = Mysearcher.getMymap();
		int[][] MyTnmp = MyTmap.getTmap();
		int MyWidth = MyTmap.getWidth();
		int MyDepth = MyTmap.getDepth();
		int Mylc = 0;
		
		//find the position in the map
		int Y1 = Mycoords.gety();
		int X1 = Mycoords.getx();
		
		//make list for RamblersState and searchState
		ArrayList<RamblersState> Rslist = new ArrayList<RamblersState>();
		ArrayList<SearchState> Slist = new ArrayList<SearchState>();
		
		//find the right coords
		
		
		return Slist;
	}
	
	  public boolean sameState(SearchState RS1) {
		  RamblersState Mysearcher1 = (RamblersState) RS1;
		  Coords MyCoords2 = Mysearcher1.getCoords();
		  int Y2 = MyCoords2.gety();
		  int X2 = MyCoords2.getx();
		  return (Mycoords.gety()==Y1 && Mycoords.getx()==X1);
		  }
	
	
	  public String toString() {
		  return "Ramblers State:" + Mycoords.gety() + Mycoords.getx();
	  }
}