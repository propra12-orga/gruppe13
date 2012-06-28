package Bomberman;

public class FieldEntry {

	private int item, image;
	private boolean walkable;

	/**
	 * Get/Set Item (erstmal uninterresant)
	 */
	public void setItem() {
		this.item = this.Random(6, 18);
		if (this.item >= 8) {
			this.item = 1;
		}
		if (JFeld.exit == false) {
			if (this.Random(1, 100) == 100) {
				this.item = 3;
				JFeld.exit = true;
			}
		}
	}

	public int getItem() {
		return item;
	}

	public FieldEntry(int image, boolean walkable) {
		this.image = image;
		this.walkable = walkable;
		if (image == 2) {
			this.setItem();
		}

	}

	/**
	 * Get/Set Nummer des Bildes
	 */
	public void setImage(int image) {
		this.image = image;
	}

	public int getImage() {
		return image;
	}

	/**
	 * Ganzzahliger Zufallsgenerator
	 */
	public int Random(int l, int h) {
		h++;
		return (int) (Math.random() * (h - l) + l);
	}

	public boolean getWalk() {
		return walkable;
	}

	public void setWalk(boolean walk) {
		this.walkable = walk;
	}
}
