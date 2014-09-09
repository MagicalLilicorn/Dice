Die one;
int total;

void setup()
{
	noLoop();
	size(displayWidth,displayHeight);
}
void draw(){
	for (int i = 0; i < displayWidth; i++){
		for (int j = 0; j<displayHeight; j++){
			one = new Die(10+60*i,10+60*j);
			one.roll();
			one.show();
			total += one.numDots;
			println(total);	

		}
	}
	
}

void mousePressed()
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
	void roll()
	{
		numDots = (int)(Math.random()*6+1);
		
	}
	void show()
	{
		int dot = 10;
		fill(255,255,255);
		rect(myX,myY,50,50,10);
		if (numDots == 1){
			fill(0,0,0);
			ellipse(myX+25,myY+25,dot,dot);
			text("1",myX,myY);
		}
		if (numDots == 2){
			fill(0,0,0);
			ellipse(myX+15, myY+15,dot,dot);
			ellipse(myX+35, myY+35,dot,dot);
			text("2",myX,myY);
		}
		if (numDots == 3){
			fill(0,0,0);
			ellipse(myX+25,myY+10,dot,dot);
			ellipse(myX+25,myY+25,dot,dot);
			ellipse(myX+25,myY+40,dot,dot);
			text("3",myX,myY);
		}
		if (numDots == 4){
			fill(0,0,0);
			ellipse(myX+15,myY+15,dot,dot);
			ellipse(myX+15,myY+35,dot,dot);
			ellipse(myX+35,myY+15,dot,dot);
			ellipse(myX+35,myY+35,dot,dot);
			text("4",myX,myY);
		}
		if (numDots == 5){
			fill(0,0,0);
			ellipse(myX+25,myY+25,dot,dot);
			ellipse(myX+10,myY+13,dot,dot);
			ellipse(myX+10,myY+38,dot,dot);
			ellipse(myX+40,myY+13,dot,dot);
			ellipse(myX+40,myY+38,dot,dot);
			text("5",myX,myY);
		}
		if (numDots == 6){
			fill(0,0,0);
			ellipse(myX+15,myY+10,dot,dot);
			ellipse(myX+15,myY+25,dot,dot);
			ellipse(myX+15,myY+40,dot,dot);
			ellipse(myX+35,myY+10,dot,dot);
			ellipse(myX+35,myY+25,dot,dot);
			ellipse(myX+35,myY+40,dot,dot);
			text("6",myX,myY);
		}

	}
}
