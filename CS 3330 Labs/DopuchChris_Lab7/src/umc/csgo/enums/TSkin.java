package umc.csgo.enums;

public enum TSkin {
	
	ARCTIC(1),
	GUERRILLA(2),
	LEET(3),
	PHOENIX(4);
	
	private final int index;
	
	TSkin(int index) {
		if(index > 4 || index < 1) index = 1;
		this.index = index;
	}
	
	public int getIndex() { return this.index; }

}
