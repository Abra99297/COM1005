import java.util.ArrayList;

public class RamblersState4 extends SearchState4 {
	
	//
	private Coords Mycoords;
	private String Myway;
	
	//based on BB, A* need a Estimated cost and 
	public RamblersState4(Coords Coords, int Lc, int Ec) {
		Mycoords = Coords;
		this.localCost = Lc;
		this.estRemCost = Ec;
	}
	//the Manhattan Distance between the current pixel and the goal (p + q).
	private int estBManD(int[][] Mytmap, Coords FirCD, Coords CoalCD) {
		int y1 = FirCD.gety();
		int x1 = FirCD.getx();
		int y2 = CoalCD.gety();
		int x2 = CoalCD.getx();
		// make sure y and x difference >0
		int yDiff = y1 - y2;
		if(yDiff < 0) {
			yDiff = yDiff * -1;
		}
		int xDiff = x1 - x2;
		if(xDiff < 0) {
			xDiff = xDiff * -1;
		}
		return yDiff + xDiff;
	}
	
	//the Euclidean distance
	private int estBEuc(int[][] Mytmap, Coords FirCD, Coords CoalCD) {
		int y1 = FirCD.gety();
		int x1 = FirCD.getx();
		int y2 = CoalCD.gety();
		int x2 = CoalCD.getx();
		int y_2 = (y1 - y2)*(y1 - y2);
		int x_2 = (x1 - x2)*(x1 - x2);
		//int ans = sqrt(y_2 + x_2) / 1;
		//return ans;
		//why cant use the sqrt
		return 0;
	}
	
	//the height difference
	private int estBHdiff(int[][] Mytmap, Coords FirCD, Coords CoalCD) {
		int y1 = FirCD.gety();
		int x1 = FirCD.getx();
		int y2 = CoalCD.gety();
		int x2 = CoalCD.getx();
		
		if(Mytmap[y2][x2] - Mytmap[y1][x1] > 0) {
			return Mytmap[y2][x2] - Mytmap[y1][x1];
		}
		else {
			return 0;
		}

	}
	
	//combinations of these


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
		//also we should think about the edges by use 0, width and depth
		if(Y1 > 0) {
			int up = MyTnmp[Y1 -1][X1];
			if (up <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1-1,X1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
			else {
				Mylc = 1 + up - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1-1,X1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
		}
		if(X1 > 0) {
			int left = MyTnmp[Y1][X1-1];
			if ( left<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1,X1-1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
			else {
				Mylc = 1 + left - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1,X1-1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
		}
		if(Y1 < MyDepth-1) {
			int down = MyTnmp[Y1 +1][X1];
			if (down <= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1+1,X1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
			else {
				Mylc = 1 + down - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1+1,X1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
		}
		if(X1 < MyWidth-1) {
			int right = MyTnmp[Y1][X1+1];
			if ( right<= MyHeight) {
				Mylc = 1;
				Slist.add(new RamblersState4(new Coords(Y1,X1+1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
			}
			else {
				Mylc = 1 + right - MyHeight;
				Slist.add(new RamblersState4(new Coords(Y1,X1+1),Mylc, estBManD(MyTnmp, Mycoords, Mysearcher.getGoalCD())));
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