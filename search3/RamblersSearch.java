import java.util.*;

public class RamblersSearch extends Search {
	private Coords Mycoords;
	private Coords FinalCD;
	private int Height;
	
	public Coords getMycoords() {
		return Mycoords;
	}
	
	public Coords getFinalCD() {
		return FinalCD;
	}
	
	public int getHeight() {
		return Height;
	}
	
	public RamblersSearch(Coords Mycd, Coords Fncd, int height) {
		Mycoords = Mycd;
		FinalCD = Fncd;
		Height = height;
	}
}