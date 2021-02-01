package prog;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;


public class ViewMain extends Application{

	static Label Label1;
	static Label LabelTemp;
	GridPane gridpane;
	Group root;
	
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
	
	public void start(Stage stage) {
		stage.setTitle("James Calculator");
		Label1 = new Label("0");
		LabelTemp = new Label("");
	    root = new Group();
		Scene scene = new Scene(root,400,450);
		stage.setScene(scene);
	
		
		gridpane = new GridPane();
		gridpane.add(ButtonControl.createButtonInt("1", Label1),1,1);
		gridpane.add(ButtonControl.createButtonInt("2", Label1),2,1);
		gridpane.add(ButtonControl.createButtonInt("3", Label1),3,1);
		gridpane.add(ButtonControl.createButtonOp("/", Label1),4,1);
		gridpane.add(ButtonControl.createButtonInt("4", Label1),1,2);
		gridpane.add(ButtonControl.createButtonInt("5", Label1),2,2);
		gridpane.add(ButtonControl.createButtonInt("6", Label1),3,2);
		gridpane.add(ButtonControl.createButtonOp("x", Label1),4,2);
		gridpane.add(ButtonControl.createButtonInt("7", Label1),1,3);
		gridpane.add(ButtonControl.createButtonInt("8", Label1),2,3);
		gridpane.add(ButtonControl.createButtonInt("9", Label1),3,3);
		gridpane.add(ButtonControl.createButtonOp("-", Label1),4,3);
		gridpane.add(ButtonControl.createButtonInt("0", Label1),1,4);
		gridpane.add(ButtonControl.createButtonOp("+", Label1),4,4);
		gridpane.add(ButtonControl.createButtonC("C", Label1),3,4);
		gridpane.add(ButtonControl.createButtonRes("=", Label1),2,4);
		
		gridpane.setScaleX(2.0);
		gridpane.setScaleY(2.0);
		gridpane.setTranslateX(145);
		gridpane.setTranslateY(165);
		Label1.relocate(240, 75);
		Label1.setScaleX(2.2);
		Label1.setScaleY(2.2);
		Label1.setMaxWidth(85);
		
		scene.setFill(Color.ALICEBLUE);
		
		
		root.getChildren().addAll(Label1,gridpane);
		
		
		
		stage.show();
	}
	
	public static Label getLabelTemp() {
		return LabelTemp;
	}
}
