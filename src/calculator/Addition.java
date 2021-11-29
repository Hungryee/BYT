package calculator;

public class Addition extends AbstractHandler {

    public Addition(String s) {
        super(s);
    }

    @Override
    public void calculate(Operation r) {
        double result = r.getLeft()+r.getRight();
        System.out.println(r.getLeft() + " + " + r.getRight() + " = " + (result));
    }
}
