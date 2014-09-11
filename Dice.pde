Die one;
int total;

void setup()
{
	noLoop();
	background(0,0,0);
	//size(displayWidth,displayHeight);
	size(1200,550);

}
void draw(){
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
		float dot = .5;
		fill(0,0,0);
		strokeWeight(.5);
		stroke(255,255,255);
		rect(myX,myY,5,5);
		fill(255,0,0);
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
			ellipse(myX+2/2,myY+2.6/2,dot,dot);
			ellipse(myX+2/2,myY+7.6/2,dot,dot);
			ellipse(myX+8/2,myY+2.6/2,dot,dot);
			ellipse(myX+8/2,myY+7.6/2,dot,dot);
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
