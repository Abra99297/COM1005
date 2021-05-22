public class RunRamblersBB {

  public static void main(String[] arg) {
	  
	  //Make the map
	  TerrainMap Mymap = new TerrainMap("search3/diablo.pgm");
	  Coords Glcoord = new Coords(123,180);
	  Coords Fircoord = new Coords(1,1);
	  
	  //use the search and state
	  SearchState MyState =(SearchState)new RamblersState(Fircoord, 0);
	  RamblersSearch Mysearcher = new RamblersSearch(Mymap,Glcoord);

	  //print out the search result
	  String RRbb = Mysearcher.runSearch(MyState, "branchAndBound");
	  System.out.println(RRbb);

  }
}