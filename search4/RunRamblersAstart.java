public class RunRamblersAstart {

  public static void main(String[] arg) {
	  
	  //Make the map
	  TerrainMap4 Mymap = new TerrainMap4("search4/tmc.pgm");
	  Coords Fircoord = new Coords(1,1);
	  Coords Glcoord = new Coords(14,15);
	  
	  //use the search and state
	  SearchState4 MyState =(SearchState4)new RamblersState4(Fircoord, 0, 0);
	  RamblersSearch4 Mysearcher = new RamblersSearch4(Mymap,Glcoord);

	  //print out the search result
	  String RRbb = Mysearcher.runSearch(MyState, "Astar");
	  System.out.println(RRbb);

  }
}