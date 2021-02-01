package prog;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;




public class ButtonControl {
	
	Button butText1;
	Button butText2;
	Button butText3;
	Button butText4;
	private Label labelTemp;
	
	
	private String add = "+";
	private String per = "x";
	private String min = "-";
	private String frac = "/";
	double tempInt;
	double result;
	String tmpOp;
	double tempInt2;
	boolean afterEq = false;
	public static final String ERROR = "error";
	
	public ButtonControl() {
		labelTemp = new Label("");
		tempInt=0.0;
		tempInt2=0.0;
		tmpOp="";
	}
	
	private  Label getLabelTemp() {
		return labelTemp;
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
	    			tempInt = Double.parseDouble(labelTemp.getText());
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
	    		if(label.getText().length()==9) {
    				return;
    			}
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
	    		tempInt2 = 0.0;
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
	    		if(box(label.getText())) {
	    			tmpOp = "";
	    			afterEq=true;
	    			labelTemp.setText(ERROR);
	    			label.setText(ERROR);
	    			tempInt = 0.0;
		    		tempInt2 = 0.0;
	    			return;
	    		}
	    		if(labelTemp.getText().equals("")||labelTemp.getText().equals(ERROR)) {return;}
	    		double labTmpInt = Double.valueOf(labelTemp.getText()); 
	    		
	    		if(tmpOp.equals(add)) {  result = sum(tempInt,labTmpInt); }
	    		if(tmpOp.equals(min)) {  result = diff(tempInt,labTmpInt); }
	    		if(tmpOp.equals(per)) {  result = mult(tempInt,labTmpInt); }
	    		if(tmpOp.equals(frac)) {  result = div(tempInt,labTmpInt,label); }
	    		if(result==-1) {
	    			tmpOp = "";
	    			afterEq=true;
	    			labelTemp.setText(ERROR);
	    			tempInt = 0.0;
		    		tempInt2 = 0.0;
	    		}
	    		else
	    		{
	    		tmpOp = "";
	    		String resultInStr = String.valueOf(result) ;
	    		labelTemp.setText(resultInStr);
	    		label.setText(resultInStr);
	    		afterEq = true;
	    		tempInt = 0.0;
	    		tempInt2 = 0.0;
	    		}
	    		
	    	}
	    });
	    return butText4;
	}

	
	private double sum(double x, double y) {
		double ris;
		ris = x+y;
		return ris;
	}
	
	private double diff(double x, double y) {
		double ris;
		ris = x-y;
		return ris;
		
	}
	
	private double mult(double x, double y) {
		double ris;
		ris = x*y;
		return ris;
	}
	
	private double div(double x, double y, Label label ) {
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
	
	private boolean box(String op) {
		int i;
		List<String> operators = new ArrayList<>();
		operators.add(add);
		operators.add(min);
		operators.add(per);
		operators.add(frac);
		
		for(i=0;i<4;i++) {
			if(op.equals(operators.get(i))){
				return true;
			}
		}
		return false;
	}
}
	