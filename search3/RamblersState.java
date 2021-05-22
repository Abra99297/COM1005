import java.util.*;

public class RamblersState extends SearchState {
	
	//
	private Coords Mycoords;
	
	//my constructor
	public RamblersState(Coords Coords, int lc) {
		Mycoords = Coords;
		this.localCost = lc; 
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
		int MyHeight = MyTnmp[Y1][X1];
		
		//make list for RamblersState and searchState
		ArrayList<RamblersState> Rslist = new ArrayList<RamblersState>();
		ArrayList<SearchState> Slist = new ArrayList<SearchState>();
		
		//use the Rambler¡¯s costs function find the lc and the coords
		if(Y1 > 0) {
			int up = MyTnmp[Y1 -1][X1];
			if (up <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState(new Coords(Y1-1,X1),Mylc));
			}
			else {
				Mylc = 1 + up - MyHeight;
				Slist.add(new RamblersState(new Coords(Y1-1,X1),Mylc));
			}
		}
		if(X1 > 0) {
			int left = MyTnmp[Y1][X1-1];
			if ( left<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState(new Coords(Y1,X1-1),Mylc));
			}
			else {
				Mylc = 1 + left - MyHeight;
				Slist.add(new RamblersState(new Coords(Y1,X1-1),Mylc));
			}
		}
		if(Y1 < MyDepth-1) {
			int down = MyTnmp[Y1 +1][X1];
			if (down <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState(new Coords(Y1+1,X1),Mylc));
			}
			else {
				Mylc = 1 + down - MyHeight;
				Slist.add(new RamblersState(new Coords(Y1+1,X1),Mylc));
			}
		}
		if(X1 < MyWidth-1) {
			int right = MyTnmp[Y1][X1+1];
			if ( right<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState(new Coords(Y1,X1+1),Mylc));
			}
			else {
				Mylc = 1 + right - MyHeight;
				Slist.add(new RamblersState(new Coords(Y1,X1+1),Mylc));
			}
		}

		
		//now return the ArrayList<SearchState> Slist
		return Slist;
	}
	
	  public boolean sameState(SearchState RS1) {
		  RamblersState Mysearcher1 = (RamblersState) RS1;
		  Coords MyCoords2 = Mysearcher1.getCoords();
		  int Y2 = MyCoords2.gety();
		  int X2 = MyCoords2.getx();
		  return (Mycoords.gety()==Y2 && Mycoords.getx()==X2);
		  }
	
	
	  public String toString() {
		  return "Ramblers State:" + Mycoords.gety() +"," + Mycoords.getx();
	  }
}