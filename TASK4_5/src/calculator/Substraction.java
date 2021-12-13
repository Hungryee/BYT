package calculator;

public class Substraction extends AbstractHandler {

    public Substraction(String s) {
        super(s);
    }

    @Override
    public void calculate(Operation r) {
        double result = r.getLeft()-r.getRight();
        System.out.println(r.getLeft() + " - " + r.getRight() + " = " + (result));
    }
}
