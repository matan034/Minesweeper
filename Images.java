package mines;



import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;


//this class initalizes our images that we use in our cells
public final class Images {

	//images 
	private Image flag=new Image("mines/flagged.png");
	private Image mine=new Image("mines/bomb.png");
	private Image pressed=new Image("mines/0.png");
	private Image pressedBomb=new Image("mines/pressedBomb.png");
	private Image unpressed=new Image("mines/facingDown.png");
	private Image one=new Image("mines/1.png");
	private Image two=new Image("mines/2.png");
	private Image three=new Image("mines/3.png");
	private Image four=new Image("mines/4.png");
	private Image five=new Image("mines/5.png");
	private Image six=new Image("mines/6.png");
	private Image seven=new Image("mines/7.png");
	private Image eight=new Image("mines/8.png");

	protected BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
	
	protected BackgroundImage scaledImageUnpressed = new BackgroundImage(unpressed, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImagePressed = new BackgroundImage(pressed, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageFlag = new BackgroundImage(flag, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImagemine = new BackgroundImage(mine, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImagePressedBomb = new BackgroundImage(pressedBomb, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageOne = new BackgroundImage(one, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageTwo = new BackgroundImage(two, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageThree = new BackgroundImage(three, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageFour = new BackgroundImage(four, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageFive = new BackgroundImage(five, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageSix= new BackgroundImage(six, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageSeven = new BackgroundImage(seven, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	protected BackgroundImage scaledImageEight = new BackgroundImage(eight, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);	
	
	protected Background bUnpressed = new Background(scaledImageUnpressed);
	protected Background bPressed =new Background(scaledImagePressed);
	protected Background bFlag = new Background(scaledImageFlag);
	protected Background bmine =new Background(scaledImagemine);
	protected Background bPressedBomb = new Background(scaledImagePressedBomb);
	protected Background bOne = new Background(scaledImageOne);
	protected Background bTwo = new Background(scaledImageTwo);
	protected Background bThree = new Background(scaledImageThree);
	protected Background bFour = new Background(scaledImageFour);
	protected Background bFive = new Background(scaledImageFive);
	protected Background bSix= new Background(scaledImageSix);
	protected Background bSeven =new Background(scaledImageSeven);	
	protected Background bEight = new Background(scaledImageEight);


	
}
