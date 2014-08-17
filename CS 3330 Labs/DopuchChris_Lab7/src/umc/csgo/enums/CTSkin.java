package umc.csgo.enums;

public enum CTSkin {

	GIGN(1),
	GSG9(2),
	SAS(3),
	SEAL(4);
	
	private final int index;
	
	CTSkin(int index) {
		if(index > 4 || index < 1) index = 1;
		this.index = index;
	}
	
	public int getIndex() { return this.index; }

}
