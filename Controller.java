package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

public class Controller {
    private CalculatorX calculatorX = new CalculatorX();

    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    private double[] currentRoots = new double[2];

    private String currentAnswerString = "";
    private static final String ONLY_ONE_ROOT_FORMAT = "x = %.3f";
    private static final String TWO_ROOTS_FORMAT = "x1 = %.3f; x2 = %.3f";

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private TextField inputC;

    @FXML
    private Button sumbitButton;

    @FXML
    private Label labelWelcome;

    @FXML
    private CheckBox isOnlySquareX;

    @FXML
    private CheckBox isUsingD1;

    @FXML
    private Text resultLabel;

    @FXML
    private Button buttonHelp;

    @FXML
    void initialize() {
        addHandlers();
    }


    private void addHandlers(){

        inputA.setOnKeyTyped(event -> {
            validateInputsCoefficient(inputA, isOnlySquareX.isSelected());
        });


        inputB.setOnKeyTyped(event -> {
            validateInputsCoefficient(inputB);
        });

        inputC.setOnKeyTyped(event -> {
            validateInputsCoefficient(inputC);
        });

        sumbitButton.setOnMouseClicked(event -> {
            coefficientA = Double.valueOf(inputA.getText());
            coefficientB = Double.valueOf(inputB.getText());
            coefficientC = Double.valueOf(inputC.getText());

            calculatorX.setA(coefficientA);
            calculatorX.setB(coefficientB);
            calculatorX.setC(coefficientC);

            try {
                currentRoots = calculatorX.getRoots();
                updateAnswerLabel();
            } catch (CalculatorX.DiscriminantAboveZeroException e){
                showErrorAsResult("Дискриминат ниже нуля!");
            }
        });
    }

    private void showErrorAsResult(String reason){
        resultLabel.setText(reason);
    }

    private void validateInputsCoefficient(TextField input){
        String textFromInput = input.getText();

        if (textFromInput.length() == 0){
            return;
        }

        try {
            double i = Double.valueOf(textFromInput);
            System.out.println(i);
        } catch (NumberFormatException e){
            System.out.println("hi");
            input.setText(textFromInput.substring(0, textFromInput.length() - 1));
            input.positionCaret(textFromInput.length() - 1);
        }
    }

    private void validateInputsCoefficient(TextField input, boolean cantBeZero){
        String textFromInput = input.getText();

        if (textFromInput.length() == 0){
            return;
        }

        try {
            double i = Double.valueOf(textFromInput);
            showErrorAsResult("");

            if (cantBeZero && i == 0d){
                showErrorAsResult("Старший коэффициент (a) не может быть равен 0!");
            }

        } catch (NumberFormatException e){
            input.setText(textFromInput.substring(0, textFromInput.length() - 1));
            input.positionCaret(textFromInput.length() - 1);
        }
    }

    private void updateAnswerLabel(){
            convertRootsToString();
            resultLabel.setText(currentAnswerString);
    }


    private void convertRootsToString(){
        double firstRoot = currentRoots[0], secondRoot = currentRoots[1];

        if (firstRoot == secondRoot){
            currentAnswerString = String.format(ONLY_ONE_ROOT_FORMAT, firstRoot);
        } else {
            currentAnswerString = String.format(TWO_ROOTS_FORMAT, firstRoot, secondRoot);
        }

    }

}
