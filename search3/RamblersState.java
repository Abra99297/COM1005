import java.util.*;

public class RamblersState extends SearchState {
	
	//
	private Coords Mycoords;
	private int Myheight;
	
	//my constructor
	public RamblersState(Coords MyCoords, int height) {
		Mycoords = MyCoords;
		Myheight = height;
	}
	
	//the accessor
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
		Coords NextCD = Mysearcher.getMycoords();
		
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