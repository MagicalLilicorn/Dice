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
	size(1200,550);

}
public void draw(){
	total = 0;

	for (int i = 0; i < 1200; i+=5){
		for (int j = 0; j<550; j+=5){
			one = new Die(i,j);
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
		float dot = .5f;
		fill(random(0,255),255,255);
		noStroke();
		rect(myX,myY,5,5);
		fill(0,0,0);
		if (numDots == 1){
			ellipse(myX+5/2,myY+5/2,dot,dot);
		}
		if (numDots == 2){
			ellipse(myX+3/2, myY+3/2,dot,dot);
			ellipse(myX+7/2, myY+7/2,dot,dot);
		}
		if (numDots == 3){
			ellipse(myX+5/2,myY+2/2,dot,dot);
			ellipse(myX+5/2,myY+5/2,dot,dot);
			ellipse(myX+5/2,myY+8/2,dot,dot);
		}
		if (numDots == 4){
			ellipse(myX+3/2,myY+3/2,dot,dot);
			ellipse(myX+3/2,myY+7/2,dot,dot);
			ellipse(myX+7/2,myY+3/2,dot,dot);
			ellipse(myX+7/2,myY+7/2,dot,dot);
		}
		if (numDots == 5){
			ellipse(myX+5/2,myY+5/2,dot,dot);
			ellipse(myX+2/2,myY+2.6f/2,dot,dot);
			ellipse(myX+2/2,myY+7.6f/2,dot,dot);
			ellipse(myX+8/2,myY+2.6f/2,dot,dot);
			ellipse(myX+8/2,myY+7.6f/2,dot,dot);
		}
		if (numDots == 6){
			ellipse(myX+3/2,myY+2/2,dot,dot);
			ellipse(myX+3/2,myY+5/2,dot,dot);
			ellipse(myX+3/2,myY+8/2,dot,dot);
			ellipse(myX+7/2,myY+2/2,dot,dot);
			ellipse(myX+7/2,myY+5/2,dot,dot);
			ellipse(myX+7/2,myY+8/2,dot,dot);
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
