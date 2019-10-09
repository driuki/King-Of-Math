package com.driuki.kingofmath;

import java.util.Random;

public class GameEngine {

    private static final int min = 1;
    private static final int max = 100;

    private int num1, num2, operator;

    private int personAnswer = 0;

    private StringBuilder equation = new StringBuilder();

    public GameEngine () {
    }

    // GETTERS AND SETTERS
    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setPersonAnswer(int personAnswer) {
        this.personAnswer = personAnswer;
    }

    // METHODS
    // This decides operator number. By it operator symbol is decided
    public void operatorNumber(){
        int randomOp = new Random().nextInt(4) + 1;

        if (randomOp == 1) {
            operator = 1;
        } else if (randomOp == 2) {
            operator = 2;
        } else if (randomOp == 3) {
            operator = 3;
        } else if (randomOp == 4) {
            operator = 4;
        }
    }

    // This sets random numbers to number 1 and 2. Checks the operator and if it is 4 starts -
    // divisionNumberGenerator() method.
    public void setNumbersRandom() {

        if (operator == 4) {
            divisionNumberGenerator();
        } else {
            setNum1(randomNumber());
            setNum2(randomNumber());
        }

    }

    // Generates random numbers from min to max
    private int randomNumber() {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    // This has to generate numbers for division
    private void divisionNumberGenerator() {
        Random random = new Random();

        int num1rand = random.nextInt(max) + min;
        setNum1(num1rand);

        boolean running = true;
        while (running) {
            secondRandomNumber();
            if (getNum1() % getNum2() != 0) {
                secondRandomNumber();
            } else {
                running = false;
            }
        }
    }

    // Starts random number generator
    private void secondRandomNumber() {
        Random random = new Random();
        int random2num = random.nextInt(num1) + min;
        setNum2(random2num);
    }

    // This return operator symbol
    public StringBuilder operatorStringBuilder() {
        StringBuilder symbol = null;
        if (operator == 1) {
            symbol = equation.append("+");
        } else if (operator == 2) {
            symbol = equation.append("-");
        } else if (operator == 3) {
            symbol = equation.append("*");
        } else if (operator == 4) {
            symbol = equation.append("/");
        }

        return symbol;
    }

    // This counts the result
    public int count() {
        int result = 0;

        if (operator == 1) {
            result = num1 + num2;
        } else if (operator == 2) {
            result = num1 - num2;
        } else if (operator == 3) {
            result = num1 * num2;
        } else if (operator == 4) {
            result = num1 / num2;
        }

        return result;
    }

    // This one check's whether result is equal to person's Answer
    public boolean checkResult() {
        return count() == personAnswer;
    }

    public String ansIfTrue() {
        String answer = "";

        if (checkResult()) {
            answer = "RIGHT ANSWER";
        } else if (!checkResult()){
            answer = "WRONG";
        }

        return answer;
    }

}