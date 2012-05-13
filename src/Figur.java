import static org.junit.Assert.*;

import org.junit.Test;

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

 public void links(int[][] map) {
  boolean b=this.feldfrei(getxPosition(),getyPosition(), map);
  
  if(b==true){
   this.setxPosition(xposition - 1);
  }
 }

 public void rechts(int[][] map) {
  boolean b= this.feldfrei(getxPosition(),getyPosition(), map);
  if(b==true){
    this.setxPosition(xposition + 1);}
 }

 public void oben(int[][] map) {
  boolean b=this.feldfrei(getxPosition(),getyPosition(), map);
  if(b==true){
    this.setyPosition(yposition - 1);}

 }

 public void unten(int[][] map) {
  boolean b=this.feldfrei(getxPosition(),getyPosition(), map);
  if(b==true){
    this.setyPosition(yposition - 1);}
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
