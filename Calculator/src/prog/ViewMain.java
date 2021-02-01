package prog;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;


public class ViewMain extends Application{

    Label Label1;
	
	GridPane gridpane;
	Group root;
	
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
	
	public void start(Stage stage) {
		stage.setTitle("James Calculator");
		Label1 = new Label("0");
		
	    root = new Group();
		Scene scene = new Scene(root,400,450);
		stage.setScene(scene);
		
		ButtonControl bc = new ButtonControl();
	    
		
		gridpane = new GridPane();
		
		HBox ap = new HBox();
		
		ap.setPrefHeight(55);
		ap.setPrefWidth(250);
		ap.setTranslateY(55);
		ap.setTranslateX(75);
		ap.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		ap.setStyle("-fx-background-color:  #f8f8ff; -fx-border-color: #737373;");
		ap.getChildren().add(Label1);
		
		gridpane.add(bc.createButtonInt("1", Label1),1,1);
		gridpane.add(bc.createButtonInt("2", Label1),2,1);
		gridpane.add(bc.createButtonInt("3", Label1),3,1);
		gridpane.add(bc.createButtonOp("/", Label1),4,1);
		gridpane.add(bc.createButtonInt("4", Label1),1,2);
		gridpane.add(bc.createButtonInt("5", Label1),2,2);
		gridpane.add(bc.createButtonInt("6", Label1),3,2);
		gridpane.add(bc.createButtonOp("x", Label1),4,2);
		gridpane.add(bc.createButtonInt("7", Label1),1,3);
		gridpane.add(bc.createButtonInt("8", Label1),2,3);
		gridpane.add(bc.createButtonInt("9", Label1),3,3);
		gridpane.add(bc.createButtonOp("-", Label1),4,3);
		gridpane.add(bc.createButtonInt("0", Label1),1,4);
		gridpane.add(bc.createButtonOp("+", Label1),4,4);
		gridpane.add(bc.createButtonC("C", Label1),3,4);
		gridpane.add(bc.createButtonRes("=", Label1),2,4);
		gridpane.add(ap, 4, 0);
		
		gridpane.setScaleX(2.0);
		gridpane.setScaleY(2.0);
		gridpane.setTranslateX(145);
		gridpane.setTranslateY(165);
		Label1.setScaleX(2.2);
		Label1.setScaleY(2.2);
		Label1.setTranslateX(80);
        Label1.setTranslateY(25);
		Label1.setPrefWidth(105);
		Label1.setStyle("-fx-color: #1c5f4c;");
		
		
		scene.setFill(Color.WHITESMOKE);
		root.getChildren().addAll(ap,gridpane);
		
		
		
		stage.show();
	}
	
	
}
