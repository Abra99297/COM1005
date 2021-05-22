import java.util.ArrayList;

public class RamblersState4 extends SearchState4 {
	
	//
	private Coords Mycoords;
	private String Myway;
	
	//my constructor
	public RamblersState4(Coords Coords, int lc, String Myway1) {
		Mycoords = Coords;
		Myway = Myway1;
		this.localCost = lc; 
	}

	//accessor
	public Coords getCoords(){
		return Mycoords;
	}
	
	public boolean goalPredicate(Search4 searcher) {
		RamblersSearch4 Mysearcher = (RamblersSearch4) searcher;
	    Coords goalCD = Mysearcher.getGoalCD(); 
	    int Y = goalCD.gety();
	    int X = goalCD.getx();
	    return(Mycoords.gety() == Y && Mycoords.getx() == X);
	}
	
	public ArrayList<SearchState4> getSuccessors(Search4 searcher){
		//find the map and the information
		RamblersSearch4 Mysearcher = (RamblersSearch4) searcher;
		TerrainMap4 MyTmap = Mysearcher.getMymap();
		int[][] MyTnmp = MyTmap.getTmap();
		int MyWidth = MyTmap.getWidth();
		int MyDepth = MyTmap.getDepth();
		int Mylc = 0;
		
		//find the position in the map
		int Y1 = Mycoords.gety();
		int X1 = Mycoords.getx();
		int MyHeight = MyTnmp[Y1][X1];
		
		//make list for RamblersState and searchState
		ArrayList<RamblersState4> Rslist = new ArrayList<RamblersState4>();
		ArrayList<SearchState4> Slist = new ArrayList<SearchState4>();
		
		//use the Rambler¡¯s costs function find the lc and the coords
		if(Y1 > 0) {
			int up = MyTnmp[Y1 -1][X1];
			if (up <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1-1,X1),Mylc,Myway));
			}
			else {
				Mylc = 1 + up - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1-1,X1),Mylc,Myway));
			}
		}
		if(X1 > 0) {
			int left = MyTnmp[Y1][X1-1];
			if ( left<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1,X1-1),Mylc,Myway));
			}
			else {
				Mylc = 1 + left - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1,X1-1),Mylc,Myway));
			}
		}
		if(Y1-1 < MyDepth) {
			int down = MyTnmp[Y1 +1][X1];
			if (down <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1+1,X1),Mylc,Myway));
			}
			else {
				Mylc = 1 + down - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1+1,X1),Mylc,Myway));
			}
		}
		if(X1-1 < MyWidth) {
			int right = MyTnmp[Y1][X1+1];
			if ( right<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1,X1+1),Mylc,Myway));
			}
			else {
				Mylc = 1 + right - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1,X1+1),Mylc,Myway));
			}
		}
		
		//now return the ArrayList<SearchState> Slist
		return Slist;
	}
	
	  public boolean sameState(SearchState4 RS1) {
		  RamblersState4 Mysearcher1 = (RamblersState4) RS1;
		  Coords MyCoords2 = Mysearcher1.getCoords();
		  int Y2 = MyCoords2.gety();
		  int X2 = MyCoords2.getx();
		  return (Mycoords.gety()==Y2 && Mycoords.getx()==X2);
		  }
	
	
	  public String toString() {
		  return "Ramblers State:" + Mycoords.gety() +"," + Mycoords.getx();
	  }
}