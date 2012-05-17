package SF;

public class FieldEntry {

	private int item, image;

	// GET/SET Item (erstmal un insteressant)
	public void setItem() {

		this.item = this.Random(1, 4);

	}

	public int getItem() {

		return item;
	}

	public FieldEntry() {

	}

	// GET/SET Nummer des Bildes
	public void setImag(int image) {
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

}
