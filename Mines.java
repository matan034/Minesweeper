package mines;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Mines {
	private Cell mat[][];
	private enum Vals{CLOSED,OPENED;}
	private int height;
	private int width;
	private int maxCells;//maxCells will represent the number of cells that are not mines
	protected boolean showAll=false;
	//create a board with the given values
	public Mines(int height, int width, int numMines) {
		mat=new Cell[height][width];//create a matrix of Cell's
		this.height=height;
		this.width=width;
		maxCells=height*width;//set maxCells to be all the cells in board
		for(int i=0;i<height;i++)
		 for(int j=0;j<width;j++)//create the matrix with all cells closed and not flag or mine
			mat[i][j]=new Cell(Vals.CLOSED,0,false,false,i,j);
		Random rand=new Random();
		int i;
		int j;
		while(numMines>0) {//create mines in our board according to input at random indexes
			i=rand.nextInt(height);
			j=rand.nextInt(width);
			while(mat[i][j].isMine) {//check if the i,j random got is not already a mine, if true get new i,j
				i=rand.nextInt(height);
				j=rand.nextInt(width);
			}
			addMine(i,j);
			numMines--;//
			}
		
			
		}
	
/*add a mine to a given index*/
	public boolean addMine(int i, int j) {
		try {
			mat[i][j].isMine=true;// set the cell to be a mine
			maxCells--;//sub 1 from maxCells for each mine
			List<Cell> neighbourList=new ArrayList<>();
			neighbourList=getNeighbours(i, j);//get all the neighbours of the current index
			for(Cell c : neighbourList) {//for each neighbour increase the num of is mines by 1
				c.numOfMines+=1;
			}
			return true;
		}
		catch(IndexOutOfBoundsException e) {return false;}
	}
	//this func recursivly opens cells 
	public boolean open(int i, int j) 
	{
		//if we reached a cell we can open we open it and update the number of available cells that can be opened in the mat
		if(mat[i][j].isMine!=true && mat[i][j].type!=Vals.OPENED && mat[i][j].isFlag!=true) {
			maxCells--;
			mat[i][j].type=Vals.OPENED;}
		else {//return in recursion
			return false;
			}
		//if we do not have a number in our cell we get that cells neighbors and run on them recursivly with open 
		if(mat[i][j].numOfMines==0) {
			List<Cell> neighbourList=new ArrayList<>();
			neighbourList=getNeighbours(i, j);
			for(Cell c : neighbourList) {
				if(c.type!=Vals.OPENED&&c.isMine!=true) open(c.i,c.j);
			}
			return true;
		}
		return true;
		
				
	}
	//this func builds a list of all neighbors that are not mines around the cell i,j
	private List<Cell> getNeighbours(int i,int j){
		List<Cell> res= new ArrayList<>();
		if(i-1>=0 && mat[i-1][j].isMine!=true) res.add(mat[i-1][j]);
		if(i+1<height && mat[i+1][j].isMine!=true) res.add(mat[i+1][j]);
		if(j-1>=0 && mat[i][j-1].isMine!=true) res.add(mat[i][j-1]);
		if(j+1<width && mat[i][j+1].isMine!=true) res.add(mat[i][j+1]);
		if(i-1>=0 && j-1>=0 &&mat[i-1][j-1].isMine!=true) res.add(mat[i-1][j-1]);
		if(i-1>=0 && j+1<width &&mat[i-1][j+1].isMine!=true) res.add(mat[i-1][j+1]);
		if(i+1<height && j-1>=0 &&mat[i+1][j-1].isMine!=true) res.add(mat[i+1][j-1]);
		if(i+1<height && j+1<width &&mat[i+1][j+1].isMine!=true) res.add(mat[i+1][j+1]);
		return res;
	}
	public void toggleFlag(int x,int y)
	{
		if(mat[x][y].isFlag==true) mat[x][y].isFlag=false;
		else mat[x][y].isFlag=true;
	}
	//this func returns what type of cell it is in a string format
	public String get(int i,int j)
	{
		if(showAll==false)
		{
			if(mat[i][j].isFlag==true) return "F";//if it's a flag
			if(mat[i][j].type==Vals.CLOSED) return ".";//if its closed
	
			if(mat[i][j].isMine==true)//if its a mine keep it closed
				return ".";

			if(mat[i][j].type==Vals.OPENED)	return mat[i][j].numOfMines>0? ""+mat[i][j].numOfMines:" ";//if its open return the number of mines around that tile
			
		}
		else
		{
			if(mat[i][j].isMine==true)//if we show everything show where the mines are
					return "X";
				else
					return mat[i][j].numOfMines>0? ""+mat[i][j].numOfMines:" ";//return number of mines surronding tile
		}
		return "";
	}
	public String toString()
	{
		StringBuilder b=new StringBuilder();
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
				b.append(get(i,j));
			b.append('\n');
		}
		return b.toString();
			
	}//checks if theres no more free cells to click meaning the game is done 
	public boolean isDone() 
	{
		if (maxCells==0) return true;
		return false;
	}//set flag 
	public void setShowAll(boolean showAll) {
		this.showAll=showAll;
	}//check if a cell is a mine
	protected boolean isMine(int i,int j) {
		return mat[i][j].isMine;
	}
	//class for a cell in our matrix each cell knows if its a mine a flag closed or open and it's cords in the mat
	private class Cell{
		Vals type;
		int numOfMines;
		boolean isMine;
		boolean isFlag;
		int i,j;
		public Cell(Vals type,int numOfMines,boolean isMine,boolean isFlag,int i,int j) {
			this.type=type;
			this.numOfMines=numOfMines;
			this.isMine=isMine;
			this.isFlag=isFlag;
			this.i=i;
			this.j=j;
		}
	}			
}
