import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die one;
int total;
int diceSize = 4;

public void setup()
{
	noLoop();
	background(0,0,0);
	size(1004,668);

}
public void draw(){
	total = 0;

	for (int i = 0; i < 1004; i+=diceSize){
		for (int j = 0; j<668; j+=diceSize){
			one = new Die(i,j);
			one.roll();
			one.show();
			total += one.numDots;
		}
	}

	fill(0,0,0);
	textSize(20);
	text("total: "+total,800,530);	
}

public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int myX;
	int myY;
	int numDots;
	Die(int x, int y) //constructor
	{
		myX = x;
		myY = y;
	}
	public void roll()
	{
		numDots = 6;//(int)(Math.random()*6+1);
		
	}
	public void show()
	{
		if ((myX+myY)%8 == 0){
			fill(random(0,255),200,200);
		} else {
			fill(255,255,255);
		}
		noStroke();
		rect(myX,myY,diceSize,diceSize);
		stroke(0);
		if (numDots == 1){
			point(myX+diceSize/4,myY+diceSize/4);
		}
		if (numDots == 2){
			point(myX, myY);
			point(myX+diceSize/2, myY+diceSize/2);
		}
		if (numDots == 3){
			point(myX+1,myY+1);
			point(myX+2,myY+2);
			point(myX+3,myY+3);
		}
		if (numDots == 4){
			point(myX+1,myY+1);
			point(myX+1,myY+3);
			point(myX+3,myY+1);
			point(myX+3,myY+3);
		}
		if (numDots == 5){
			point(myX+2,myY+2);
			point(myX+1,myY+1);
			point(myX+1,myY+3);
			point(myX+3,myY+1);
			point(myX+3,myY+3);
		}
		if (numDots == 6){
			point(myX+.5f,myY);
			point(myX+.5f,myY+1);
			point(myX+.5f,myY+2);
			point(myX+2.5f,myY);
			point(myX+2.5f,myY+1);
			point(myX+2.5f,myY+2);
		}

	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
