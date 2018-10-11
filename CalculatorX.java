package main;

public class CalculatorX {

    public class DiscriminantAboveZeroException extends RuntimeException  {};

    private double a;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double b;
    private double c;

    CalculatorX(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    CalculatorX(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double[] getRoots(){
        //  a * x * x + b * x + c = 0

        if (this.a == 0){
            return getRootsFromUsualX();
        }

        double discriminant = getDiscriminant();

        if (discriminant < 0){
            throw new DiscriminantAboveZeroException();
        }

        double firstRoot, secondRoot, tempB = this.b, tempA = this.a * 2;

        if (b % 2 == 0d){ // D1
            tempB = this.b / 2;
            tempA = this.a;
        }

        firstRoot = (-tempB + Math.sqrt(discriminant)) / tempA;
        secondRoot = (-tempB - Math.sqrt(discriminant)) / tempA;

        double answer[] = new double[2];
        answer[0] = firstRoot;
        answer[1] = secondRoot;

        return answer;
    }


    public double getDiscriminant(){
        if (b % 2 == 0d){ // D1
            return Math.pow(b / 2, 2) - a * c;
        } else {
            return Math.pow(b, 2) - 4 * a * c;
        }
    }

    public double[] getRootsFromUsualX(){
        double[] answer = new double[2];
        double root = (-this.c) / this.b;

        answer[0] = root;
        answer[1] = root;

        return answer;
    }

}
