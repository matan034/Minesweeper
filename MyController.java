package mines;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;




public class MyController {

    @FXML
    private BorderPane border;
    @FXML
    private Button resetBtn;
    @FXML
    private TextField heightText;
    @FXML
    private TextField widthText;
    @FXML
    private TextField mineText;
    @FXML
    private GridPane board;
    private Integer height,width,mines;
    private Mines logic;
    private MyButton [][] mat;
    
    @FXML
    void getHeight(ActionEvent event) {// get input from text box
    		height=Integer.parseInt(heightText.getText());
    }

    @FXML
    void getMines(ActionEvent event) {// get input from text box
    	mines=Integer.parseInt(mineText.getText());
    }

    @FXML
    void getWidth(ActionEvent event) {// get input from text box
    	width=Integer.parseInt(widthText.getText());
    }
   
    @FXML
    void resetBoard(ActionEvent event) {//after user set the input we create the game board
    	getHeight(null);
    	getMines(null);
    	getWidth(null);
    	if(mines<height*width)//check if user mines input is too big 
    	{
	    	board.getChildren().clear();//clear our last record
	    	logic=new Mines(height,width,mines);//create the logic behind the game
			mat= new MyButton[height][width];//matrix for buttons to match the ones in the grid pane
			for(int i=0;i<height;i++) 
				for(int j=0;j<width;j++)
				{
					MyButton b=new MyButton(i,j,new Images());//create a new myButton
					mat[i][j]=b;
					b.setPrefSize(35,35);	
					b.setOnMouseClicked(new openTile());//catch mouse click event
					b.setBackground(b.media.bUnpressed);//set a background picture for the button
					b.setContentDisplay(ContentDisplay.CENTER);
					b.button.setMaxHeight(Double.MAX_VALUE);
					b.button.setMaxWidth(Double.MAX_VALUE);
					board.add(b,j,i);//add button to the grid pane
				}		
    	}
    	//user put too many mines 
    	else makePopUp("too many mines, pls enter again",Color.BLUE);
    }
//event for mouse this func handles opening tiles via mouse clicks
 class openTile implements EventHandler<MouseEvent>{
	 
	 @Override//get the button we pressed on and it's cords
	 public void handle(MouseEvent event) {
	    	MyButton b=(MyButton)event.getSource();
	    	int x=b.x;
	    	int y=b.y;

            //check for right click
	    	if(event.getButton()==MouseButton.SECONDARY&& (logic.get(x, y)=="."||logic.get(x, y)=="F")) {
	    		logic.toggleFlag(x, y);
	    		if(logic.get(x,y)=="F") 
	    			mat[x][y].setBackground(mat[x][y].media.bFlag);
	    		else
	    			mat[x][y].setBackground(mat[x][y].media.bUnpressed);
	    	}
	    	if(event.getButton()==MouseButton.PRIMARY && logic.get(x, y)!="F") {
	    		if(logic.open(x,y))
				{
	    			boardImages();//this calls our func to update all buttons images accordingly
					if(logic.isDone()) 
							makePopUp("YOU WIN",Color.GREEN);
				}
	    		else {
			    	if(logic.isMine(x,y)) {
			    		logic.setShowAll(true);
			    		boardImages();//this calls our func to update all buttons images accordingly
			    		mat[x][y].setBackground(mat[x][y].media.bPressedBomb);
			    		makePopUp("You LOSE",Color.RED);
			            
			    	}
			    }
	    	}
	    }
 }
  //func to make a pop up window gets a message and color for the text
private void makePopUp(String str,Color color)
{
	//popup screen
	final Stage dialog = new Stage();
    dialog.initModality(Modality.APPLICATION_MODAL);
    VBox dialogVbox = new VBox(20);
    Text t=new Text("");
    t.setTextAlignment(TextAlignment.CENTER);
    dialogVbox.getChildren().add(t);
    dialogVbox.setAlignment(Pos.CENTER);
    Scene dialogScene = new Scene(dialogVbox, 300, 200);
    dialog.setScene(dialogScene);

    t.setFill(color);
    t.setText(str);
    dialog.show();
}
 private void boardImages() {//this func sets images for our buttons according to what our get returns 
 		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
					switch (logic.get(i, j)) {
						case " ":mat[i][j].setBackground(mat[i][j].media.bPressed); break;
						case "1":mat[i][j].setBackground(mat[i][j].media.bOne); break;
						case "2":mat[i][j].setBackground(mat[i][j].media.bTwo);break;
						case "3":mat[i][j].setBackground(mat[i][j].media.bThree);break;
						case "4":mat[i][j].setBackground(mat[i][j].media.bFour);break;
						case "5":mat[i][j].setBackground(mat[i][j].media.bFive);break;
						case "6":mat[i][j].setBackground(mat[i][j].media.bSix);break;
						case "7":mat[i][j].setBackground(mat[i][j].media.bSeven);break;
						case "8":mat[i][j].setBackground(mat[i][j].media.bEight);break;
						case ".":
							mat[i][j].setBackground(mat[i][j].media.bUnpressed);
							break;	
						case "F":mat[i][j].setBackground(mat[i][j].media.bFlag);break;
						case "X":
							if(logic.showAll==false)
								mat[i][j].setBackground(mat[i][j].media.bUnpressed);	
							else
								mat[i][j].setBackground(mat[i][j].media.bmine);
							break;
 	}
 }

    //class to make our own button with x,y cords and an image attached
    private class MyButton extends Button {
    	private Button button;
    	private int x,y;
    	private Images media;
    	
    	public MyButton(int x,int y,Images media)
    	{
    		button=new Button();
    		this.x=x;
    		this.y=y;
    		this.media=media;
    	}

    }
    
}
