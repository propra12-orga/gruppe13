

public class FieldEntry {

	private int item, image;
	private boolean walkable;

	// GET/SET Item (erstmal un insteressant)
	public void setItem() {
		this.item = this.Random(1, 4);
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

	// GET/SET Nummer des Bildes
	public void setImage(int image) {
		this.image = image;
	}

	public int getImage() {
		return image;
	}

	// ganzzahliger Zufallsgenerator
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
