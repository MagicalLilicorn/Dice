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
	size(1200,600);

}
public void draw(){
	total = 0;

	for (int i = 0; i < 1200; i+=10){
		for (int j = 0; j<600; j+=10){
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
		int dot = 1;
		fill(255,255,255);
		rect(myX,myY,10,10);
		fill(0,0,0);
		if (numDots == 1){
			ellipse(myX+5,myY+5,dot,dot);
		}
		if (numDots == 2){
			ellipse(myX+3, myY+3,dot,dot);
			ellipse(myX+7, myY+7,dot,dot);
		}
		if (numDots == 3){
			ellipse(myX+5,myY+2,dot,dot);
			ellipse(myX+5,myY+5,dot,dot);
			ellipse(myX+5,myY+8,dot,dot);
		}
		if (numDots == 4){
			ellipse(myX+3,myY+3,dot,dot);
			ellipse(myX+3,myY+7,dot,dot);
			ellipse(myX+7,myY+3,dot,dot);
			ellipse(myX+7,myY+7,dot,dot);
		}
		if (numDots == 5){
			ellipse(myX+5,myY+5,dot,dot);
			ellipse(myX+2,myY+2.6f,dot,dot);
			ellipse(myX+2,myY+7.6f,dot,dot);
			ellipse(myX+8,myY+2.6f,dot,dot);
			ellipse(myX+8,myY+7.6f,dot,dot);
		}
		if (numDots == 6){
			ellipse(myX+3,myY+2,dot,dot);
			ellipse(myX+3,myY+5,dot,dot);
			ellipse(myX+3,myY+8,dot,dot);
			ellipse(myX+7,myY+2,dot,dot);
			ellipse(myX+7,myY+5,dot,dot);
			ellipse(myX+7,myY+8,dot,dot);
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
