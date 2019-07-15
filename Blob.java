package comp1406a5;

public class Blob extends Image{

  // leave this constructor as is. This is the constructor that we will  use
	// when testing your code.
	public Blob(int rows, int cols){
		super(rows, cols);
	}


  public void computePixelPerimeters(int row, int column){
		int s = 0;
		if (this.getPixel(row, column).hasInk()){
			if (row-1>=0 && this.getPixel(row-1, column).hasInk()==false){
				s+=1;
			}
			if (row+1<=this.rows-1 && this.getPixel(row+1, column).hasInk()==false){
				s+=1;
			}
			if (column-1>=0 && this.getPixel(row, column-1).hasInk()==false){
				s+=1;
			}
			if (column+1<=this.cols-1 && this.getPixel(row, column+1).hasInk()==false){
				s+=1;
			}
		}
		this.getPixel(row, column).setSides(s);
	}

  public int perHelper (int row, int column){
	int per = 0;
	boolean wall = false;
	if (row<0 || column<0 || row>this.rows-1 ||column>this.cols-1){
		wall = true;
	}
	if (wall || this.getPixel(row, column).hasInk()==false || this.getPixel(row, column).visited()){
		return 0;
	}
	computePixelPerimeters(row, column);
	this.getPixel(row, column).setVisited(true);
	per += this.getPixel(row, column).getSides();
	per +=  +perHelper(row-1, column) + perHelper(row, column-1) + perHelper(row, column+1) + perHelper(row+1, column);
	return per;
  }

  public int perimeter(int row, int column){
		this.clearImage();
		return perHelper(row, column);
	}






	public static void main(String[] args){
		Image img = Helper.makeRandomImage(3,4,0.35);
		System.out.println(img);
		((Blob)img).computePixelPerimeters(0,0);
		((Blob)img).computePixelPerimeters(1,0);
		System.out.println(((Blob)img).perimeter(0,0));
		System.out.println(((Blob)img).perimeter(1,0));
		System.out.println(((Blob)img).perimeter(1,3));
		System.out.println(((Blob)img).perimeter(2,2));
		((Blob)img).computePixelPerimeters(1,0);
		//((Blob)img).computePixelPerimeters(1,0);
		//((Blob)img).computePixelPerimeters(1,3);
		//((Blob)img).computePixelPerimeters(2,2);
	}


}
