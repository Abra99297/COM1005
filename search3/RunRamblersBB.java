public class RunMapSearch {

  public static void main(String[] arg) {
	  
	  //Make the map
	  TerrainMap Mymap = new TerrainMap("tmc.pgm");
	  Coords Glcoord = new Coords(10,8);
	  Coords Fircoord = new Coords(4,6);
	  
	  //use the search and state
	  RamblersSearch Mysearcher = new RamblersSearch(Mymap,Glcoord);

	  
	  //print out the search result
	  String RRbb = Mysearcher.runSearch(MyState, "branchAndBound");
	  System.out.println(RRbb);


  }
}