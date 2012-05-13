package SF;


public class Figur {
 /*
  * neues Object.
  * Grundlage fuer Figuren 
  * Mutterklasse von Bomberman und Monstern.
  */

 private int xposition;
 private int yposition;

 public Figur(){
 }


 public Figur(int xpos, int ypos) {
  this.xposition = xpos;
  this.yposition = ypos;
 }
 
 public int getxPosition() {
  return this.xposition;
 }

 public void setxPosition(int xpos) {
  this.xposition = xpos;
 }

 public int getyPosition() {
  return this.yposition;
 }

 public void setyPosition(int ypos) {
  this.yposition = ypos;
 }

 public boolean feldfrei(int x, int y, int[][] map) {
	 if (map[x][y]==0) return true;
	 else
		 return false;
	 }

 public void links(Feld field) {
	 int[][] map = field.getmap();
	 int x=getxPosition()-1;
  boolean b=this.feldfrei(x,getyPosition(), map);
  if(b==true){
   this.setxPosition(x);
  }
 }

 public void rechts(Feld field) {
	 int[][] map = field.getmap();
	 int x = getxPosition()+1;
  boolean b= this.feldfrei(x,getyPosition(), map);
  if(b==true){
    this.setxPosition(x);}
 }

 public void oben(Feld field) {
	 int[][] map = field.getmap();
	 int y=getyPosition()-1;
  boolean b=this.feldfrei(getxPosition(),y, map);
  if(b==true){
    this.setyPosition(y);}

 }

 public void unten(Feld field) {
	 int[][] map = field.getmap();
	 int y=getyPosition()+1;
  boolean b=this.feldfrei(getxPosition(),y, map);
  if(b==true){
    this.setyPosition(y);}
 }

 // TESTS

 
 /* @Test 
  public void neuFigur() {
   Figur a = new Figur();
   a.setxPosition(5);
   int b = a.getxPosition();
   assertTrue(5==b);
   }*/
}
