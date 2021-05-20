import java.util.*;

public class RamblersState extends SearchState {
	
	//
	private Coords Mycoords;
	
	//my constructor
	public RamblersState(Coords MyCoords, Coords FnCoords) {
		Mycoords = MyCoords;
		localCost = FnCoords;
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
		ArrayList<RamblersState> Rslist = new ArrayList<RamblersState>();
		ArrayList<SearchState> Slist = new ArrayList<SearchState>();
		
		
	}
	
	  public boolean sameState(SearchState RS1) {
		  RamblersState Mysearcher1 = (RamblersState) RS1;
		    return (Mycoords == Mysearcher1.getCoords());
		  }
	
	
}