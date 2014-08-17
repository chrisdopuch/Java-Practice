package umc.csgo.enums;

public enum Team {

	CT(1, "Counter Terrorist"),
	T(2, "Terrorist"),
	O(3, "Observer");
	
	private final int index;
	private final String name;
	
	Team(int index, String name) {
		if(index > 3 || index < 1) index = 1;
		this.index = index;
		this.name = name;
	}
	
	public int getIndex() { return this.index; }
	
	@Override
	public String toString() { return this.name; }
	
}
