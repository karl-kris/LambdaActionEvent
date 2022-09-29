/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lambdaactionevent;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author usu2dam
 */
public class LambdaActionEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));

        
        Label interestRate = new Label("Annual interest rate: ");
        root.add(interestRate, 0, 1);        
        TextField interestTextField = new TextField();
        interestTextField.setAlignment(Pos.CENTER_RIGHT);
        root.add(interestTextField, 1, 1);
        
        Label numYears = new Label("Number of Years: ");
        root.add(numYears, 0, 2);        
        TextField yearsTextField = new TextField();
        yearsTextField.setAlignment(Pos.CENTER_RIGHT);
        root.add(yearsTextField, 1, 2);
        
        Label loanAmount = new Label("Loan Amount: ");
        root.add(loanAmount, 0, 3);       
        TextField loanTextField = new TextField();
        loanTextField.setAlignment(Pos.CENTER_RIGHT);
        root.add(loanTextField, 1, 3);
        
        Label monthlyPayment = new Label("Monthly payment: ");
        root.add(monthlyPayment, 0, 4);       
        TextField payTextField = new TextField();
        payTextField.setAlignment(Pos.CENTER_RIGHT);
        root.add(payTextField, 1, 4);
        
        Label total = new Label("Total payment: ");
        root.add(total, 0, 5);       
        TextField totalTextField = new TextField();
        totalTextField.setAlignment(Pos.CENTER_RIGHT);
        root.add(totalTextField, 1, 5);
        
        Button btn = new Button("Calculate");
        HBox hBtn = new HBox(10);
        hBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hBtn.getChildren().add(btn);
        root.add(hBtn, 1, 6);
        
        btn.setOnAction(e -> {
            double interest = Double.parseDouble(interestTextField.getText());
            int years = Integer.parseInt(yearsTextField.getText());
            double LoanAmount = Double.parseDouble(loanTextField.getText());
            
            double MonthInterest = interest / (100 * 12);
            double denominator = 1 - Math.pow((1+MonthInterest),(-12 * years));
            double MonthPay = (LoanAmount * MonthInterest)/denominator;
            double TotalPay = MonthPay * (years*12);
            payTextField.setText(String.format("$%.2f", MonthPay));
            totalTextField.setText(String.format("$%.2f", TotalPay));
        });
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
