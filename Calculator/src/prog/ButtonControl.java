package prog;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




public class ButtonControl {
	
	static Button butText1;
	static Button butText2;
	static Button butText3;
	static Button butText4;
	public Label labelTemp;
	public Label LabelTemp; 
	
	
	double tempInt;
	double result;
	String tmpOp;
	double tempInt2;
	boolean afterEq = false;
	public static final String ERROR = "error";
	
	public ButtonControl() {
		LabelTemp = new Label("");
	}
	
	private  Label getLabelTemp() {
		return LabelTemp;
	}
	
	public Button createButtonOp(String text,Label label) {
		labelTemp = getLabelTemp();
		butText1 = new Button(text);
		butText1.setMinWidth(30);
		butText1.setOnAction(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent event) {
	    		if(label.getText()==ERROR) { return; }
	    		if(labelTemp.getText()=="") {
	    			tempInt = tempInt2;
	    			label.setText(text);
	    			tmpOp=text;
	    		}
	    		else {
	    			tempInt = Double.valueOf(labelTemp.getText());
	    			tempInt2 = tempInt;
	    			label.setText(text);
	    			tmpOp=text;
	    			labelTemp.setText("");
	    		}
	    	}
	    });
	    return butText1;
	}
	
	
	public Button createButtonInt(String text, Label label) {
		labelTemp = getLabelTemp();
	    butText2 = new Button(text);
		
	    butText2.setOnAction(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent event) {
	    		String tempS;
	    		if(afterEq==true) {
	    			tempS = text;
	    			afterEq=false;
	    		}
	    		else{
	    			tempS = labelTemp.getText() + text;
	    		}
	    		label.setText(tempS);
	    		labelTemp.setText(tempS);
	    	}
	    });
	    return butText2;
	}

	public Button createButtonC(String text, Label label) {
	    butText3 = new Button(text);
		butText3.setOnAction(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent event) {
	    		tempInt = 0.0;
	    		label.setText("0");
	    		labelTemp.setText("");
	    	}
	    });
	    return butText3;
	}

	public  Button createButtonRes(String text, Label label) {
	    butText4 = new Button(text);
		butText4.setOnAction(new EventHandler<ActionEvent>() {
	    	public void handle(ActionEvent event) {
	    		labelTemp = getLabelTemp();
	    		double labTmpInt = Double.valueOf(labelTemp.getText()); 
	    		if(tmpOp.equals("+")) {  result = ButtonControl.sum(tempInt,labTmpInt); }
	    		if(tmpOp.equals("-")) {  result = ButtonControl.diff(tempInt,labTmpInt); }
	    		if(tmpOp.equals("x")) {  result = ButtonControl.mult(tempInt,labTmpInt); }
	    		if(tmpOp.contentEquals("/")) {  result = ButtonControl.div(tempInt,labTmpInt,label); }
	    		if(result==-1) {
	    			tmpOp = "";
	    			afterEq=true;
	    			labelTemp.setText(ERROR);
	    		}
	    		else
	    		{
	    		tmpOp = "";
	    		String resultInStr = String.valueOf(result) ;
	    		labelTemp.setText(resultInStr);
	    		label.setText(resultInStr);
	    		afterEq = true;
	    		}
	    	}
	    });
	    return butText4;
	}

	
	public static double sum(double x, double y) {
		double ris;
		ris = x+y;
		return ris;
	}
	
	public static double diff(double x, double y) {
		double ris;
		ris = x-y;
		return ris;
		
	}
	
	public static double mult(double x, double y) {
		double ris;
		ris = x*y;
		return ris;
	}
	
	public static double div(double x, double y, Label label ) {
		double ris;
		if(y==0) {
			label.setText(ERROR);
			return -1 ;
		}
		else {
		ris = x/y;
		return ris;
		}
	}
}
	