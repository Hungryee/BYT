package calculator;

public class Division extends AbstractHandler {

    public Division(String s) {
        super(s);
    }

    @Override
    public void calculate(Operation r) {
        double result = r.getLeft()/r.getRight();
        System.out.println(r.getLeft() + " / " + r.getRight() + " = " + (result));
    }
}
