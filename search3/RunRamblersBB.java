public class RunMapSearch {

  public static void main(String[] arg) {
	  
	  //Make the map
	  TerrainMap Mymap = new TerrainMap("tmc.pgm");
	  Coords Mycoord = new Coords();
	  
	  //use the search and state
	  RamblersSearch Mysearcher = new RamblersSearch(Mymap,);
	  RamblersState MyState = (RamblersState) new RamblersState();
	  
	  //print out the search result
	  String RRbb = Mysearcher.runSearch(MyState, "branchAndBound");
	  System.out.println(RRbb);


  }
}