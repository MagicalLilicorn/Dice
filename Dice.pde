Die one;
int total;
int diceSize = 4;

void setup()
{
	noLoop();
	background(0,0,0);
	//size(displayWidth,displayHeight);
	size(1400,650);

}
void draw(){
	total = 0;

	for (int i = 0; i < 1400; i+=diceSize){
		for (int j = 0; j<650; j+=diceSize){
			one = new Die(i,j);
			one.roll();
			one.show();
			total += one.numDots;
		}
	}

	fill(0,0,0);
	textSize(15);
	text("total: "+total,1100,530);	
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
		if ((myX+myY)%8 == 0){
			fill(random(0,255),200,200);
		} else {
			fill(255,255,255);
		}
		noStroke();
		rect(myX,myY,diceSize,diceSize);
		stroke(0);
		if (numDots == 1){
			point(myX+5/2,myY+5/2);
		}
		if (numDots == 2){
			point(myX+3/2, myY+3/2);
			point(myX+7/2, myY+7/2);
		}
		if (numDots == 3){
			point(myX+5/2,myY+2/2);
			point(myX+5/2,myY+5/2);
			point(myX+5/2,myY+8/2);
		}
		if (numDots == 4){
			point(myX+3/2,myY+3/2);
			point(myX+3/2,myY+7/2);
			point(myX+7/2,myY+3/2);
			point(myX+7/2,myY+7/2);
		}
		if (numDots == 5){
			point(myX+5/2,myY+5/2);
			point(myX+2/2,myY+2.6/2);
			point(myX+2/2,myY+7.6/2);
			point(myX+8/2,myY+2.6/2);
			point(myX+8/2,myY+7.6/2);
		}
		if (numDots == 6){
			point(myX+3/2,myY+2/2);
			point(myX+3/2,myY+5/2);
			point(myX+3/2,myY+8/2);
			point(myX+7/2,myY+2/2);
			point(myX+7/2,myY+5/2);
			point(myX+7/2,myY+8/2);
		}

	}
}
