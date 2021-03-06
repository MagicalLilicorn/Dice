Die one;
int total;
int diceSize = 4;

void setup()
{
	noLoop();
	background(0,0,0);
	size(1004,668);

}
void draw(){
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
			point(myX+1,myY+1);
		}
		if (numDots == 2){
			point(myX+1, myY+1);
			point(myX+3, 3);
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
			point(myX+1,myY+1);
			point(myX+1,myY+2);
			point(myX+1,myY+3);
			point(myX+3,myY+1);
			point(myX+3,myY+2);
			point(myX+3,myY+3);
		}

	}
}
