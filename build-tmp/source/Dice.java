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

public void setup()
{
	noLoop();
	background(0,0,0);
	//size(displayWidth,displayHeight);
	size(1200,500);
}
public void draw(){
	for (int i = 0; i < 1200; i++){
		for (int j = 0; j<500; j++){
			one = new Die(0+50*i,0+50*j);
			one.roll();
			one.show();
			total += one.numDots;
		}
	}
	fill(0,0,0);
	textSize(100);
	text("total: "+total,250,200);	
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
		numDots = (int)(Math.random()*6+1);
		
	}
	public void show()
	{
		int dot = 10;
		fill(255,255,255);
		noStroke();
		rect(myX,myY,50,50,10);
		fill(34,231,199);
		if (numDots == 1){
			ellipse(myX+25,myY+25,dot,dot);
		}
		if (numDots == 2){
			ellipse(myX+15, myY+15,dot,dot);
			ellipse(myX+35, myY+35,dot,dot);
		}
		if (numDots == 3){
			ellipse(myX+25,myY+10,dot,dot);
			ellipse(myX+25,myY+25,dot,dot);
			ellipse(myX+25,myY+40,dot,dot);
		}
		if (numDots == 4){
			ellipse(myX+15,myY+15,dot,dot);
			ellipse(myX+15,myY+35,dot,dot);
			ellipse(myX+35,myY+15,dot,dot);
			ellipse(myX+35,myY+35,dot,dot);
		}
		if (numDots == 5){
			ellipse(myX+25,myY+25,dot,dot);
			ellipse(myX+10,myY+13,dot,dot);
			ellipse(myX+10,myY+38,dot,dot);
			ellipse(myX+40,myY+13,dot,dot);
			ellipse(myX+40,myY+38,dot,dot);
		}
		if (numDots == 6){
			ellipse(myX+15,myY+10,dot,dot);
			ellipse(myX+15,myY+25,dot,dot);
			ellipse(myX+15,myY+40,dot,dot);
			ellipse(myX+35,myY+10,dot,dot);
			ellipse(myX+35,myY+25,dot,dot);
			ellipse(myX+35,myY+40,dot,dot);
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
