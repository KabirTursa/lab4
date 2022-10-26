//This class represents a box with a width, height, and depth.
//The variable grade is a measure of the thickness of the cardboard
//used to construct the box.

public class Box{

	private int width, depth;
	private int height, grade;

	//class constructor
	public Box(int width, int height, int depth, int grade)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.grade = grade;
	}
	//Two boxes should be considered equivalent if their volume is
	//the same and they are constructed out of the same grade of cardboard.
	//returns true if they are equivalent and false otherwise
	public boolean equals(Box b) {
		if (width * height * depth == b.getVolume() && grade == b.getGrade())
			return true;
		return false;
	}

	//If this Box is larger than the argument Box b
	//then return this Box - otherwise return b
	public Box larger(Box b)
	{
		if(b.getVolume() > this.getVolume())
			return this;
		return b;
	}

	//Simple getter methods
	public int getGrade()
	{
		return grade;
	}

	public int getVolume()
	{
		return width * height * depth;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getDepth()
	{
		return depth;
	}
}

