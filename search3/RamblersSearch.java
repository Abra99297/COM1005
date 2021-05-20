import java.util.*;

public class RamblersSearch extends Search {
	private Coords Mycoords;
	private Coords FinalCD;
	
	public Coords getMycoords() {
		return Mycoords;
	}
	
	public Coords getFinalCD() {
		return FinalCD;
	}
	
	public RamblersSearch(Coords Mycd, Coords Fncd) {
		Mycoords = Mycd;
		FinalCD = Fncd;
	}
}