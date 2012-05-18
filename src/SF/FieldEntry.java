package SF;

public class FieldEntry {

	private int item, image;
	private boolean destroyable;

	// GET/SET Item (erstmal un insteressant)
	public void setItem() {

		this.item = this.Random(1, 4);

	}

	public int getItem() {

		return item;
	}

	public FieldEntry(int image, boolean destroy, int item) {
		this.image = image;
		this.destroyable = destroy;
		this.item = item;
	}

	// GET/SET Nummer des Bildes
	public void setImag(int image) {
		this.image = image;
	}

	public int getImage() {
		return image;
	}

	// Zerstoerbarkeit
	public void setDest(boolean d) {
		this.destroyable = d;
	}

	public boolean getDest() {
		return destroyable;
	}

	// ganzzahliger Zufallsgenerator
	public int Random(int l, int h) {
		h++;
		return (int) (Math.random() * (h - l) + l);
	}

}
