package calculator;

public class Power extends AbstractHandler {

    public Power(String s) {
        super(s);
    }

    @Override
    public void calculate(Operation r) {
        double result = Math.pow(r.getLeft(), r.getRight());
        System.out.println(r.getLeft() + " ^ " + r.getRight() + " = " + (result));
    }
}
